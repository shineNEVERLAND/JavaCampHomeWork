import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class OkHttpTest {
    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("http://localhost:9808").build();

        try {
            Response response = client.newCall(request).execute();
            int code = response.code();
            System.out.println(code);
            if (code == 200 && response.body() != null) {
                String resData = response.body().toString();
                System.out.println(resData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
