package stepdefinitions.dbsteps;

import org.junit.Assert;
import org.junit.Test;
import utilities.DatabaseUtility;
import utilities.ReadTxt;
import utilities.WriteToTxt;

import java.util.ArrayList;
import java.util.List;

import static utilities.DatabaseUtility.getColumnData;

public class DBTest {

    @Test
    public void test(){

        //DATABASE iLE BAGLANTI KUR

        String url = "jdbc:postgresql://medunna.com:5432/medunna_db";
        String username = "medunnadb_user";
        String password = "Medunnadb_@129";

        DatabaseUtility.createConnection(url,username, password);

        String query = "select * from physician";
        System.out.println(DatabaseUtility.getColumnNames(query)  + "\n");
        //SUTUN iSiMLERi
        //[id, first_name, last_name, birth_date, phone, gender, blood_group, adress, description, created_date, user_id, country_id, cstate_id, created_by, last_modified_by, last_modified_date, speciality, exam_fee, image, image_content_type]

        //ID'LERE ULASMA VE KAYDETME
        System.out.println("=====================ID LIST==================");
        List<Object> idList = getColumnData(query, "id");
        System.out.println(idList + "\n");
        String fileName1 = "src/test/resources/testdata/DoktorID.txt";
        WriteToTxt.savePhysicianIds(fileName1, idList);


        //ID'LERi DOGRULAMA
        List<Object> actualPhysicianIDs = ReadTxt.returnPhysicianIDsList(fileName1);
        List<Object> expectedPhysicianIDs = new ArrayList<>();
        expectedPhysicianIDs.add(42999);

        Assert.assertTrue("IDLER UYUSMUYOR", actualPhysicianIDs.containsAll(expectedPhysicianIDs));


        //DOKTOR isimlerine ULASMA VE KAYDETME
        System.out.println("=====================PHYSiCiAN LIST==================");
        List<Object> nameList = getColumnData(query, "first_name");
        System.out.println(nameList + "\n");
        String fileName2 = "src/test/resources/testdata/DoktorName.txt";
        WriteToTxt.savePhysicianName(fileName2, nameList);


        //isimleri DOGRULAMA
        List<String > actualPhysicianNames = ReadTxt.returnPhysicianName(fileName2);
        List<String > expectedPhysicianNames = new ArrayList<>();
        expectedPhysicianIDs.add("Murat");
        expectedPhysicianIDs.add("Mustafa");

        Assert.assertTrue("iSiMLER UYUSMUYOR", actualPhysicianNames.containsAll(expectedPhysicianNames));

    }
}