package com.cs.Pages;

import com.cs.utils.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public  LoginPage(WebDriver driver){
         this.driver=driver;
    }

    public   By username= By.id("username");
    public  By password=By.name("pwd");

    public By loginButton= By.id("loginButton");

    public void login(String username,String password){

        CommonFunctions cf= new CommonFunctions(driver);
          cf.visibilityOfElement(driver.findElement(this.username));
        driver.findElement(this.username).sendKeys(username);
        driver.findElement(this.password).sendKeys(password);
        cf.click(loginButton);


    }
}
