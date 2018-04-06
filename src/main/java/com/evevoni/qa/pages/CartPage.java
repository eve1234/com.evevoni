package com.evevoni.qa.pages;

import com.evevoni.qa.base.TestBase;
import static com.evevoni.qa.base.TestBase.driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author yvonneak
 */
public class CartPage extends TestBase{
    
    //@FindBy(xpath="//ul[@id='site-header-cart']")
    @FindBy(xpath="//a[@class='cart-contents']")      
    WebElement cartLink;
    
    public CartPage(){
         PageFactory.initElements(driver, this);
    }
    
    public CartPage clickOnCartLink(){
        cartLink.click();
        return new CartPage();
    }
    
    public String validateCartPageTitle(){
        return driver.getTitle();
    }
}

