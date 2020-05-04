package demo2.ServletClass;

import Http.Request;
import Http.Response;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

@WebServlet(url = "/hello")
public class MyServlet extends HttpServlet {
    @Override
    public void doGet(Request request, Response response) throws IOException {
        this.doPost(request,response);
    }

    @Override
    public void doPost(Request request, Response response) throws IOException {

        OutputStream outputStream = response.getOutputStream();
        String str=Response.RESPONSEBODY+"嘻嘻";
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream,"UTF-8");
        outputStreamWriter.write(str);
        outputStreamWriter.flush();
        outputStreamWriter.close();
    }

    public void init() throws Exception {

    }

    public void destory() {

    }
}
