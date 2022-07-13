package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AccountRegisterPage {

    public AccountRegisterPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


}
