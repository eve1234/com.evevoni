package com.evevoni.qa.pages;

import com.evevoni.qa.base.TestBase;
import static com.evevoni.qa.base.TestBase.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author yvonneak
 */
public class CartPage extends TestBase{
	
	String emptyCartMessage;
	HomePage homepage;
    
    //@FindBy(xpath="//ul[@id='site-header-cart']")
    @FindBy(xpath="//a[@class='cart-contents']")      
    WebElement cartLink;
    
    @FindBy(xpath="//p[text()='Your basket is currently empty.']")
    WebElement emptyCartMsg;
    
    @FindBy(xpath="//li[@id='menu-item-513']//a")
    WebElement homePageLink;
    
    public CartPage(){
         PageFactory.initElements(driver, this);
    }
    
    public CartPage clickOnCartLink(){
    //	homepage= HomePage();
    	emptyCartMessage=driver.findElement(By.xpath("//p[text()='Your basket is currently empty.']")).getText();
        cartLink.click();
        if (emptyCartMessage.contains("Your basket is currently empty.")) {
        
        	homePageLink.click();
        	
        }
        else {
        
        }
        return new CartPage();
    }
    
    public String validateCartPageTitle(){
        return driver.getTitle();
    }
}

