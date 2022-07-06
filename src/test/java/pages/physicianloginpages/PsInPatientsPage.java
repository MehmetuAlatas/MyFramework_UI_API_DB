package pages.physicianloginpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;


public class PsInPatientsPage {

    public PsInPatientsPage() {

        PageFactory.initElements(Driver.getDriver(),this);


    }

    @FindBy(xpath = " //*[contains(text(),'The In Patient is updated with identifier')]")
    public WebElement successMessageAlert;

    @FindBy(xpath = "//*[@class='table']/thead/tr/th")
    public List<WebElement> tableHeadList;

    @FindBy(xpath = "//*[@class='table']/tbody")
    public WebElement tableBodyList;

    @FindBy(xpath = "//table[@class='table']//tbody//tr//td[last()]")
    public List<WebElement> editButtonList;

    @FindBy(xpath = "//table[@class='table']//tbody//tr//td")
    public List<WebElement> tableDataList;

    @FindBy(xpath = "//table[@class='table']//tbody//tr")
    public List<WebElement> tableRowList;





}
