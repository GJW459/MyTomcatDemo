package Http;

import java.io.OutputStream;

public class Response {

    private OutputStream outputStream;
    public static final String RESPONSEBODY="HTTP/1.1 200\r\n"+"Content-Type：text/html\r\n"
            +"\r\n";

    public Response(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public OutputStream getOutputStream() {
        return outputStream;
    }

    public void setOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }
}
