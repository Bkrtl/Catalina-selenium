package net.romina.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.romina.pages.LoginPage;
import net.romina.utilities.BrowserUtils;
import net.romina.utilities.ConfigurationReader;
import net.romina.utilities.Driver;
import org.junit.Assert;

public class LoginStepDefs {

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        System.out.println("Opening the Trycloud login page");
        String url= ConfigurationReader.get("url");
        Driver.get().get(url);
    }

    @When("the users enter the user information")
    public void the_users_enter_the_user_information() {
        LoginPage loginPage= new LoginPage();
        String username=ConfigurationReader.get("username");
        String password= ConfigurationReader.get("password");
        loginPage.login(username,password);
    }

    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() {
        BrowserUtils.waitFor(5);
        String actualTitle= Driver.get().getTitle();
        Assert.assertEquals("Files - Trycloud",actualTitle);
    }
}
