package com.evevoni.qa.testcases;

import com.evevoni.qa.base.TestBase;

import static com.evevoni.qa.base.TestBase.initialization;



import com.evevoni.qa.pages.HomePage;
import com.evevoni.qa.pages.MyAccountPage;
import com.evevoni.qa.util.TestUtil;
import java.io.IOException;



import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



/**
 *
 * @author yvonneak
 */
public class MyAccountPageTest extends TestBase{
    TestUtil testUtil;
    //CheckOutPage checkOutPage;
    HomePage homePage;
    MyAccountPage myAccountPage;
    
    String sheetName = "newUserRegisters";
    String sheetName2 = "userlogins";
    
    public MyAccountPageTest(){
        super();
    }
    
    @BeforeMethod
    public void setUp() throws InterruptedException{
        initialization();
        testUtil = new TestUtil();
        homePage = new HomePage();
        myAccountPage = new MyAccountPage();
        
        
        Thread.sleep(2000);
        
       homePage.clickCloseSubscribePopUp();
        Thread.sleep(1000);
        homePage.clickMyAccount();
        Thread.sleep(2000);
        //logging in would retrun us to the account page
       // myAccountPage = myAccountPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }
   /*
    @Test(priority=1)
    public void validateMyAccountPageTitleTest() throws InterruptedException{
         Thread.sleep(1000);
        
        myAccountPage = myAccountPage.login(prop.getProperty("username"), prop.getProperty("password"));
        
        Thread.sleep(2000);
        String title = myAccountPage.validateMyAccountPageTitle();
        System.out.println(title);
        Assert.assertEquals(title, "Evevoni – Professional wig caps for wig making");
    
        Thread.sleep(2000);
        
        
    
    }*/
    /*
    //we have no logo to test
    @Test(priority=2)
    public void validateEvevoniLogoTest(){
        boolean flag =myAccountPage.validateEvevoniLogo();
        //System.out.println(flag)
        Assert.assertTrue(flag);
    }  */
    
    @DataProvider
    public Object[][] getLoginDataTest(){
        Object data[][]=TestUtil.getLonginData(sheetName2);
        return data;
    }
    
    @DataProvider
    public Object[][] getEvevoniTestData() throws IOException{
            Object data[][] = TestUtil.getTestData(sheetName);
            return data;
    }
    
   @Test(priority=1, dataProvider="getEvevoniTestData")
   public void accountRegistration(String regEmail, String regPsswd, String billingFirstName, String billingLastNameField, String billingCountryField, String billingCity, String billingPostcode, String billingPhoneField) throws InterruptedException {
   
       //Integer phNUm = Integer.parseInt(billingPhoneField);
       //System.out.println(phNUm);
       //Integer postCd = Integer.parseInt(billingPhoneField);
       myAccountPage.newAccountReg(regEmail, regPsswd, billingFirstName, billingLastNameField, billingCountryField, billingCity, billingPostcode, billingPhoneField);
    
       
       
    }
   
   @Test(priority=2)
   public void accountLoginTest(){
       myAccountPage = myAccountPage.login(prop.getProperty("username"), prop.getProperty("password"));
       
   }

    @AfterMethod
    public void tearDown(){
       
      driver.quit();
    }


}

