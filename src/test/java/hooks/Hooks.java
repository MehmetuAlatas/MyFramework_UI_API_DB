package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.RegistrationPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class Hooks {
    RegistrationPage registrationPage;
    @Before
    public void setUp(){
        Driver.getDriver().get(ConfigurationReader.getProperty("medunna_login_url"));
    }

    @After
    public void tearDown(Scenario scenario){

        if (scenario.isFailed()) {
            final byte[] screenshot=((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshot, "image/png","screenshots");
        }
        Driver.closeDriver();

    }

}
