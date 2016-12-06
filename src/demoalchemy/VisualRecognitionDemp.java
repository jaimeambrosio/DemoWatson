/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoalchemy;

import com.ibm.watson.developer_cloud.visual_recognition.v3.VisualRecognition;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifyImagesOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.DetectedFaces;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.VisualClassification;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.VisualRecognitionOptions;
import java.io.File;

/**
 *
 * @author Jaime Ambrosio
 */
public class VisualRecognitionDemp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        File f = new File("C:\\Users\\Jaime Ambrosio\\Desktop\\img\\jaime2.jpg");
       
        VisualRecognition service = new VisualRecognition(VisualRecognition.VERSION_DATE_2016_05_20);
        service.setApiKey("0b64e9b8a7ef099e381c1c70c37108d605d0867d");

        System.out.println("Classify an image");
        ClassifyImagesOptions options = new ClassifyImagesOptions.Builder().images(f)
                .build();
        VisualClassification result = service.classify(options).execute();
        System.out.println(result);
        
        
        System.out.println("Visual");
        VisualRecognitionOptions options2 =new VisualRecognitionOptions.Builder().images(f).build();
        DetectedFaces detectedFaces = service.detectFaces(options2).execute();
        System.out.println(detectedFaces);
        
        
    }

}
