package com.example.PF;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    // @FindBy(name = "username")
    // WebElement username;

    // @FindBy(name = "password")
    // WebElement password;

    @FindBy(css = "input[type='submit'][value='Log In']")
    WebElement loginButton;

    @FindBy(xpath = "//div[@id='showOverview']//h1[@class='title']")
    WebElement accountsOverview;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // public void enterUsername(String value) {
    //     username.sendKeys(value);
    // }

    // public void enterPassword(String value) {
    //     password.sendKeys(value);
    // }

    public void clickLogin() {
        loginButton.click();
    }

    public String getAccountsOverview() {
        return accountsOverview.getText();
    }

    public WebElement getAccountsOverviewElement() {
        return accountsOverview;
    }
}