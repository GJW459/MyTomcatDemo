package demo2.ServletClass;

import Http.Request;
import Http.Response;

public  abstract class HttpServlet implements Servlet {
    @Override
    public void service(Request request, Response response) throws Exception {
        String method = request.getMethod();
        if ("get".equalsIgnoreCase(method)){
            this.doGet(request,response);
        }else if ("post".equalsIgnoreCase(method)){
            this.doPost(request,response);
        }
    }
    public abstract void doGet(Request request,Response response) throws Exception;
    public abstract void doPost(Request request,Response response) throws Exception;
}
