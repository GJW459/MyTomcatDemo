package Http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Request {

    private String url;
    private String method;

    public Request(InputStream inputStream){
        try {
            BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
            //读取第一行数据 请求方法 请求路径 http版本号
            String[] data = reader.readLine().split(" ");
            this.method=data[0];
            this.url=data[1];
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
