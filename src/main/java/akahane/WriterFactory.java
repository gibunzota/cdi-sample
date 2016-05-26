package akahane;

/**
 * Created by n.akahane on 2016/05/26.
 */
public class WriterFactory {

    public Writer create() {
        //拡張した場合適切なインスタンスを返却するように変更する
        return new ConsoleWriter();
    }

}