/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoalchemy;

import com.cloudant.client.api.ClientBuilder;
import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author Jaime Ambrosio
 */
public class DemoCloudantClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            CloudantClient client = ClientBuilder.account("2efca010-d783-48ff-8b09-a85b380b66a3-bluemix")
                    .username("2efca010-d783-48ff-8b09-a85b380b66a3-bluemix")
                    .password("2f040ce083e86c585ae5638a7cdba89951097a8b8a9480544d9a3d18de955533")
                    .build();
            // Show the server version
            System.out.println("NICOOL ES LOCA - Server Version: " + client.serverVersion());
            // Get a List of all the databases this Cloudant account
            List<String> databases = client.getAllDbs();
            System.out.println("All my databases : ");
            for (String db : databases) {
                System.out.println(db);
            }

            Database db = client.database("becario", false);
            InputStream is = db.find("650cb18385ff988b236611625fcc3a3e");
            StringWriter writer = new StringWriter();
            IOUtils.copy(is, writer, "UTF-8");
            String theString = writer.toString();

            System.out.println(theString);
        } catch (IOException ex) {
            Logger.getLogger(DemoCloudantClient.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
