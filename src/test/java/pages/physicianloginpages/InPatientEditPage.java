package pages.physicianloginpages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class InPatientEditPage {

    public InPatientEditPage() {

        PageFactory.initElements(Driver.getDriver(),this);
    }
}
