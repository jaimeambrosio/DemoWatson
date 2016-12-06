/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoalchemy;

import com.ibm.watson.developer_cloud.text_to_speech.v1.TextToSpeech;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.AudioFormat;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Voice;
import com.ibm.watson.developer_cloud.text_to_speech.v1.util.WaveUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jaime Ambrosio
 */
public class TextToSpeechDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TextToSpeech synthesizer = new TextToSpeech();
        synthesizer.setUsernameAndPassword("1b9f5dc9-b0eb-454f-84ae-6e404dac4ce7", "ci26pX1VmqSw");

        // List<Voice> voices = service.getVoices().execute();
        //  System.out.println(voices);
        InputStream in = synthesizer.synthesize("Hola ¿Cómo estas Jaime?", Voice.ES_ENRIQUE, AudioFormat.WAV).execute();
        try {
            writeToFile(WaveUtils.reWriteWaveHeader(in), new File("output.wav"));
        } catch (IOException ex) {
            Logger.getLogger(TextToSpeechDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void writeToFile(InputStream in, File file) {
        try {
            OutputStream out = new FileOutputStream(file);
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            out.close();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
