package pages.physicianloginpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class PhysicianAppointmentPage {

    public PhysicianAppointmentPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//table/thead/tr/th")
    public List<WebElement> myAppointmentsTableList;

    @FindBy(xpath = "//input[@id='fromDate']")
    public WebElement fromDateSlot;

    @FindBy(xpath = "//input[@id='toDate']")
    public WebElement toDateSlot;

    @FindBy(xpath = "//a[@class='btn btn-primary btn-sm']")
    public WebElement appointmentEditButton;

    @FindBy(xpath = "(//table[@class='table']//tbody//tr//td[last()])[1]")
    public WebElement editButton;

    @FindBy(xpath = "//a[@class='btn btn-success btn-sm']")
    public WebElement requestATestButton;




}
