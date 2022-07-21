package stepdefinitions.uistepdefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.DoctorsPage;
import utilities.Driver;
import utilities.JsUtils;

import static utilities.Driver.wait2;

public class US16_StepDefs {

    Actions actions = new Actions(Driver.getDriver());
    DoctorsPage doctorsPage = new DoctorsPage();
   // static String roomNumber;
    Faker faker = new Faker();

    @Given("Admin goes to the sign in page")
    public void admin_goes_to_the_sign_in_page() {
        actions.click(doctorsPage.signinSymbol).perform();
        actions.click(doctorsPage.signinButton).perform();
    }

    @Given("Admin enters his credentials in popup window")
    public void admin_enters_his_credentials_in_popup_window() {
        Driver.waitAndSendText(doctorsPage.userName, "Mehmet84");
        Driver.waitAndSendText(doctorsPage.password, "Mehmet84");
    }

    @Given("Admin clicks on Sign in button")
    public void admin_clicks_on_sign_in_button() {
        Driver.waitForClickablility(doctorsPage.signinWithCredentials, 7);
        actions.click(doctorsPage.signinWithCredentials).perform();
    }

    @Given("Admin navigates to the Items-Titles and clicks on Room")
    public void admin_navigates_to_the_items_titles_and_clicks_on_room() {
        Driver.waitForClickablility(doctorsPage.itemsTitles, 7);
        actions.click(doctorsPage.itemsTitles).perform();
        Driver.waitForClickablility(doctorsPage.Room, 7);
        actions.click(doctorsPage.Room).perform();

    }

    @Given("Admin clicks on Create a new Room button")
    public void admin_clicks_on_create_a_new_room_button() {
        Driver.waitForClickablility(doctorsPage.createAnewRoom, 7);
        actions.click(doctorsPage.createAnewRoom).perform();
    }

    @Given("Admin fills the Room number and Price and left blank the Decription and clicks on save button")
    public void admin_fills_the_room_number_and_price_and_left_blank_the_decription_and_clicks_on_save_button() {

//        int intRoomNumber = Integer.parseInt(roomNumber);
//        intRoomNumber++;
//        roomNumber = String.valueOf(intRoomNumber);
        String rooomnumber = String.valueOf(faker.number().numberBetween(3137317,999999999));

        Driver.waitAndSendText(doctorsPage.roomNumber, rooomnumber);
        Driver.waitAndSendText(doctorsPage.price, "313");
        Driver.waitForClickablility(doctorsPage.roomSaveButton, 7);
        JsUtils.clickElementByJS(doctorsPage.roomSaveButton);

    }

    @Given("Admin verify A new Room is created with identifier message")
    public void admin_verify_a_new_room_is_created_with_identifier_message() {
        WebElement successMessage = doctorsPage.roomCreationSuccesMessage;
        for (int i = 0; i < 7; i++) {
            Driver.wait(1);
            try {
                System.out.println("successMessage = " + successMessage.getText());
                Assert.assertTrue(successMessage.isDisplayed());
                Assert.assertTrue(successMessage.getText().contains("A new Room is created with identifier"));
//                int intRoomNumber = Integer.parseInt(roomNumber);
//                intRoomNumber++;
//                roomNumber = String.valueOf(intRoomNumber);
                break;
            } catch (Exception e) {
                System.out.println("successMessage could not displayed");
            }
        }
        Assert.assertTrue(successMessage.isDisplayed());


    }

    @Given("Admin clicks on save button and verifies the This field is required message  about Price")
    public void admin_clicks_on_save_button_and_verifies_the_this_field_is_required_message_about_price() {
        Driver.waitForClickablility(doctorsPage.roomSaveButton, 7);
        JsUtils.clickElementByJS(doctorsPage.roomSaveButton);
        Assert.assertTrue(doctorsPage.priceRequiredMessage.isDisplayed());
    }

    @Given("Admin fills the Room number and Price and clicks on save button")
    public void admin_fills_the_room_number_and_price_and_clicks_on_save_button() {

        String rooomnumber = String.valueOf(faker.number().numberBetween(3137316,3139999));
        Driver.waitAndSendText(doctorsPage.roomNumber, rooomnumber);
        Driver.waitAndSendText(doctorsPage.price, "313");
        Driver.waitForClickablility(doctorsPage.roomSaveButton, 7);
        JsUtils.clickElementByJS(doctorsPage.roomSaveButton);

    }

    @Given("Admin fills the required fields")
    public void admin_fills_the_required_fields() {
        String rooomnumber = String.valueOf(faker.number().numberBetween(3137317,999999999));

        Driver.waitAndSendText(doctorsPage.roomNumber, rooomnumber);
        Driver.waitAndSendText(doctorsPage.price, "313");

    }

    @Given("Admin verifies room type as {string} are can be set for the room")
    public void admin_verifies_room_type_as_are_can_be_set_for_the_room(String status) {
        Select select = new Select(doctorsPage.roomTypeDropdown);
        select.selectByVisibleText(status);
        for (int i = 0; i < 7; i++) {
            try {
                System.out.println("selected and verified option " + status);
                Assert.assertTrue(select.getFirstSelectedOption().getText().contains(status));
                break;
            } catch (Exception e) {
                System.out.println("successMessage could not displayed");
                Driver.wait(1);
            }
        }
    }

    @Given("Admin picks old date from Created Date part")
    public void admin_picks_old_date_from_created_date_part() {
        Driver.waitAndSendText(doctorsPage.createDate, "07/07/2007");
        //to be added screenshot

    }

    @Given("admin goes to the last page")
    public void admin_goes_to_the_last_page_somehow_click_on_date_if_it_is_available_with_automation() {
        Driver.wait(3);
        Driver.waitForClickablility(doctorsPage.createDateTitle, 7);
        actions.click(doctorsPage.createDateTitle).perform();
        Driver.wait(2);

    }

    @Given("Admin verify created Date is not match with old date")
    public void admin_verify_created_date_is_not_match_with_old_date() {
        Driver.waitAndGetText(doctorsPage.lastCreatedDate,3);
        String oldDate="07/07/07";
        String actualdate=doctorsPage.lastCreatedDate.getText();
        System.out.println(" actual date "+actualdate);
        System.out.println(" olddate "+oldDate);
        Assert.assertFalse(actualdate.contains(oldDate));

    }

    @Given("Admin clicks on first Edit button")
    public void admin_clicks_on_first_edit_button() {
        Driver.waitForClickablility(doctorsPage.firstEditRoom, 7);
        JsUtils.clickElementByJS(doctorsPage.firstEditRoom);
    }

    @Given("Admin updates the room number, room type and price")
    public void admin_updates_the_room_number_room_type_and_price() {
        String rooomnumber = String.valueOf(faker.number().numberBetween(3137317,999999999));
        Driver.wait(1);
        doctorsPage.roomNumber.clear();
        Driver.wait(1);
        Driver.waitAndSendText(doctorsPage.roomNumber, rooomnumber);
        doctorsPage.price.clear();
        Driver.wait(1);
        Driver.waitAndSendText(doctorsPage.price, "77");
        Driver.wait(1);
        Select select = new Select(doctorsPage.roomTypeDropdown);
        select.selectByVisibleText("DAYCARE");
        JsUtils.clickElementByJS(doctorsPage.roomSaveButton);

    }

    @Given("Admin verify A new Room is updated with identifier message")
    public void admin_verify_a_new_room_is_updated_with_identifier_message() {
        WebElement successMessage = doctorsPage.roomUpdateMessage;
        for (int i = 0; i < 7; i++) {
            Driver.wait(1);
            try {
                System.out.println("successMessage = " + successMessage.getText());
                Assert.assertTrue(successMessage.isDisplayed());
                Assert.assertTrue(successMessage.getText().contains("A Room is updated with identifier"));
                break;
            } catch (Exception e) {
                System.out.println("successMessage could not displayed");
            }
        }
        Assert.assertTrue(successMessage.isDisplayed());


    }


    @Given("Admin clicks on first Delete button")
    public void admin_clicks_on_first_delete_button() {
        Driver.waitForClickablility(doctorsPage.firstDeleteRoom, 7);
        JsUtils.clickElementByJS(doctorsPage.firstDeleteRoom);
    }

    @Given("Admin clicks on delete button from opened popup")
    public void admin_clicks_on_delete_button_from_opened_popup() {
        Driver.wait(1);
        JsUtils.clickElementByJS(doctorsPage.deletePopUp);

    }

    @Given("Admin verify Delete Succes message")
    public void admin_verify_delete_succes_message() {
        Assert.assertTrue(doctorsPage.succesfullysaved.isDisplayed());
// ınternal server error alındığından manuel olarak ta silinemediği için locati hiç alınamadı

    }

}
