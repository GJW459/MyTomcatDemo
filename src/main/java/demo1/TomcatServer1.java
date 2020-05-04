package demo1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TomcatServer1 {
    public static void main(String[] args) throws IOException {

        //开启服务器Socket通道,开启8080端口
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("服务器启动成功");
        while (!serverSocket.isClosed()){
            //开启接收信息的功能,如果一直没有客户端的Socket请求连接,就会一直阻塞,使用Socket进行通信
            Socket accept = serverSocket.accept();
            //输入流
            InputStream inputStream = accept.getInputStream();
            OutputStream outputStream = accept.getOutputStream();
            System.out.println("执行客户请求"+Thread.currentThread());
            System.out.println("收到客户请求");
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String msg;
            while ((msg=reader.readLine())!=null){
                if (msg.length()==0){
                    break;
                }
                System.out.println(msg);
            }
            //返回响应信息,主题是OK
            String resultMsg="OK";
            outputStream.write(resultMsg.getBytes());
            System.out.println(resultMsg);
            reader.close();
            outputStream.close();

        }

    }
}
