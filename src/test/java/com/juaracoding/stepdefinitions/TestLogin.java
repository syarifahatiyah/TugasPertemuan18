package com.juaracoding.stepdefinitions;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestLogin {

    public static WebDriver driver;
    public LoginPage loginPage;

    @BeforeClass
    public void setUp(){
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        loginPage = new LoginPage();
//        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Test(priority = 1)
    public void testUrl(){
        driver.get("https://shop.demoqa.com/my-account/");
        //step verify
        Assert.assertEquals(loginPage.getLoginTitle(),"LOGIN");
    }

    @Test(priority = 2)
    public void testValidLogin(){
        loginPage.login("syarifah","admin123");
        Assert.assertEquals(loginPage.getTxtDashboard(),"MY ACCOUNT");
        loginPage.logout();
        Assert.assertEquals(loginPage.getLoginTitle(),"LOGIN");
    }

    @Test(priority = 3)
    public void testInvalidLogin(){
        loginPage.login("syarifah","admin1234");
        Assert.assertEquals(loginPage.getTxtError(),"ERROR");
    }

    @AfterClass
    public void quitBrowser(){
        delay(3);
        DriverSingleton.closeObjectInstance();
    }

    static void delay(long detik){
        try {
            Thread.sleep(detik*5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
