/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoalchemy;

import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyLanguage;
import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentSentiment;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Entities;
import com.ibm.watson.developer_cloud.alchemy.v1.model.TypedRelations;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Jaime Ambrosio
 */
public class AlchemyLanguageDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        AlchemyLanguage service = new AlchemyLanguage();
        service.setApiKey("2c9642caf5d75d2976e6b55637b3a8a23e5f910c");

        Map<String, Object> params = new HashMap<String, Object>();
        params.put(AlchemyLanguage.TEXT, "IBM es bueno");

        DocumentSentiment sentiment = service.getSentiment(params).execute();
        System.out.println("Sentimiento\n\n" + sentiment);

        
        Entities entities = service.getEntities(params).execute();
        System.out.println("Entidades: " + entities);

       
        TypedRelations relations = service.getTypedRelations(params).execute();
        System.out.println("Relaciones: " + relations);
    }

}
