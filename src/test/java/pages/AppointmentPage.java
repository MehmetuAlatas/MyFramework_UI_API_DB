package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class  AppointmentPage {



    public AppointmentPage () {

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(className = "btn-get-started scrollto")
    public WebElement getStarted;

    @FindBy(xpath="//input[@name='firstName']")
public WebElement FirstName;

    @FindBy(xpath="//input[@name='lastName']")
    public WebElement LasttName;

    @FindBy(xpath="//input[@name='ssn']")
    public WebElement SSN;

    @FindBy(xpath="//input[@name='email']")
    public WebElement Email;

    @FindBy(xpath="//input[@name='phone']")
    public WebElement Phone;

    @FindBy(xpath="//input[@name='appoDate']")
    public WebElement AppoinmentDateTime;

}
