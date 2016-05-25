package akahane;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Created by n.akahane on 2016/05/25.
 */
@ApplicationScoped
public class FeedManager {

    @Inject
    private Converter converter;

    @Inject
    private Writer writer;

    public void output(String url){



        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet getMethod = new HttpGet("http://localhost:8080/get?param=value");

            try (CloseableHttpResponse response = httpClient.execute(getMethod)) {
                if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                    HttpEntity entity = response.getEntity();
                    System.out.println(EntityUtils.toString(entity,
                            StandardCharsets.UTF_8));
                }
                else{
                    //error
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }



        String hoge = converter.convert("");
    }


}
