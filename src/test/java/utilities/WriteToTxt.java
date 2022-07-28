package utilities;

import pojos.Appointment;
import pojos.Registrant;
import pojos.US01_RegistrantPojo;

import java.io.*;
import java.util.List;

public class WriteToTxt {

    public static void saveDataInFileWithPojo(String fileName, List<US01_RegistrantPojo> registrant) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            for (int i = 0; i < registrant.size(); i++) {
                writer.append(registrant.get(i).getFirstName() + " , " + registrant.get(i).getLastName() + " , " + registrant.get(i).getSsn() + "\n");
            }
            writer.close();
        } catch (Exception e) {

        }
    }

    public static void saveDataInFileWithRequest(US01_RegistrantPojo registrant) {
        try {
            File myObj = new File("US01_registrant_info.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        FileWriter fw = null;
        PrintWriter pw = null;
        try {
            fw = new FileWriter("US01_registrant_info.txt", true);
            pw = new PrintWriter(fw);

            pw.write(registrant.toString() + "\n");
            pw.close();
            fw.close();
        } catch (IOException e) {
            System.err.println("Error while writing to file: " +
                    e.getMessage());
        }
    }
    public static void saveRegistrantData(Registrant registrant){
        try{
            //src/resources/testdata/Registrantdata.txt
            FileWriter fileWriter = new FileWriter(ConfigurationReader.getProperty("api_registrant_data"), true);

            BufferedWriter writer = new BufferedWriter(fileWriter);


            writer.append(registrant+"\n");


            writer.close();



        }catch (Exception e){
            e.printStackTrace();
        }


    }

    public static void saveAppointData(Appointment appointment){

        try{

            //src/resources/testdata/Registrantdata.txt
            FileWriter fileWriter = new FileWriter(ConfigurationReader.getProperty("appointment_records"), true);

            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.append(appointment+"\n");


            writer.close();



        }catch (Exception e){
            e.printStackTrace();
        }


    }




    public static void saveRegistrantData(List<Object> SSNIds){
        try{
            //src/resources/testdata/Registrantdata.txt
            FileWriter fileWriter = new FileWriter(ConfigurationReader.getProperty("database_registrant_data"), false);

            BufferedWriter writer = new BufferedWriter(fileWriter);

            for(Object eachSSN: SSNIds) {
                writer.append(eachSSN + ",\n");
            }

            writer.close();



        }catch (Exception e){
            e.printStackTrace();
        }


    }
//
//
//    public static void saveRegistrantData(Registrant [] registrants){
//        try{
//            //src/resources/testdata/Registrantdata.txt
//            FileWriter fileWriter = new FileWriter(ConfigurationReader.getProperty("api_all_registrant_data"), false);
//
//            BufferedWriter writer = new BufferedWriter(fileWriter);
//
//
//            for(int i=0; i< registrants.length;i++) {
//                writer.append(registrants[i].getFirstName()+","+ registrants[i].getLastName()+","+registrants[i].getSsn()+","+ registrants[i].getLogin()+
//                        ","+ registrants[i].getId()+","+registrants[i].getEmail()+ "\n");
//            }
//
//            writer.close();
//
//
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//
//    }

//    public static void savePhysicianIds(String fileName, Physician[] physicians)  {
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false));
//
//            for (int i = 0; i < physicians.length ; i++) {
//                writer.append(physicians[i].getId()+",\n");
//            }
//
//
//            writer.close();
//        } catch(Exception e){
//
//        }
//    }

    public static void savePhysicianIds(String fileName, List<Object> id){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName,false));

            for (int i=0; i< id.size(); i++)
                writer.append(id.get(i).toString()+",\n");

            writer.close();
        } catch (IOException e){
        }
    }

    public static void savePhysicianName(String fileName, List<Object> firstname){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName,false));

            for (int i=0; i< firstname.size(); i++)
                writer.append(firstname.get(i).toString()+",\n");

            writer.close();
        } catch (IOException e){
        }
    }

}
