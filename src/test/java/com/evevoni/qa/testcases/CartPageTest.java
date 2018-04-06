package com.evevoni.qa.testcases;

import com.evevoni.qa.base.TestBase;
import static com.evevoni.qa.base.TestBase.driver;
import static com.evevoni.qa.base.TestBase.initialization;
import com.evevoni.qa.pages.CartPage;
import com.evevoni.qa.pages.HomePage;
import com.evevoni.qa.util.TestUtil;
import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author yvonneak
 */
public class CartPageTest extends TestBase{
    CartPage cartPage;
    TestUtil testUtil;
    HomePage homePage;
    
    public CartPageTest(){
        super();
    }
    
    @BeforeMethod
    public void setUp() throws InterruptedException{
        initialization();
        testUtil = new TestUtil();
        cartPage = new CartPage();
        homePage = new HomePage();
        Thread.sleep(2000);
        
        homePage.clickCloseSubscribePopUp();
        
        
    }
    @Test(priority=1)
    public void checkItemsInCart() throws InterruptedException{
        Thread.sleep(2000);
        cartPage.clickOnCartLink();
        Thread.sleep(2000);
        String cartPageTitle= cartPage.validateCartPageTitle();
        System.out.println(cartPageTitle);
        Assert.assertEquals(cartPageTitle, "Cart – Evevoni");
    }
    
    @AfterMethod
    public void tearDown(){
       
      driver.quit();
    }
}

