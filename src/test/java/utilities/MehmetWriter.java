package utilities;

import pojos.MehmetPojo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class MehmetWriter {

    public static void savingUiRegistrant(MehmetPojo mehmetPojo) {

        FileWriter fileWriter;

        {
            try {
                fileWriter = new FileWriter(ConfigurationReader.getProperty("mehmet_registrant"), true);
                //this is for file creation

                BufferedWriter bw = new BufferedWriter(fileWriter);
                bw.append(mehmetPojo.toString() + "\n");
                bw.close();


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void savingUiRegistrant(MehmetPojo [] mehmetPojos) {

        FileWriter fileWriter;

        {
            try {
                fileWriter = new FileWriter(ConfigurationReader.getProperty("mehmet_GetApi"), true);
                //this is for file creation

                BufferedWriter bw = new BufferedWriter(fileWriter);
                for (int i = 0; i <mehmetPojos.length ; i++) {
                    bw.append(mehmetPojos[i].toString()+"\n");

                }
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
