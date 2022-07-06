package pages.adminloginpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PatientPageSortIdPage {
    public PatientPageSortIdPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@href='/patient/107946/delete?page=130&sort=id,asc']")
    public WebElement deleteButton;
    @FindBy(id = "jhi-confirm-delete-patient")
    public WebElement popUpDelete;
}
