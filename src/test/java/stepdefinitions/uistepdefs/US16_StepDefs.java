package stepdefinitions.uistepdefs;

import io.cucumber.java.en.Given;
import org.openqa.selenium.interactions.Actions;
import pages.DoctorsPage;
import utilities.Driver;

public class US16_StepDefs {

    Actions actions = new Actions(Driver.getDriver());
    DoctorsPage doctorsPage = new DoctorsPage();

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
    @Given("Admin enters his valid username and password in popup window")
    public void admin_enters_his_valid_username_and_password_in_popup_window() {

    }
    @Given("Admin clicks Sign in button and enter Home page")
    public void admin_clicks_button_and_enter_home_page() {

    }
    @Given("Admin navigates to the Items-Titles and clicks on Room")
    public void admin_navigates_to_the_items_titles_and_clicks_on_room() {

    }
    @Given("Admin clicks on Create a new Room button")
    public void admin_clicks_on_create_a_new_room_button() {

    }
    @Given("Admin fills the Room number and Price and left blank the Decription and clicks on save button")
    public void admin_fills_the_room_number_and_price_and_left_blank_the_decription_and_clicks_on_save_button() {

    }
    @Given("Admin verify A new Room is created with identifier message")
    public void admin_verify_a_new_room_is_created_with_identifier_message() {

    }


    @Given("Admin clicks on save button and verifies the This field is required message  about Price")
    public void admin_clicks_on_save_button_and_verifies_the_this_field_is_required_message_about_price() {

    }
    @Given("Admin fills the Room number and Price and clicks on save button")
    public void admin_fills_the_room_number_and_price_and_clicks_on_save_button() {

    }

    @Given("Admin fills the required fields")
    public void admin_fills_the_required_fields() {

    }
    @Given("Admin verifies room type as {string} are can be set for the room")
    public void admin_verifies_room_type_as_are_can_be_set_for_the_room(String string) {

    }


    @Given("Admin picks old date from Created Date part")
    public void admin_picks_old_date_from_created_date_part() {

    }
    @Given("admin goes to the last page somehow {int}=click on date if it is available with automation")
    public void admin_goes_to_the_last_page_somehow_click_on_date_if_it_is_available_with_automation(Integer int1) {

    }
    @Given("Admin verify created Date is not match with old date")
    public void admin_verify_created_date_is_not_match_with_old_date() {

    }

    @Given("Admin clicks on first Edit button")
    public void admin_clicks_on_first_edit_button() {

    }
    @Given("Admin updates the room number, room type and price")
    public void admin_updates_the_room_number_room_type_and_price() {

    }

    @Given("Admin verify A new Room is updated with identifier message")
    public void admin_verify_a_new_room_is_updated_with_identifier_message() {

    }


    @Given("Admin clicks on first Delete button")
    public void admin_clicks_on_first_delete_button() {

    }
    @Given("Admin clicks on delete button from opened popup")
    public void admin_clicks_on_delete_button_from_opened_popup() {

    }
    @Given("Admin verify Delete Succes message")
    public void admin_verify_delete_succes_message() {

    }

}
