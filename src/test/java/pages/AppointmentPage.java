package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class  AppointmentPage {


    public AppointmentPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@name='firstName']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@name='lastName']")
    public WebElement lasttName;

    @FindBy(xpath = "//input[@name='ssn']")
    public WebElement SSN;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement email;

    @FindBy(xpath = "//input[@name='phone']")
    public WebElement phone;

    @FindBy(xpath = "//input[@name='appoDate']")
    public WebElement appoinmentDateTime;

    @FindBy(xpath = "//button[@id='register-submit']")
    public WebElement sentAnAppointmentRequest;

   @FindBy(xpath = "//div[@class='Toastify__toast Toastify__toast--error toastify-toast']")
    public WebElement makeAnAppointmentSuccessfully;

   @FindBy(xpath = "//span[@style='color: red; font-size: 12px; border-color: red;']")
   public WebElement notMakeAnAppointmentSuccessfully;
}