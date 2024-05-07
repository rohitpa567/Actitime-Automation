package com.cs.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageUtil {

    WebDriver driver;

    CommonFunctions cf;
    public LoginPageUtil(WebDriver driver){
        this.driver=driver;

    }

    public void login(String username,String password){

         cf= new CommonFunctions(driver);

        cf.visibilityOfElement(driver.findElement(By.name("username")));


        driver.findElement(By.name("username")).sendKeys(username);


        driver.findElement(By.name("password")).sendKeys(password);

        driver.findElement(By.xpath("//button[@type='submit']")).click();

    }
           public void logout(){
        driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']/i")).click();
               driver.findElement(By.xpath("//a[text()='Logout']")).click();

           }

    public void verifyErrorMsg(String msg) throws Exception {


        if(msg.equals("Invalid credentials"))
            System.out.println("Test Passed: with invalid credentials");
        else throw new Exception("tEST FAILED: Error msg is not displayed");

    }
    public void verifyReqMsg(String msg) throws Exception {


        if(msg.equals("Required"))
            System.out.println("Test Passed: Feilds are blank");
        else throw new Exception("tEST FAILED: Error msg is not displayed");

    }

}
