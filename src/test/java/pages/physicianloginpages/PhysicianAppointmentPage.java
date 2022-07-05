package pages.physicianloginpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PhysicianAppointmentPage {

    public PhysicianAppointmentPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//table/thead/tr/th")
    public WebElement myAppointmentsTableList;

    @FindBy(xpath = "//input[@id='fromDate']")
    public WebElement fromDateSlot;

    @FindBy(xpath = "//input[@id='toDate']")
    public WebElement toDateSlot;


}
