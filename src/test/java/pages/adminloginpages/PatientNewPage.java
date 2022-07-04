package pages.adminloginpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PatientNewPage {
    public PatientNewPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//*[@name='firstName']")
    public WebElement firstNameBox;
    @FindBy(xpath = "//*[@name='lastName']")
    public WebElement lastNameBox;
    @FindBy(xpath = "//*[@name='birthDate']" )
    public WebElement birthDatePlaceHolder;
    @FindBy(xpath = "//*[@name='email']")
    public WebElement emailBox;
    @FindBy(xpath = "//*[@name='phone']")
    public WebElement phoneBox;
    @FindBy(xpath = "//*[@name='gender']")
    public WebElement genderDropDown;
    @FindBy(xpath = "//*[@name='bloodGroup']")
    public WebElement bloodGroupDropDown;
    @FindBy(xpath = "//*[@name='adress']")
    public WebElement adressBox;
    @FindBy(xpath = "//*[@id='patient-description']")
    public WebElement descriptionBox;
    @FindBy(xpath = "//*[@name='user.id']/option[1]")
    public WebElement userDropDown;
    @FindBy(xpath = "//*[@name='country.id']/option[@value='80065']")
    public WebElement countryUSA;
    @FindBy(xpath = "//*[@name='cstate.id']/option[@value='43522']")
    public WebElement stateCA;
    @FindBy(xpath = "//*[@type='submit']")
    public WebElement submitButton;

}
