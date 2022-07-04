package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CommonPageElements {


    public CommonPageElements(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


}
