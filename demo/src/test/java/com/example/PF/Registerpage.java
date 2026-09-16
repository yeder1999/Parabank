package com.example.PF;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registerpage {

    WebDriver driver;

    @FindBy(linkText = "Register")
    WebElement registerLink;

    @FindBy(id = "customer.firstName")
    WebElement firstName;

    @FindBy(id = "customer.lastName")
    WebElement lastName;

    @FindBy(id = "customer.address.street")
    WebElement address;

    @FindBy(id = "customer.address.city")
    WebElement city;

    @FindBy(id = "customer.address.state")
    WebElement state;

    @FindBy(id = "customer.address.zipCode")
    WebElement zipCode;

    @FindBy(id = "customer.phoneNumber")
    WebElement phone;

    @FindBy(id = "customer.ssn")
    WebElement ssn;

    @FindBy(id = "customer.username")
    WebElement username;

    @FindBy(id = "customer.password")
    WebElement password;

    @FindBy(id = "repeatedPassword")
    WebElement confirmPassword;

    @FindBy(css = "input[type='submit'][value='Register']")
    WebElement registerButton;


    
    @FindBy(className = "title")
    WebElement welcomeMessage;

    @FindBy(linkText = "Log Out")
    WebElement logout;


    public Registerpage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void clickRegisterLink() {
        registerLink.click();
    }


    public void enterFirstName(String value) {
        firstName.sendKeys(value);
    }


    public void enterLastName(String value) {
        lastName.sendKeys(value);
    }


    public void enterAddress(String value) {
        address.sendKeys(value);
    }


    public void enterCity(String value) {
        city.sendKeys(value);
    }


    public void enterState(String value) {
        state.sendKeys(value);
    }


    public void enterZipCode(String value) {
        zipCode.sendKeys(value);
    }


    public void enterPhone(String value) {
        phone.sendKeys(value);
    }


    public void enterSSN(String value) {
        ssn.sendKeys(value);
    }


    public void enterUsername(String value) {
        username.sendKeys(value);
    }


    public void enterPassword(String value) {
        password.sendKeys(value);
    }


    public void enterConfirmPassword(String value) {
        confirmPassword.sendKeys(value);
    }


    public void clickRegisterButton() {
        registerButton.click();
    }


    public String getWelcomeMessage() {
        return welcomeMessage.getText();
    }


    public WebElement getWelcomeMessageElement() {
        return welcomeMessage;
    }


    public void clickLogout() {
        logout.click();
    }
}