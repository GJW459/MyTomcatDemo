package demo2.ServletClass;

import Http.Request;
import Http.Response;

public interface Servlet {
    void init() throws Exception;
    void service(Request request, Response response) throws Exception;
    void destory();
}
