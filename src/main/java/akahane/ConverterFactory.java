package akahane;

/**
 * Created by n.akahane on 2016/05/26.
 */
public class ConverterFactory {

    public Converter create() {
        //拡張した場合適切なインスタンスを返却するように変更する
        return new ReplaceConverter();
    }

}