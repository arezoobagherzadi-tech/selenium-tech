package ir.divar.login;

import ir.divar.util.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class LoginTest {
    public String baseUrl = "https://divar.ir/my-divar/my-posts";
    String driverPath = "C:\\MyWorks\\lib\\geckodriver.exe";
    public WebDriver driver ;
    WebDriverWait wait;

    private final String buttonLoginPath = "/html/body/div[1]/div[2]/div/div[2]/div/button";
    private final String textBoxMobilePath = "/html/body/div[6]/div/div/div[2]/div/div/div/div/div/div[1]/input";
    private static final String textBoxConfirmCodePath = "/html/body/div[6]/div/div/div[2]/div/div[2]/div[1]/div/div/div/input";
    private static final String buttonConfirmCodePath = "/html/body/div[6]/div/div/div[2]/div/div/button";
    private static final String buttonCloseLogin= "/html/body/div[6]/div/div/div[1]/i";
    private static final String textNullCOdeConfirmation= "/html/body/div[6]/div/div/div[2]/div/div[1]";
    private static final String textSentCodeConfirmation= "/html/body/div[6]/div/div/div[2]/div/div[1]";
    private static final String buttonChangeMobileNumber= "/html/body/div[6]/div/div/div[2]/div/div[3]/div[2]/button";
    private static final String text98="/html/body/div[6]/div/div/div[2]/div/div/div/div/div/div[2]";
    private static final String textTabAgahiMan="/html/body/div[1]/div[2]/div/div[1]/a[1]";
    @BeforeClass
    public void initPage(){
        System.setProperty("webdriver.gecko.driver", "C:\\MyWorks\\lib\\geckodriver.exe");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 30);
    }

    @Test(priority = 0)
    public void testIsPageAvailabe(){
        SeleniumHelper.openPage(baseUrl, buttonLoginPath);
    }

    @Test(priority = 1)
    public void testIsLoginButtonAvailabe(){
        SeleniumHelper.click(buttonLoginPath);
        SeleniumHelper.waitToBeClickable(textBoxMobilePath);
        // confirm button should be inactive without filling mobile number
        Assert.assertFalse(SeleniumHelper.isClickable(buttonConfirmCodePath));
    }

    @Test(priority = 2)
    public void testCloseButtonLogin()
    {
        SeleniumHelper.click(buttonCloseLogin);
        Assert.assertTrue(SeleniumHelper.isClickable(buttonLoginPath));
    }


    @Test(priority = 3)
    public void testFillMobileNumber(){
        SeleniumHelper.click(buttonLoginPath);

        SeleniumHelper.waitAndFill(textBoxMobilePath, "9");
        Assert.assertFalse(SeleniumHelper.isClickable(buttonConfirmCodePath));

        SeleniumHelper.fill(textBoxMobilePath, "9");
        Assert.assertFalse(SeleniumHelper.isClickable(buttonConfirmCodePath));


        SeleniumHelper.fill(textBoxMobilePath, "5");
        Assert.assertFalse(SeleniumHelper.isClickable(buttonConfirmCodePath));

        for (int digit = 0 ; digit < 6 ; digit++){
            SeleniumHelper.fill(textBoxMobilePath, "0");
            Assert.assertFalse(SeleniumHelper.isClickable(buttonConfirmCodePath));
        }

        SeleniumHelper.fill(textBoxMobilePath, "1");
        SeleniumHelper.waitToBeClickable(textBoxConfirmCodePath);
    }
    @Test(priority = 4)
    public void testNullCodeConfirmation(){
        SeleniumHelper.click(buttonConfirmCodePath);
        Assert.assertTrue(SeleniumHelper.isVisibleText(textSentCodeConfirmation));
//        SeleniumHelper.sendEnter("buttonConfirmCodePath","ورود");
        Assert.assertTrue(SeleniumHelper.isVisibleText(textNullCOdeConfirmation));
    }

    @Test (priority = 5)
    public void testChangeMobileNum(){
        SeleniumHelper.click(buttonChangeMobileNumber);
        Assert.assertTrue(SeleniumHelper.isVisibleText(text98));
        SeleniumHelper.clearText(textBoxMobilePath);
        SeleniumHelper.waitAndFill(textBoxMobilePath,"09950000002");
        Assert.assertTrue(SeleniumHelper.isVisibleText(textSentCodeConfirmation));
    }
    @Ignore
    @Test(priority = 6)
    public void testInvalidMobileNum(){
        SeleniumHelper.click(buttonChangeMobileNumber);
        SeleniumHelper.clearText(textBoxMobilePath);
        SeleniumHelper.waitAndFill(textBoxMobilePath,"salaaam");
    }

    @Test(priority = 7)
        public  void FillConfirmationCode(){
    SeleniumHelper.click(buttonChangeMobileNumber);
    SeleniumHelper.clearText(textBoxMobilePath);
    SeleniumHelper.waitAndFill(textBoxMobilePath,"9950000002");

    SeleniumHelper.waitAndFill(textBoxConfirmCodePath,"147258");

//        Assert.assertTrue(SeleniumHelper.isVisibleText(textTabAgahiMan));
    }

    @Test(priority = 7)
    public  void testFillConfirmationCode(){
        SeleniumHelper.fill(textBoxConfirmCodePath,"1");
        Assert.assertFalse(SeleniumHelper.isClickable(buttonConfirmCodePath));


    }

    @Test (priority = 7)
    public void destroy(){
        driver.close();
        System.out.println("destroy");

//        driver.quit();
    }

}
