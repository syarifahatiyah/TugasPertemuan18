package com.juaracoding.stepdefinitions;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.pages.ShopPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestShopPage {

    public static WebDriver driver;
    public ShopPage shopPage;

    @BeforeClass
    public void setUp(){
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        shopPage = new ShopPage();
//        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Test(priority = 1)
    public void testUrl(){
        driver.get("https://shop.demoqa.com/shop/");
        //step verify
        Assert.assertEquals(shopPage.getTxtShop(),"Products");
    }

    @Test(priority = 2)
    public void testAddCard(){
        shopPage.addcard();
        Assert.assertEquals(shopPage.getTxtCard(),"CART");
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
