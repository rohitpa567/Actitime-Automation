package com.cs.Pages;

import com.cs.utils.BaseClass;
import com.cs.utils.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TasksPage  {


    WebDriver driver;

    CommonFunctions cf;
    public  TasksPage(WebDriver driver){
        this.driver=driver;
    }

    public  By taskModule= By.id("container_tasks");

    public void getTasks(){

        cf= new CommonFunctions(driver);

        cf.click(taskModule);


    }


}
