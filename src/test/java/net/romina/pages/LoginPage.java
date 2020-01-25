package net.romina.pages;

import net.romina.utilities.Driver;
import net.romina.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id="user")
    public WebElement userName;

    @FindBy(id="password")
    public WebElement password;

    @FindBy(id="submit")
    public WebElement submit;


    public void login(String userNameStr, String passwordStr) {
        userName.sendKeys(userNameStr);
        password.sendKeys(passwordStr);
        submit.click();

    }


}
