package demo2.ServletClass;

import Http.Request;
import Http.Response;

import java.io.OutputStream;
import java.io.OutputStreamWriter;

@WebServlet(url = "/xixi")
public class MyServlet2 extends HttpServlet {
    @Override
    public void doGet(Request request, Response response) throws Exception {
        this.doPost(request,response);
    }

    @Override
    public void doPost(Request request, Response response) throws Exception {
        OutputStream outputStream = response.getOutputStream();
        String msg=Response.RESPONSEBODY+"haha";
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream,"UTF-8");
        outputStreamWriter.write(msg);
        outputStreamWriter.flush();
        outputStreamWriter.close();
    }

    @Override
    public void init() throws Exception {

    }

    @Override
    public void destory() {

    }
}
