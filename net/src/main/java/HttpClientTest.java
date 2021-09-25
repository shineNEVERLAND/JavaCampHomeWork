import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpClientTest {
    public static void main(String[] args) throws IOException {
        // 1.获取http对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 2.创建get对象
        HttpGet get = new HttpGet("http://localhost:9808");
        // 3.执行请求
        HttpResponse response = httpclient.execute(get);
        // 4.打印response中的信息
        System.out.println("响应信息: " + response.getStatusLine());
        System.out.println("响应码: " + response.getStatusLine().getStatusCode());
        System.out.println("协议: " + response.getProtocolVersion());
        // 5.获取响应的信息
        HttpEntity entity = response.getEntity();
        String data = EntityUtils.toString(entity, "utf-8");
        System.out.println("data = " + data);
    }
}
