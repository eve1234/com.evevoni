package com.evevoni.qa.pages;

import com.evevoni.qa.base.TestBase;
import static com.evevoni.qa.base.TestBase.driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author yvonneak
 */
public class HomePage extends TestBase{
    
   // @FindBy(xpath="//strong[contains(text(), 'MyName')]")
    @FindBy(xpath="//div/p[1]/strong[1]")
    @CacheLookup
    WebElement userNameLable;
    
    @FindBy(id="menu-item-517")
    WebElement WigCapOffers;
    
    @FindBy(id="menu-item-512")
    WebElement subToOurNewsLet;
    
    @FindBy(id="menu-item-515")
    WebElement checkOut;
    
    
    //@FindBy(id="menu-item-514")
    @FindBy(xpath="//a[contains(text(),'My account')]")
    WebElement myAccount;
    
    //to close the popup window for subscribing
    
    @FindBy(xpath="//a[@class='ppsPopupClose ppsPopupClose_close-black-in-white-circle']")
    //@FindBy(xpath="//a[contains(text(),'ppsPopupClose')]")
    WebElement closeSubscribePopUp;
    
    @FindBy(name="email")
    WebElement subscribeToPopUpbox;
    
    @FindBy(xpath="//a[contains(text(), 'Go')]")
    WebElement clickOnGo;
    
    //initialsing the page objecs:
    public HomePage(){
        
        PageFactory.initElements(driver, this);
    }
    
     public CheckOutPage clickOnCheckOutPage(){
        checkOut.click();
        return new CheckOutPage();
    }
     
    public MyAccountPage clickMyAccount(){
        myAccount.click();
        return new MyAccountPage();
    }
    
    public String verifyHomePageTitle(){
        return driver.getTitle();
    }
    
    //verify if user has loggin by checking 
    //if logout button is on display
    public boolean verifyCorrectUserName(){
        
        return userNameLable.isDisplayed();
          
    }

    public void clickCloseSubscribePopUp(){
            closeSubscribePopUp.click();

    }

    public String subscribeToPopUpbox(String subEmail){
        //subscribeToPopUpbox.sendKeys(css);
        return subEmail;
    }
   
    public SubscribeToOurNewsLettersPage clickOnSubToOurNewsLet(){
        subToOurNewsLet.click();
        return new SubscribeToOurNewsLettersPage();
    }

    public WigCapOffersPage clickOnWigCapOffers(){
        WigCapOffers.click();
        return new WigCapOffersPage();
    }
}

