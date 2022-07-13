package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class HomePage {

    public HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "//a[@class='d-flex align-items-center dropdown-toggle nav-link']")
    public WebElement signInClickIcon;

    @FindBy(linkText = "Sign in")
    public WebElement signInLink;

    @FindBy(xpath = "//a[@href='/account/register']")
    public WebElement registerLink;

    @FindBy(xpath = "//*[@class='btn-get-started scrollto']")
    public WebElement getStarted;

    @FindBy(xpath = "//div[@id='app-header']//li//a//span")
    public List<WebElement> homePageMenuHeadersList;
}
