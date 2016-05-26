package akahane;

public class FeedApplication {
    public static void main(String[] args) {
        //処理実行
        run();
    }

    public static void run() {
        FeedManager manager = new FeedManager();
        manager.output("http://intarfrm-dev.feast.css.fujitsu.com:8080/jenkins/rssLatest");
    }
}
