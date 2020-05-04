package socket;

import Http.Request;
import Http.Response;
import demo2.ServletClass.HttpServlet;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class RequestHandler implements Runnable {

    private Socket socket;

    public RequestHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            Request request = new Request(socket.getInputStream());
            Response response = new Response(socket.getOutputStream());
            String url = request.getUrl();
            //获取map中的HttpServlet的子类
            HttpServlet httpServlet = MyTomcat.map.get(url);
            if(httpServlet!=null){
                httpServlet.service(request,response);
            }else {
                String responseBody=Response.RESPONSEBODY+"can not find servlet";
                OutputStream outputStream = socket.getOutputStream();
                outputStream.write(responseBody.getBytes());
                outputStream.flush();
                outputStream.close();
            }
        }
         catch (Exception e) {
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
