package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(name = "username")
    public WebElement usernameInput;

    @FindBy(xpath = "//*[text()='Username cannot be empty!']")
    public WebElement emptyUsernameWarning;

    @FindBy(name = "password")
    public WebElement passwordInput;

    @FindBy(xpath = "//*[text()='Password cannot be empty!']")
    public WebElement emptyPasswordWarning;

    @FindBy(xpath = "//div[@class='Toastify__toast-container Toastify__toast-container--top-left toastify-container']")
    public WebElement redLabelWarning;

    @FindBy(xpath = "//div[@class='alert alert-danger fade show']")
    public WebElement invalidCredentialsWarning;

    @FindBy(xpath = "//div[@class='form-check form-check-inline']")
    public WebElement rememberMeRadioButton;

    @FindBy(xpath = "//a[@href='/account/reset/request']")
    public WebElement forgetPasswordButton;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signInButton;


}

