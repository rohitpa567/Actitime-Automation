package com.cs.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

    WebDriver driver;



    public WebDriver launchBrowser(String browserName) {

        if (browserName.toLowerCase().equals("chrome")) {

            ChromeOptions op = new ChromeOptions();
            op.setBrowserVersion("stable");
            op.addArguments("--remote-allow-origins=*");
            op.addArguments("--start-maximized");

            driver = new ChromeDriver(op);
        } else if (browserName.toLowerCase().equals("firefox")) {
            FirefoxOptions fp = new FirefoxOptions();

            fp.setBrowserVersion("stable");
            driver = new FirefoxDriver(fp);

        } else if (browserName.toLowerCase().equals("edge")) {
            EdgeOptions ep = new EdgeOptions();

            ep.setBrowserVersion("stable");
            driver = new EdgeDriver(ep);

        }

        return driver;

    }
}
