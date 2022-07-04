package pages.adminloginpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PatientPage {
    public PatientPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@id='jh-create-entity']")
    public WebElement createNewPatient;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/div/div/div[2]")
    public WebElement createAlert;
}
