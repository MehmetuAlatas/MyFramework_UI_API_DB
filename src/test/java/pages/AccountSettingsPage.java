package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AccountSettingsPage {

    public AccountSettingsPage(){PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(xpath = "//*[@id='account-menu']/a/span")
    public WebElement userProfile;

    @FindBy(xpath = "//*[@id='account-menu']/div/a[1]")
    public WebElement dropdownSettings;

    @FindBy(xpath = "//*[@id='account-menu']/div/a[2]")
    public WebElement dropdownPassword;

    @FindBy(xpath = "//*[@id='account-menu']/div/a[3]")
    public WebElement dropdownSignOut;

    @FindBy(xpath = "//*[@id='firstName']")
    public WebElement userFirstName;

    @FindBy(xpath = "//*[@id='lastName']")
    public WebElement userLastname;

    @FindBy(xpath = "//*[@id='email']")
    public WebElement userEmail;



}
