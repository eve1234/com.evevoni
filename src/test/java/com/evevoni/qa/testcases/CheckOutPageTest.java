package com.evevoni.qa.testcases;

import com.evevoni.qa.base.TestBase;
import static com.evevoni.qa.base.TestBase.driver;
import com.evevoni.qa.pages.CheckOutPage;
import com.evevoni.qa.pages.HomePage;
import com.evevoni.qa.pages.MyAccountPage;
import com.evevoni.qa.util.TestUtil;
import java.io.IOException;
import jxl.read.biff.BiffException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author yvonneak
 * This class should first call the MyAccountpaPe to register user, 
 * log user in, 
 * then add item/items to cart
 * Then click CheckOutPage to check out. 
 * Complete the shipping info
 */
public class CheckOutPageTest extends TestBase{
    TestUtil testUtil;
    CheckOutPage checkOutPage;
    HomePage homePage;
    MyAccountPage myAccountPage;
    
    String sheetName = "newUserRegisters";
    
    //null exception would occur if super() class is not refered
    public CheckOutPageTest(){
        super();
    }
    
    @BeforeMethod
    public void setUp() throws InterruptedException{
        initialization();
        testUtil = new TestUtil();
        checkOutPage = new CheckOutPage();
        homePage = new HomePage();
        myAccountPage= new MyAccountPage();
        Thread.sleep(2000);
        
        homePage.clickCloseSubscribePopUp();
        
        Thread.sleep(2000);
        homePage.clickMyAccount();
        Thread.sleep(2000);
        
        //logging in would retrun us to the account page
     // myAccountPage= myAccountPage.login(prop.getProperty("username"), prop.getProperty("password"));
        
    }
    /*
   @Test(priority=1)
    public void checkOutPageRe(){
        myAccountPage= myAccountPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }*/
    
        @DataProvider
	public Object[][] getEvevoniTestData() throws IOException, BiffException{
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
    
    /*Get the data from the dataProvider to setup a newUser
    login the new user
    add item/items to shopping cart 
    then complete the shipping info on the checkou
    */
    
   /* @Test(priority=1, dataProvider="getEvevoniTestData")
    public void accountShippingRegisterTest(String userName, String userPwd, String firstN, String sName, String shippingCountry, String shippingCity) throws InterruptedException{
        
        System.out.println(userName + userPwd + firstN + sName + shippingCountry + shippingCity);
        //Thread.sleep(2000);
       // checkOutPage.newMyAccountPageRegister(userName,  userPwd);
        //Thread.sleep(2000);
        //checkOutPage.newMyAccountPageLogin(userName, userPwd);
        Thread.sleep(2000);
      
        //Thread.sleep(2000);
        //checkOutPage.accountShippingRegister(firstN, sName, shippingCountry, shippingCity);
    
       // checkOutPage.accountShippingRegister(sName, sName, shippingCountry, shippingCity);
    
       // checkOutPage
        System.out.println("New user registered and shiping details completed " + checkOutPage);
    }*/
    
    @AfterMethod
    public void tearDown(){
       
      driver.quit();
    }

    
    
}

