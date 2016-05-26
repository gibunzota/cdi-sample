package akahane;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FeedManager {

    private Converter converter;
    private Writer writer;

    public FeedManager(){
        //Converterのインスタンスをセット
        ConverterFactory converterFactory = new ConverterFactory();
        converter = converterFactory.create();

        //Writerのインスタンスをセット
        WriterFactory writerFactory = new WriterFactory();
        writer = writerFactory.create();
    }

    public void output(String url) {

        try {
            //Feedを取得
            String data = getFeedData(url);

            //変換して出力
            writer.write(converter.convert(data));
        }
        catch (Exception e){
            //エラー出力
            e.printStackTrace();
        }
    }

    private String getFeedData(String url) {
        String data = null;
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet getMethod = new HttpGet(url);

            try (CloseableHttpResponse response = httpClient.execute(getMethod)) {
                if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                    HttpEntity entity = response.getEntity();
                    data = EntityUtils.toString(entity, StandardCharsets.UTF_8);
                } else {
                    //エラー
                    System.err.println("Feed Response Error");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

}
