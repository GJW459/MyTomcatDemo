package demo1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 利用BIO模型改变一次只能连接一个的弊端
 */
public class TomcatServer3 {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(8083);
        System.out.println("服务器启动");
        while (!serverSocket.isClosed()){
            Socket accept = serverSocket.accept();
            RequestHandler requestHandler = new RequestHandler(accept);
            //开启一个线程
            new Thread(requestHandler).start();
        }
    }
}
