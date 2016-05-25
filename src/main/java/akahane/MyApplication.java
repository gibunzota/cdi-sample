package akahane;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import javax.inject.Inject;

/**
 * Created by n.akahane on 2016/05/24.
 */

public class MyApplication {
    public static void main(String[] args) {
        //DIコンテナの初期化
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();
        MyApplication app = container.instance().select(MyApplication.class).get();

        //処理実行
        app.run();

        //終了処理
        weld.shutdown();
    }


    @Inject
    private FeedManager manager;

    public void run() {

        manager.output("");
    }
}
