package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;
    public LoginPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='username']")
    WebElement username;
    @FindBy(xpath = "//input[@id='password']")
    WebElement password;
    @FindBy(xpath = "//button[@name='login']")
    WebElement btnLogin;
    @FindBy(xpath = "//a[normalize-space()='Log out']")
    WebElement btnLogout;
    @FindBy(xpath = "//h1[@class='page-title']")
    WebElement txtDashboard;
    @FindBy(xpath = "//h2[normalize-space()='Login']")
    WebElement loginTitle;
    @FindBy(xpath = "//strong[normalize-space()='ERROR']")
    WebElement txtError;

    public String getLoginTitle(){
        return loginTitle.getText();
    }
    public String getTxtDashboard(){
        return txtDashboard.getText();
    }
    public String getTxtError(){
        return txtError.getText();
    }
    public void login(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        btnLogin.click();
    }
    public void logout(){
        btnLogout.click();
    }
}
