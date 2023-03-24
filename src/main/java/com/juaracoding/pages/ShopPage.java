package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ShopPage {
    private WebDriver driver;
    public ShopPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[normalize-space()='Black Cross Back Maxi Dress']")
    WebElement product;
    @FindBy(xpath = "//*[@id='pa_color']/option[2]")
    WebElement color;
    @FindBy(xpath = "//*[@id='pa_size']/option[3]")
    WebElement size;
    @FindBy(xpath = "//button[normalize-space()='Add to cart']")
    WebElement btnAddcard;
    @FindBy(xpath = "//a[@class='button wc-forward wp-element-button']")
    WebElement btnViewcard;
    @FindBy(xpath = "//h1[@class='page-title']")
    WebElement txtCard;
    @FindBy(xpath = "//span[@class='archive post-product-archive current-item']")
    WebElement txtShop;

    public String getTxtCard(){
        return txtCard.getText();
    }
    public String getTxtShop(){
        return txtShop.getText();
    }
    public void addcard(){
        product.click();
        color.click();
        size.click();
        btnAddcard.click();
        btnViewcard.click();
    }
}
