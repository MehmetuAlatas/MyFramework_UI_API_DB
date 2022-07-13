package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AccountPasswordPage {

    public AccountPasswordPage() { PageFactory.initElements(Driver.getDriver(),this); }

    @FindBy(xpath = "//*[@id='account-menu']/a/span")
    public WebElement userProfile;

    @FindBy(xpath = "//*[@id='account-menu']/div/a[1]")
    public WebElement dropdownSettings;

    @FindBy(xpath = "//*[@id='account-menu']/div/a[2]")
    public WebElement dropdownPassword;

    @FindBy(xpath = "//*[@id='account-menu']/div/a[3]")
    public WebElement dropdownSignOut;

    @FindBy(xpath = "//*[@id='password-form']/button")
    public WebElement saveButton;

    @FindBy(xpath = "//*[@id='password-title']/span/strong")
    public WebElement verifyUserName;

    @FindBy(xpath = "//div/input[@name='currentPassword']")
    public WebElement currentPassword;

    @FindBy(xpath = "//div/input[@name='newPassword']")
    public WebElement newPassword;

    @FindBy(xpath = "//*[@id='strengthBar']/li[1]")
    public WebElement pwdStrengthBar1;
    @FindBy(xpath = "//*[@id='strengthBar']/li[2]")
    public WebElement pwdStrengthBar2;
    @FindBy(xpath = "//*[@id='strengthBar']/li[3]")
    public WebElement pwdStrengthBar3;
    @FindBy(xpath = "//*[@id='strengthBar']/li[4]")
    public WebElement pwdStrengthBar4;
    @FindBy(xpath = "//*[@id='strengthBar']/li[5]")
    public WebElement pwdStrengthBar5;

    @FindBy(xpath = "//div/input[@name='confirmPassword']")
    public WebElement confirmPassword;

    @FindBy(xpath = "//div/div/div[1]/span/strong")
    public WebElement passwordChanged;

    @FindBy(xpath = "//*[@id='root']/div/div/div[1]/div/div/div[1]/span/strong")
    public WebElement passwordNotChanged;

    @FindBy(xpath = "//*[@id='password-form']/button")
    public WebElement passwordSaveButton;

}
