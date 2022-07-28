package stepdefinitions.dbsteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.DBUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBReadSteps {

    @Given("user connectts to the database")
    public void user_connectts_to_the_database() {
        DBUtils.createConnection();
    }
    @Given("user gets the {string} from {string} table")
    public void user_gets_the_from_table(String column, String table) {
        String myDynamicQuery = "Select " + column + " from " + table;
        DBUtils.executeQuery(myDynamicQuery);

    }
    @Given("user read all of the {string} column data")
    public void user_read_all_of_the_column_data(String column) throws SQLException {
//        DBUtils.getResultset().next();
//
//        Object columnData = DBUtils.getResultset().getObject(column);
//        System.out.println(columnData); //anonymoususer tablodaki 1. kullanici
//
//        DBUtils.getResultset().next();
//        Object columnData2 = DBUtils.getResultset().getObject(column);
//        System.out.println(columnData2); //bakalim tablodaki 2. kullanici
//
//        DBUtils.getResultset().next();
//        Object columnData3 = DBUtils.getResultset().getObject(column);
//        System.out.println(columnData3); //systema tablodaki 3. kullanici

//        while (DBUtils.getResultset().next()){
//            Object eachColumnData = DBUtils.getResultset().getObject(column);
//            System.out.println(eachColumnData);
//        }

    }
    @Given("verify {string} table {string} column contains {string}")
    public void verify_table_column_contains(String table, String column, String data) {
        List<Object> allColumnData = DBUtils.getColumnData("Select * from jhi_user", "login");
        System.out.println(allColumnData);

        List<Object> expectedDta = new ArrayList<>();
        expectedDta.add(data);

        Assert.assertTrue(allColumnData.containsAll(expectedDta));

    }

    @Then("close the database connection")
    public void close_the_database_connection() {
        DBUtils.closeConnection();

    }
}
