package com.cs.utils;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

import java.util.function.Function;




public class CommonFunctions {

    public CommonFunctions(WebDriver driver){
        this.driver=driver;
    }


    WebDriver driver;

    WebDriverWait wait;



    public  void click( By by){

       elementToBeClickable(by);
        driver.findElement(by).click();
    }


    public  void click(WebElement element){

        element.click();
    }


    public void visibilityOfElement( WebElement element) {

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    public void elementToBeClickable( WebElement element) {

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(element));

    }

    public void elementToBeClickable( By by) {

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(by));

    }

    public void elementToBeSelected( WebElement element) {

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(element));

    }

    public void textToBePresentInElement( WebElement element, String text) {

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));


    }

    public void fluentWaitMethod( By by) {

        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .pollingEvery(Duration.ofSeconds(2)).
                withTimeout(Duration.ofSeconds(15)).
                ignoring(Exception.class);

        Function<WebDriver, WebElement> function = (a) -> {
            System.out.println(" fluent wait is applied...");
            return driver.findElement(by);
        };

        fluentWait.until(function);

    }
         public void enterTextWithJS(String text,WebElement element){

            JavascriptExecutor js= (JavascriptExecutor) driver;
            js.executeScript("arguments[0].value='"+text+"';",element);
        }

    public void clickWithJS(WebElement element){

        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",element);
    }


    public void scrollToElement(WebElement element){

        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",element);
    }

    public void scrollBy(int x,int y){

        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy("+x+","+y+");");
    }

}





