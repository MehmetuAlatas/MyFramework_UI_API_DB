package pages.adminloginpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AdminHomePage {

    public AdminHomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[.='Items&Titles']")
    public  WebElement itemsAndTitles;
    @FindBy(xpath = "//*[@id=\"entity-menu\"]/div/a[1]")
    public WebElement patientDropDown;
    @FindBy(xpath = "//*[@class='modal-body']")
    public WebElement signinPopUp;

}
