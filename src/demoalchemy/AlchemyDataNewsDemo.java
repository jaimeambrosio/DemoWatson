/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoalchemy;

import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyDataNews;
import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentsResult;
import com.sun.xml.internal.ws.util.StringUtils;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Jaime Ambrosio
 */
public class AlchemyDataNewsDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AlchemyDataNews service = new AlchemyDataNews();
        service.setApiKey("2c9642caf5d75d2976e6b55637b3a8a23e5f910c");

        Map<String, Object> params = new HashMap<String, Object>();

        String[] fields
                = new String[]{"enriched.url.title", "enriched.url.url", "enriched.url.author",
                    "enriched.url.publicationDate", "enriched.url.enrichedTitle.entities",
                    "enriched.url.enrichedTitle.docSentiment"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < fields.length - 1; i++) {
            sb.append(fields[i]).append(",");
        }
        sb.append(fields[fields.length - 1]);
        params.put(AlchemyDataNews.RETURN, sb.toString());
        params.put(AlchemyDataNews.START, "1440720000");
        params.put(AlchemyDataNews.END, "1441407600");
        params.put(AlchemyDataNews.COUNT, 7);

        DocumentsResult result = service.getNewsDocuments(params).execute();

        System.out.println(result);
    }

}
