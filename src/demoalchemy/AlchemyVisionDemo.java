/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoalchemy;

import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyVision;
import com.ibm.watson.developer_cloud.alchemy.v1.model.ImageFaces;
import com.ibm.watson.developer_cloud.alchemy.v1.model.ImageKeywords;
import java.io.File;

/**
 *
 * @author Jaime Ambrosio
 */
public class AlchemyVisionDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AlchemyVision service = new AlchemyVision();
        service.setApiKey("2c9642caf5d75d2976e6b55637b3a8a23e5f910c");
        File image = new File("C:\\Users\\Jaime Ambrosio\\Desktop\\img\\mario.jpg");

        Boolean forceShowAll = true;
        Boolean knowledgeGraph = true;
        try {
            ImageKeywords keywords = service.getImageKeywords(image, forceShowAll, knowledgeGraph).execute();
            System.out.println(keywords);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("_______________");
        try {
            ImageFaces faces = service.recognizeFaces(image, true).execute();
            System.out.println(faces);
        } catch (Exception e) {
              System.out.println(e.getMessage());
        }

    }

}
