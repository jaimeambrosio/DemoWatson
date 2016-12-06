/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoalchemy;

import com.ibm.watson.developer_cloud.language_translation.v2.LanguageTranslation;
import com.ibm.watson.developer_cloud.language_translation.v2.model.Language;
import com.ibm.watson.developer_cloud.language_translation.v2.model.TranslationResult;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jaime Ambrosio
 */
public class LanguageTranslationDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            LanguageTranslation service = new LanguageTranslation();
            service.setUsernameAndPassword("758eb76d-f371-4000-83a4-1546cf9a61cd", "LSwekEk7ckBP");

            // List<TranslationModel> models = service.getModels().execute();
            //  System.out.println(models);
            //     TranslationResult translationResult = service.translate("Hello ", Language.ENGLISH, Language.SPANISH).execute();
            List<String> listText = new ArrayList<String>();
            listText.add("1");
            listText.add("In this case.");
            listText.add("FEMALE");
            TranslationResult translationResult = service.translate(listText, Language.ENGLISH, Language.SPANISH).execute();
            System.out.println(translationResult);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
