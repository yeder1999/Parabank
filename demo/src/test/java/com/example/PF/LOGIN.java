package com.example.PF;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LOGIN {
    WebDriver driver;
      @FindBy(css="[name=\"username\"]")
      WebElement username;

     @FindBy(css ="[name =\"password\"]")
     WebElement password;
      public void enterUsername(String value) {
    username.sendKeys(value);
    }

    public void enterPassword(String value) {
        password.sendKeys(value);
    }
 public LOGIN(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    
}
