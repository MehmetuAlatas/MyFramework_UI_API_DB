package pages.adminloginpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PatientEditPage {
    @FindBy(xpath = "//*[@name='firstName']")
    public WebElement firstName;
    @FindBy(xpath = "//*[@id='patient-lastName']")
    public WebElement lastName;
    @FindBy(xpath = "//*[@id='patient-birthDate']")
    public WebElement birthDate;
    @FindBy(xpath = "//*[@id='email']")
    public WebElement email;
    @FindBy(xpath = "//*[@id='patient-phone']")
    public WebElement phone;
    @FindBy(xpath = "//*[@id='patient-gender']")
    public WebElement gender;
    @FindBy(xpath = "//*[@id='patient-bloodGroup']")
    public WebElement bloodGroup;
    @FindBy(xpath = "//*[@id='patient-adress']")
    public WebElement adress;
    @FindBy(xpath = "//*[@id='patient-description']")
    public WebElement description;
    @FindBy(xpath = "//*[@id='patient-user']")
    public WebElement user;
    @FindBy(xpath = "//*[@id='patient-country']")
    public WebElement country;
    @FindBy(xpath = "//*[@id='patient-cstate']")
    public WebElement cstate;

    public PatientEditPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


}
