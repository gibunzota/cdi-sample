package akahane;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import javax.inject.Inject;

/**
 * Created by n.akahane on 2016/05/24.
 */

public class MyApplication {
    public static void main(String[] args) {
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();
        MyApplication app = container.instance().select(MyApplication.class).get();
        app.run();
        weld.shutdown();
    }


    @Inject
    private Speaker speaker;

    public void run() {
        speaker.speak();
    }
}
