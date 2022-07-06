package utilities;

import pojos.MehmetPojo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class MehmetWriter {

    public static void savingUiRegistrant(MehmetPojo registrant) {

        FileWriter fileWriter;

        {
            try {
                fileWriter = new FileWriter(ConfigurationReader.getProperty("mehmet_registrant"), true);
                //this is for file creation

                BufferedWriter bw = new BufferedWriter(fileWriter);
                bw.append(registrant.toString() + "\n");
                bw.close();


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
