package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LogoutPage {

    public LogoutPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
