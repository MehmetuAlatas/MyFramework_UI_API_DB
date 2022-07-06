package utilities;

import pojos.US01_RegistrantPojo;
import pojos.US02_User_Registration_Pojo;

import java.io.*;

public class TXTWriter {
    public static void saveUIRegistrantData(US01_RegistrantPojo registrant){
        try{
            FileWriter fw = new FileWriter(ConfigurationReader.getProperty("applicant_data"),true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.append(registrant +"\n");
            bw.close();


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public static String ReadFile(String filepath) throws Exception
    {
        BufferedReader br
                = new BufferedReader(new FileReader(filepath));
        String st;
        String returnFileContent="";
        while ((st = br.readLine()) != null){
            returnFileContent = returnFileContent +st +"\n";
//            System.out.println(st);
        }
        return returnFileContent;
    }

    public static void SavePojoToFile(String filePath, Object pojoObj){
        try{
            FileWriter fw2 = new FileWriter(filePath,false);
            BufferedWriter bw = new BufferedWriter(fw2);
            bw.append(pojoObj +"\n");
            bw.close();


        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
