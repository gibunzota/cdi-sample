package akahane;

import org.dom4j.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by n.akahane on 2016/05/25.
 */

public class ReplaceConverter implements Converter {
    @Override
    public String convert(String data) {

        return getEntryList(data).replace("intarfrm", "*****");
    }

    private String getEntryList(String data) {
        StringBuilder sb = new StringBuilder();

        try {
            Document document = DocumentHelper.parseText(data);
            Map<String, String> namespaceUris = new HashMap<>();
            namespaceUris.put("atom", "http://www.w3.org/2005/Atom");
            XPath xPath = DocumentHelper.createXPath("//atom:entry");
            xPath.setNamespaceURIs(namespaceUris);

            List nodes = xPath.selectNodes(document);
            nodes.stream().filter(object -> object instanceof Element).forEach(object -> {
                sb.append(
                        String.format("%s : %s\n",
                                ((Element) object).element("title").getText(),
                                ((Element) object).element("link").attribute("href").getValue())
                );
            });
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }
}
