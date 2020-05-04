package demo1;

import Http.Response;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TomcatServer2 {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(8081);
        System.out.println("服务器启动成功");
        while (!serverSocket.isClosed()){

            Socket accept = serverSocket.accept();
            InputStream inputStream = accept.getInputStream();
            OutputStream outputStream = accept.getOutputStream();
            System.out.println("执行客户请求"+Thread.currentThread());
            System.out.println("收到用户请求");
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String msg;
            while ((msg=reader.readLine())!=null){
                if (msg.length()==0){
                    break;
                }
                System.out.println(msg);
            }
            String resultMsg="OK";
            outputStream.write((Response.RESPONSEBODY+resultMsg).getBytes());
            reader.close();
            outputStream.close();

        }

    }
}
