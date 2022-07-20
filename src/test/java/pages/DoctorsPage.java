package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class DoctorsPage {

    public DoctorsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@class='d-flex align-items-center dropdown-toggle nav-link']")
    public WebElement signinSymbol;

    @FindBy(xpath = "//*[.='Sign in']")
    public WebElement signinButton;

    @FindBy(xpath = "//*[.='Register']")
    public WebElement registerButton;

    @FindBy(xpath = "//input[@name='username']")
    public WebElement userName;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement password;

    @FindBy(xpath = "(//*[.='Sign in'])[4]")
    public WebElement signinWithCredentials;

    @FindBy(xpath = "//*[contains(text(), 'MY PAGES')]")
    public WebElement myPages;

    @FindBy(xpath = "(//*[contains(text(), 'My Appointments')])[1]")
    public WebElement myAppointments;

    @FindBy(xpath = "(//*[.='Edit'])[1]")
    public WebElement edit;

    @FindBy(xpath = "//*[@id='appointment-id']")
    public WebElement idPatient;

    @FindBy(xpath = "//*[@id='appointment-startDate']")
    public WebElement startDateTime;

    @FindBy(xpath = "//*[@id='appointment-endDate']")
    public WebElement startEndTime;

    @FindBy(xpath = "//*[@id='appointment-status']")
    public WebElement status;

    @FindBy(xpath = "//select[@id='appointment-status']")
    public WebElement statusDropDown;

    @FindBy(xpath = "//select[@id='appointment-physician']")
    public WebElement physician;

    @FindBy(xpath = "//*[@id='appointment-anamnesis']")
    public WebElement anamnesis;

    @FindBy(xpath = "//*[@id='appointment-treatment']")
    public WebElement treatment;

    @FindBy(xpath = "//*[@id='appointment-diagnosis']")
    public WebElement diagnosis;

    @FindBy(xpath = "//*[contains(text(), 'Save')]")
    public WebElement saveButton;

    @FindBy(xpath = "//*[contains(text(), 'The Appointment is updated with identifier')]")
    public WebElement succesfullysaved;

    @FindBy(xpath = "//*[@id='appointment-prescription']")
    public WebElement prescription;

    @FindBy(xpath = "//*[@id='appointment-description']")
    public WebElement description;

    @FindBy(xpath = "//*[.='UNAPPROVED']")
    public WebElement unapproved;

    @FindBy(xpath = "//*[@class='invalid-feedback']")
    public List<WebElement> requiredWarning;


    @FindBy(xpath = "//*[.='Request A Test']")
    public WebElement requestTest;

    @FindBy(xpath = "//*[@id='1404']")
    public WebElement sodium;

    @FindBy(xpath = "//*[@id='1402']")
    public WebElement urea;

    @FindBy(xpath = "//*[@id='30199']")
    public WebElement diabetesMedicine;

    @FindBy(xpath = "//*[@id='save-entity']")
    public WebElement saveTestRequest;

    @FindBy(xpath = "//*[contains(text(), 'A new Test is created with identifier')]")
    public WebElement testRequestSuccesMessage;

    @FindBy(xpath = "//*[contains(text(), 'Show Test Results')]")
    public WebElement showTestResults;

    @FindBy(xpath = "//table/tbody/tr[last()]/td[last()]/div")
    public WebElement viewLastTestResults;

    @FindBy(xpath = "//table/thead/tr/th")
    public List<WebElement> testResultsHeadList;

    @FindBy(xpath = "//table/tbody/tr/td[2]")
    public List<WebElement> testResultsNameList;

    @FindBy(xpath = "//*[contains(text(), 'Request Inpatient')]")
    public WebElement requestInpatient;

    @FindBy(xpath = "//*[contains(text(), 'A new In Patient is created with identifier')]")
    public WebElement newRequestSuccessMessage;

    @FindBy(xpath = "//*[contains(text(), 'InPatient request already done for this appointment')]")
    public WebElement oldRequestSuccessMessage;

    @FindBy(xpath = "//*[contains(text(), 'My Inpatients')]")
    public WebElement myInpatients;

    @FindBy(xpath = "//table/tbody/tr[last()]/td[8]")
    public WebElement lastlyAddedmyInpatientsId;

    @FindBy(xpath = "//table/tbody/tr[1]/td[1]")
    public WebElement firstEditInpatientsId;

    @FindBy(xpath = "//*[contains(text(), 'Items&Titles')]")
    public WebElement itemsTitles;

    @FindBy(xpath = "(//*[contains(text(), 'Room')])[1]")
    public WebElement Room;

    @FindBy(xpath = "//*[contains(text(), 'Create a new Room')]")
    public WebElement createAnewRoom;

    @FindBy(xpath = "//*[@id= 'room-roomNumber']")
    public WebElement roomNumber;

    @FindBy(xpath = "//*[@id= 'room-price']")
    public WebElement price;

    @FindBy(xpath = "//*[contains(text(), 'Save')]")
    public WebElement roomSaveButton;

    @FindBy(xpath = "//*[contains(text(), 'A new Room is created with identifier')]")
    public WebElement roomCreationSuccesMessage;

    @FindBy(xpath = "(//*[contains(text(), 'This field is required.')])[1]")
    public WebElement roomRequiredMessage;

    @FindBy(xpath = "(//*[contains(text(), 'This field is required.')])[2]")
    public WebElement priceRequiredMessage;

    @FindBy(xpath = "//*[@id='room-createdDate']")
    public WebElement createDate;

    @FindBy(xpath = "//*[contains(text(), 'Created Date')]")
    public WebElement createDateTitle;




}
