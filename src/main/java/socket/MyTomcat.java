package socket;

import demo2.ServletClass.HttpServlet;
import demo2.ServletClass.WebServlet;
import org.junit.Test;
import org.reflections.Reflections;
import org.reflections.scanners.*;
import org.reflections.util.ConfigurationBuilder;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.Set;

public class MyTomcat {

    public static final int port =13145;
    public static final Map<String, HttpServlet> map=new HashMap<>();

    public static void main(String[] args) throws Exception {

        MyTomcat myTomcat = new MyTomcat();
        //初始化Servlet配置
        myTomcat.init();
        myTomcat.run();//启动容器

    }

    /**
     * 初始化Servlet配置
     */
    @Test
    public void init() throws Exception{
        Reflections reflections = new Reflections(new ConfigurationBuilder()
                // 指定路径URL
                .forPackages("demo2.ServletClass")
                // 添加注解扫描工具
                .addScanners(new SubTypesScanner())
        );
        Set<Class<?>> typesAnnotatedWith = reflections.getTypesAnnotatedWith(WebServlet.class);
        for (Class<?> aClass : typesAnnotatedWith) {
            System.out.println(aClass);
            WebServlet annotation = aClass.getAnnotation(WebServlet.class);
            System.out.println(annotation.url());
            map.put(annotation.url(),(HttpServlet) aClass.newInstance());
        }

    }
    //启动Tomcat容器
    public void run() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("开启Tomcat容器");
        while (!serverSocket.isClosed()){
            Socket accept = serverSocket.accept();
            RequestHandler requestHandler = new RequestHandler(accept);
            new Thread(requestHandler).start();
        }
    }
}
