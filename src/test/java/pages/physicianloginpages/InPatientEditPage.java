package pages.physicianloginpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class InPatientEditPage {

    public InPatientEditPage() {

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "in-patient-description")
    public WebElement descriptionInputBox;

    @FindBy(id = "save-entity")
    public WebElement saveButton;

    @FindBy(xpath = "//input[@id='in-patient-id']")
    public WebElement idInputInEditPage;

}
