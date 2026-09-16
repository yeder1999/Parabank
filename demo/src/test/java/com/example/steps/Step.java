package com.example.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.example.PF.LOGIN;
import com.example.PF.LoginPage;
import com.example.PF.Registerpage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Step {

    WebDriver driver;
    WebDriverWait wait;

    Registerpage registerPage;
    LoginPage loginPage;
     LOGIN lg;
     URL gridUrl;

    @Before
    public void setUp() {
        //driver = new ChromeDriver();
        try {
            gridUrl = new URL("http://selenium-hub:4444/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        ChromeOptions co = new ChromeOptions();
        driver = new RemoteWebDriver(gridUrl,co);
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        registerPage = new Registerpage(driver);
        loginPage = new LoginPage(driver);
        lg =new LOGIN(driver);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("home page")
    public void iAmOnTheParaBankHomePage() {
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
    }

    @When("I click on Register")
    public void iClickOnRegister() {
        registerPage.clickRegisterLink();
    }

    @When("I enter first name {string}")
    public void iEnterFirstName(String value) {
        registerPage.enterFirstName(value);
    }

    @When("I enter last name {string}")
    public void iEnterLastName(String value) {
        registerPage.enterLastName(value);
    }

    @When("I enter address {string}")
    public void iEnterAddress(String value) {
        registerPage.enterAddress(value);
    }

    @When("I enter city {string}")
    public void iEnterCity(String value) {
        registerPage.enterCity(value);
    }

    @When("I enter state {string}")
    public void iEnterState(String value) {
        registerPage.enterState(value);
    }

    @When("I enter zip code {string}")
    public void iEnterZipCode(String value) {
        registerPage.enterZipCode(value);
    }

    @When("I enter phone {string}")
    public void iEnterPhone(String value) {
        registerPage.enterPhone(value);
    }

    @When("I enter SSN {string}")
    public void iEnterSSN(String value) {
        registerPage.enterSSN(value);
    }
    double random = Math.floor(Math.random()*2000);
    @When("I enter username {string}")
    public void iEnterUsername(String value) {
        registerPage.enterUsername(value+random);
    }

    @When("I enter password {string}")
    public void iEnterPassword(String value) {
        registerPage.enterPassword(value);
    }

    @When("I confirm password {string}")
    public void iConfirmPassword(String value) {
        registerPage.enterConfirmPassword(value);
    }

    @When("I click on the Register button")
    public void iClickOnTheRegisterButton() {
        registerPage.clickRegisterButton();
    }

    @Then("I should see the welcome message {string}")
    public void iShouldSeeTheWelcomeMessage(String expectedMessage) {

        wait.until(ExpectedConditions.visibilityOf(
                registerPage.getWelcomeMessageElement()
        ));

        assertEquals(expectedMessage+random,registerPage.getWelcomeMessage()
        );
    }

    @When("I click on Log Out")
    public void iClickOnLogOut() {
        registerPage.clickLogout();
    }

    @When("I enter login username {string}")
    public void iEnterLoginUsername(String value) {
        lg.enterUsername(value+random);
    }

    @When("I enter login password {string}")
    public void iEnterLoginPassword(String value) {
        lg.enterPassword(value);
    }

    @When("I click on Log In")
    public void iClickOnLogIn() {
        loginPage.clickLogin();
    }

    @Then("I should see {string}")
    public void iShouldSee(String expectedText) {

        wait.until(ExpectedConditions.visibilityOf(loginPage.getAccountsOverviewElement()));

        assertTrue(loginPage.getAccountsOverview().contains(expectedText)
        );
    }
}