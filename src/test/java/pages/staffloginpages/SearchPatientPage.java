package pages.staffloginpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SearchPatientPage {
    public SearchPatientPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(name = "ssn")
    public WebElement ssnBox;
    @FindBy(xpath = "(//*[text()='Edit'])[12]")
    public WebElement editButton;
}
