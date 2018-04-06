package com.evevoni.qa.pages;

import com.evevoni.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author yvonneak
 */
public class CheckOutPage extends TestBase{
    
   
    
    @FindBy(id="shipping_first_name")
    WebElement shippingFirstName;
    
    @FindBy(id="shipping_last_name")
    WebElement shippingLastName;
    
    //selectbox
    @FindBy(id="shipping_country_field")
    WebElement shippingCountryField;
    
    @FindBy(id="shipping_city_field")
    WebElement shippingCityField;
    
    @FindBy(id="place_order")
    WebElement placeOrderBtn;
    
    public static MyAccountPage myAccountPage;

    public CheckOutPage(){
        PageFactory.initElements(driver, this);
    }
    
    //register user and return the registeration details
    public MyAccountPage newMyAccountPageRegister(String regEmail, String regPsswd) throws InterruptedException{
        
        myAccountPage= new MyAccountPage();
        
        Thread.sleep(2000);
        myAccountPage.acctUsername.sendKeys(regEmail);
       
        myAccountPage.acctUsername.sendKeys(regPsswd);
        //myAccountPage.newAccountReg(regEmail, regPsswd);
        
        return myAccountPage;
    }
    
   //teh new user to login
    public void newMyAccountPageLogin(String loginUsrName, String loginPsswd) throws InterruptedException{
        
        myAccountPage= new MyAccountPage();
        
        Thread.sleep(2000);
        myAccountPage.acctUsername.sendKeys(loginUsrName);
       
        myAccountPage.acctUsername.sendKeys(loginPsswd);
        myAccountPage.acctLoginBtn.click();
        myAccountPage.login(loginUsrName, loginPsswd);
        
        
    }
    public void accountShippingRegister(String fName, String sName, String shippingCountry, String shippingCity){
        
        shippingFirstName.sendKeys(fName);
        shippingLastName.sendKeys(sName);
        
        shippingCountryField.click();
        
        Select shippingCountryFieldSelect = new Select(driver.findElement(By.id("shippingCountryField")));
         shippingCountryFieldSelect.selectByValue("United Kingdom (UK)");
         
         shippingCityField.sendKeys(shippingCity);
         
         placeOrderBtn.click();
         
         
    }

}

