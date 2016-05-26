package akahane;

import org.dom4j.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReplaceConverter implements Converter {
    @Override
    public String convert(String data) {
        //Feedからエントリーを取り出して置換
        return getEntryList(data).replace("intarfrm", "*****");
    }

    private String getEntryList(String data) {
        //FeedのXMLからエントリーを抽出
        StringBuilder sb = new StringBuilder();

        try {
            Document document = DocumentHelper.parseText(data);
            Map<String, String> namespaceUris = new HashMap<>();
            namespaceUris.put("atom", "http://www.w3.org/2005/Atom");
            XPath xPath = DocumentHelper.createXPath("//atom:entry");
            xPath.setNamespaceURIs(namespaceUris);

            List nodes = xPath.selectNodes(document);
            nodes.stream()
                    .filter(object -> object instanceof Element)
                    .forEach(object -> {
                        String entry =
                                String.format("%s : %s\n",
                                        ((Element) object).element("title").getText(),
                                        ((Element) object).element("link").attribute("href").getValue());
                        sb.append(entry);
                    });
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }
}
