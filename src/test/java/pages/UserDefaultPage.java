package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class UserDefaultPage {

        public UserDefaultPage() {

            PageFactory.initElements(Driver.getDriver(),this);
        }

    @FindBy(xpath = "//*[text()='MY PAGES']")
    public WebElement myPagesSegment;

    @FindBy(xpath = "//*[text()='My Inpatients']")
    public WebElement myInpatientsSegment;

    @FindBy(xpath = "//*[text()='My Appointments']")
    public WebElement myAppointmentsSegment;



    }

