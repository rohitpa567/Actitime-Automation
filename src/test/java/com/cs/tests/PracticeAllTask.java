package com.cs.tests;


import com.cs.Pages.LoginPage;
import com.cs.Pages.TasksPage;

import com.cs.common.PropertyHandling;
import com.cs.listeners.ListenersClass;
import com.cs.utils.BaseClass;
import com.cs.utils.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.List;



public class PracticeAllTask  extends BaseClass {

    WebDriver driver;
    CommonFunctions cf;
    LoginPage loginPage;
    TasksPage tasksPage;
    PropertyHandling propertyHandling;

    @BeforeClass
    public void setUp() throws IOException {
        propertyHandling = new PropertyHandling("config.properties");
        String browser = propertyHandling.getProperty("browser");
        driver = launchBrowser(browser);

        loginPage = new LoginPage(driver);
        String url = propertyHandling.getProperty("url");
        driver.get(url);

        tasksPage = new TasksPage(driver);
        cf = new CommonFunctions(driver);


    }

    @BeforeMethod
    public void login() {

        String username = propertyHandling.getProperty("username");
        String password = propertyHandling.getProperty("password");

        loginPage.login(username, password);
    }
    @Test
    public void getAllTasks() throws InterruptedException {


        cf.click(tasksPage.taskModule);


        List<WebElement> allTask = driver.findElements(By.xpath("//tr[contains(@class,'taskRow')]/td[2]//div[@class='title']"));

        for (WebElement we : allTask) {
            if (we.isDisplayed()) {
                String text = we.getText();
                System.out.println(text);
            } else {
                Actions actions = new Actions(driver);
                actions.scrollToElement(we).build().perform();
                String text = we.getText();
                System.out.println(text);
            }
        }


        driver.quit();
    }
}
