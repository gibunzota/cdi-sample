package akahane;

/**
 * Created by n.akahane on 2016/05/25.
 */
public class ConsoleWriter implements Writer {
    @Override
    public void write(String data) {
        //標準出力
        System.out.println(data);
    }
}
