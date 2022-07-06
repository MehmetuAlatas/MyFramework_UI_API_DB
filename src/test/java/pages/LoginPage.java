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

    @FindBy(xpath = " //*[@id='login-page']/div/form/div[2]/div[4]/span/span")
    public WebElement isAccountExistYetText;

    @FindBy(xpath = "(//*[@href='/account/register'])[2]")
    public WebElement  registerNewAccountButton;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signInButton;

    @FindBy(xpath = "//*[text()='Cancel']")
    public WebElement cancelButton;

    @FindBy(xpath = "//*[@id='account-menu']/a/span")
    public WebElement userProfile;

    @FindBy(xpath = "//*[@id='account-menu']/div/a[1]")
    public WebElement dropdownSettings;

    @FindBy(xpath = "//*[@id='account-menu']/div/a[2]")
    public WebElement dropdownPassword;

    @FindBy(xpath = "//*[@id='account-menu']/div/a[3]")
    public WebElement dropdownSignOut;


}

