package demo1;

import Http.Response;

import java.io.*;
import java.net.Socket;

public class RequestHandler implements Runnable {
    private Socket socket;

    public RequestHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream inputStream;
        try {
            inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
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
            outputStream.flush();
            reader.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
