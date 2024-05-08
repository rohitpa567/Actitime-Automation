package com.cs.tests;


import com.cs.Pages.LoginPage;
import com.cs.Pages.TasksPage;
import com.cs.common.PropertyHandling;
import com.cs.utils.BaseClass;
import com.cs.utils.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import java.time.LocalDateTime;
import java.util.List;

public class CalenderDemo extends BaseClass {
    WebDriver driver;
    CommonFunctions cf;


LoginPage loginPage;
    TasksPage tasksPage;
    @BeforeClass
    public void tearUp() throws IOException {

        PropertyHandling propertyHandling = new PropertyHandling("config.properties");
        String browser = propertyHandling.getProperty("browser");
        driver = launchBrowser(browser);

         cf= new CommonFunctions(driver);

        loginPage = new LoginPage(driver);
        String url = propertyHandling.getProperty("url");
        driver.get(url);

        String username = propertyHandling.getProperty("username");
        String password = propertyHandling.getProperty("password");

        loginPage.login(username, password);

        tasksPage= new TasksPage(driver);

    }
    @Test
    public void test1() {

        int dayOfMonth = LocalDateTime.now().getDayOfMonth();
        System.out.println("day of month=" + dayOfMonth);

        String currentMonth = LocalDateTime.now().getMonth().name();
        System.out.println(currentMonth);

        String actualCurrentMonth = currentMonth.charAt(0) + currentMonth.substring(1, currentMonth.length()).toLowerCase();

        System.out.println("Current month is=" + actualCurrentMonth);

        cf.click(tasksPage.taskModule);

        driver.findElement(By.xpath("(//div[text()='Android prototyping'])[1]")).click();

        driver.findElement(By.xpath("//div[@class='rightContainer']")).click();

        WebElement we=   driver.findElement(By.xpath("//div[@class='detailsRow']/descendant::div[text()='Set up deadline']"));

        cf.elementToBeClickable(we);

        driver.findElement(By.xpath("//div[@class='detailsRow']/descendant::div[text()='Set up deadline']")).click();

        String monthXpath="//td[starts-with(@title,'"+actualCurrentMonth+"')]";

        System.out.println(monthXpath);

     List<WebElement> days=  driver.findElements(By.xpath(monthXpath));

     for(WebElement dayElement:days){

        String day= dayElement.getText();

         System.out.println(day);

         if(day.equals(String.valueOf(dayOfMonth))){
             dayElement.click();
         }
     }

    }

}


