package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class RegistrationPage {

    public RegistrationPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//li[@id='account-menu']")
    public WebElement accountMenu;

    @FindBy(xpath = "//h1[@id='register-title']")
    public WebElement registrationTitle;

    @FindBy(xpath = "//*[text()='Register']")
    public WebElement registerMenu;

    @FindBy(xpath = "//input[@id='ssn']")
    public WebElement ssnBox;

    @FindBy(xpath = "//input[@id='firstName']")
    public WebElement firstnameBox;

    @FindBy(xpath = "//input[@id='lastName']")
    public WebElement lastnameBox;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement usernameTextbox;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailTextbox;

    @FindBy(xpath = "//input[@id='firstPassword']")
    public WebElement firstPasswordTextbox;

    @FindBy(xpath = "//input[@id='secondPassword']")
    public WebElement secondPasswordTextbox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButton;

//    CONFIRMATION OR REJECTION MESSAGES

    @FindBy(xpath = "//*[contains(text(),'Registration Saved')]")
    public WebElement registrationSavedMessage;

    @FindBy(xpath = "//*[contains(text(),'Login name already used!')]")
    public WebElement usernameAlreadyUsedMessage;

    @FindBy(xpath = "//*[contains(text(),'Email is already in use!')]")
    public WebElement emailAlreadyUsedMessage;

    @FindBy(xpath = "//*[contains(text(),'This SSN has been registered for another user!')]")
    public WebElement snnALredyUsedMessage;



//  EMAIL STRENGTH

    @FindBy(xpath = "(//li[@class='point'])[1]")
    public WebElement firstBar;

    @FindBy(xpath = "(//li[@class='point'])[2]")
    public WebElement secondBar;

    @FindBy(xpath = "(//li[@class='point'])[3]")
    public WebElement thirdBar;

    @FindBy(xpath = "(//li[@class='point'])[4]")
    public WebElement forthBar;

    @FindBy(xpath = "(//li[@class='point'])[5]")
    public WebElement fifthBar;


//     ERROR MESSAGES ELEMENTS


    @FindBy(xpath = "(//label)[1]")
    public WebElement snnLabel;

    @FindBy(xpath = "(//label)[2]")
    public WebElement firstnameTLabel;

    @FindBy(xpath = "(//label)[3]")
    public WebElement lastnameLabel;

    @FindBy(xpath = "(//label)[4]")
    public WebElement usernameLabel;

    @FindBy(xpath = "(//label)[5]")
    public WebElement emailLabel;

    @FindBy(xpath = "(//label)[6]")
    public WebElement newPasswordTLabel;

    @FindBy(xpath = "(//label)[7]")
    public WebElement newPasswordConfirmationLabel;

    //US1 Locators
    @FindBy(xpath = "//a[@class='d-flex align-items-center dropdown-toggle nav-link']")
    public WebElement homepageDropdown;

    @FindBy(xpath = "(//span[contains(text(),'Register')])[1]")
    public WebElement registrationLink;

    @FindBy(xpath = "//div[normalize-space()='Your SSN is invalid']")
    public WebElement invalidSsnMessage;

    @FindBy(xpath = "//div[normalize-space()='Your SSN is required.']")
    public WebElement blankSsnMessage;

    @FindBy(xpath = "//div[normalize-space()='Your FirstName is required.']")
    public WebElement blankFirstnameMessage;

    @FindBy(xpath = "//div[normalize-space()='Your LastName is required.']")
    public WebElement blankLastnameMessage;


}
