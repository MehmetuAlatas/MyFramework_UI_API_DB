package pages.adminloginpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PatientPage {
    public PatientPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[text()=107939]")
    public WebElement patientID;

    @FindBy(xpath = "//*[@id='jh-create-entity']")
    public WebElement createNewPatient;
    @FindBy(xpath = "//div[@role='alert']")
    public WebElement createAlert;

    @FindBy(id = "patient-heading")
    public WebElement patientTitle;
    @FindBy(xpath = "(//a[@href='javascript:void(0)'])[8]")
    public WebElement lastPage;
    @FindBy(xpath = "//*[text()='Edit']")
    public WebElement editButton;



}
