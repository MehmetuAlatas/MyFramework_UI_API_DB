package stepdefinitions;

import io.cucumber.java.en.Given;
import pojos.Registrant;
import pojos.TestItem;
import utilities.DBUtils;

import java.util.ArrayList;
import java.util.List;

import static utilities.PDFGenerator.pdfGeneratorRowsAndCellsWithList;

public class PDFSteps {

    @Given("DB'e baglan {string} and {string} , {string}")
    public void db_e_baglan_and(String url, String user, String password) {
        DBUtils.createConnection();
    }
    @Given("pdf olusturmak icin {string} yap")
    public void pdf_olusturmak_icin_yap(String query) {
        List<TestItem> testItemsList = new ArrayList<>();

        List<List<Object>> lists = DBUtils.getQueryResultList(query);

        for(int i = 0; i<=5; i++){

            TestItem testItem = new TestItem();

            testItem.setName(lists.get(1).toString());
            testItem.setDescription(lists.get(2).toString());
            testItem.setDefaultValMin(lists.get(4).toString());
            testItem.setDefaultValMax(lists.get(5).toString());


            testItemsList.add(testItem);
        }
        pdfGeneratorRowsAndCellsWithList("Medunna Deneme25 Kullanici Listes,", testItemsList,"deneme4.pdf");



    }
}
