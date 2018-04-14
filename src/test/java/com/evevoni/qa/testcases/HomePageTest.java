package com.evevoni.qa.testcases;

import com.evevoni.qa.base.TestBase;
import static com.evevoni.qa.base.TestBase.driver;
import com.evevoni.qa.pages.CheckOutPage;
import com.evevoni.qa.pages.HomePage;
import com.evevoni.qa.pages.MyAccountPage;
import com.evevoni.qa.pages.SubscribeToOurNewsLettersPage;
import com.evevoni.qa.pages.WigCapOffersPage;
import com.evevoni.qa.util.TestUtil;

import org.apache.log4j.Logger;
import org.eclipse.jetty.util.log.Log;
import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *test cases should be separated -- independent with each other
//before each test case -- launch the browser and login
//@test -- execute test case
//after each test case -- close the browser
 * @author yvonneak
 */
public class HomePageTest extends TestBase{
    
    CheckOutPage checkOutPage;
    HomePage homePage;
    MyAccountPage myAccountPage;
    SubscribeToOurNewsLettersPage  subscribeToOurNewsLettersPage;
    WigCapOffersPage wigCapOffersPage;
    TestUtil testUtil;
    Logger log= Logger.getLogger(MyAccountPageTest.class);
    
    public HomePageTest(){
        super();
    }

    @BeforeMethod
    public void setUp() throws InterruptedException{
        initialization();
        testUtil = new TestUtil();
        checkOutPage = new CheckOutPage();
        homePage = new HomePage();
        myAccountPage = new MyAccountPage();
        //subscribeToOurNewsLettersPage = new SubscribeToOurNewsLettersPage();
        //wigCapOffersPage= new WigCapOffersPage();
        
        Thread.sleep(2000);
        //lets identify the popup id
        //String popUpbox =driver.getWindowHandle();
        //System.out.println(popUpbox);
        
        homePage.clickCloseSubscribePopUp();
        //homePage.
        Thread.sleep(2000);
        homePage.clickMyAccount();
        Thread.sleep(2000);
        String accPTitle = myAccountPage.validateMyAccountPageTitle();
        System.out.println(accPTitle);
        
        Assert.assertEquals(accPTitle, "My account – Evevoni");
        //logging in would retrun us to the account page
       myAccountPage= myAccountPage.login(prop.getProperty("username"), prop.getProperty("password"));
    
    
    }
    /*
    @Test(priority=1)
    public void verifyHomePageTitleTest(){
        
        String homePageTitle = homePage.verifyHomePageTitle();
        //confirming the homePage title is correct.
        Assert.assertEquals(homePageTitle, "Evevoni – Professional wig caps for wig making");
        
    }
     
     @Test(priority=2)
     public void clickmyAccountTest() throws InterruptedException{
         Thread.sleep(1000);
         homePage.clickCloseSubscribePopUp();
         Thread.sleep(2000);
         homePage.clickmyAccount();
         Thread.sleep(2000);
         
         //when users log in the landing page is accountPage
         myAccountPage = myAccountPage.login(prop.getProperty("username"), prop.getProperty("password"));
         
     }*/
     
     @Test(priority=1)
     public void verifyCorrectUserNameTest(){
         Assert.assertTrue(homePage.verifyCorrectUserName());
        //log.info(" User is login as " + homePage.userNameLable);
     }
    /*
    @Test(priority=1)
    public void getHomepageID() throws InterruptedException{
         //Thread.sleep(2000);
        //lets identify the popup id
        String homepageid =driver.getWindowHandle();
        System.out.println("H " +homepageid);
        
        Thread.sleep(2000);
        //lets identify the popup id
        String popUpbox =driver.getWindowHandle();
        System.out.println("p "+popUpbox);
        
        driver.switchTo().window(popUpbox);
        //driver.popUpbox;
        homePage.clickcloseSubscribePopUp();
    }*/
    /*
    @Test(priority=2)
    public void getWindowPopUp() throws InterruptedException{
         Thread.sleep(2000);
        //lets identify the popup id
        String popUpbox =driver.getWindowHandle();
        System.out.println("p "+popUpbox);
        
      
    }*/
    /*
    @Test(priority=1)
    public void clickcloseSubscribePopUpTest() throws InterruptedException{
         String homepageid =driver.getWindowHandle();
        //System.out.println("H " +homepageid);
        
        Thread.sleep(2000);
        //lets identify the popup id
        String popUpbox =driver.getWindowHandle();
       // System.out.println("p "+popUpbox);
        
        driver.switchTo().window(popUpbox);
        //driver.popUpbox;
        homePage.clickcloseSubscribePopUp();
    }*/
   
     @AfterMethod
    public void tearDown(){
       
      driver.quit();
    }
}



