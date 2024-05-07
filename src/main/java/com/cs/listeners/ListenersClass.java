package com.cs.listeners;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.*;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ListenersClass  implements ISuiteListener, ITestListener {
String ssFolderPath;
    @Override
    public void onStart(ISuite suite) {
        System.out.println("This is onStart method of ISuiteListener");

        String currentDate= LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd_MM_yy"));

        System.out.println(currentDate );

        ssFolderPath= System.getProperty("user.dir")+"/reports/"+ currentDate;
        File file= new File(ssFolderPath);
        if(!file.exists()){ // check if the folder is not present
            file.mkdir();  //create a folder
        }
    }

    @Override
    public void onFinish(ISuite suite) {
        // When <suite> tag completes
        System.out.println("onFinish: after suite completes");
    }

    @Override
    public void onTestStart(ITestResult result) {
        // When test method starts
        System.out.println("onTestStart -> Test Name: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // If test method is successful
        System.out.println("*********************************");
        System.out.println("onTestSuccess -> Test Name: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // getTestContext return context (variables, method name, exceptions, results) of the @Test method
        try {
            WebDriver driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

            //get the method name from context

            String methodName = result.getMethod().getMethodName();

            String fileName = ssFolderPath+"/"+methodName+".png";
            File dstFile = new File(fileName);
            FileUtils.copyFile(srcFile, dstFile);
        } catch (Exception e) {
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // If test method is skipped
        System.out.println("onSkipped -> Test Name: " + result.getName());

    }


    @Override
    public void onStart(ITestContext context) {
// Before <test> tag of testng.xml file
        System.out.println("onStart -> Test Tag Name: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        // After <test> tag of xml file
        System.out.println("onFinish -> Test Tag Name: " + context.getName());


    }
    }
