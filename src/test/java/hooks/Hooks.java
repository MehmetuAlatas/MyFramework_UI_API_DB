package hooks;

import com.sun.tools.jxc.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.RegistrationPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class Hooks {
    RegistrationPage registrationPage;
    public static RequestSpecification spec;

    @Before(value = "@Api")
    public void baseUrlSetUp() {
        spec = new RequestSpecBuilder().setBaseUri(ConfigurationReader.getProperty("base_url")).build();

    }


    @Before
    public void setUp() {
        Driver.getDriver().get(ConfigurationReader.getProperty("medunna_login_url"));
    }


    @After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshot, "image/png", "screenshots");
        }


        Driver.closeDriver();
    }

}
