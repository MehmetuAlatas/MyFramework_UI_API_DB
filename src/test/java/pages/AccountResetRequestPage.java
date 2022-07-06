package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AccountResetRequestPage {

    public AccountResetRequestPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@placeholder='Your email']")
    public WebElement resetRequestEmailBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement resetPasswordButton;

    @FindBy(xpath = "//div[@class='Toastify__toast-container Toastify__toast-container--top-left toastify-container']")
    public WebElement greenLabelMessage;

    @FindBy(xpath = "//*[text()='Your email is required.']")
    public WebElement emailRequirementText;

    @FindBy(xpath = "//*[text()='Your email is required to be at least 5 characters.']")
    public WebElement emailRequiredCharText;

    @FindBy(xpath = "//*[text()='This field is invalid']")
    public WebElement emailInvalidText;

}
