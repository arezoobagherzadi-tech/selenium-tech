/*
package ir.divar.advertisement;

import ir.divar.login.LoginTest;
import ir.divar.util.SeleniumHelper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;

public class AvertisementTest {
    static{
        System.setProperty("webdriver.gecko.driver", "C:\\MyWorks\\lib\\geckodriver.exe");
    }
    private static final String sabteAgahiPath ="/html/body/div[1]/nav/div[2]/div[1]/a";
    private static final String electronicDevicesPath= "/html/body/div[1]/div[2]/div/div/div/div/div/div[3]";
    private static final String mobileAndTabletPath = "/html/body/div[1]/div[2]/div/div/div/div/div/div[2]";
    private static final String mobilePath = "/html/body/div[1]/div[2]/div/div/div/div/div/div[2]";
    private static final String cityPath = "/html/body/div[1]/div[2]/div/div/div/div/div[2]/div/div[1]/form/div/div/div/fieldset/div[1]/div/div/div/div[1]/div[1]/div[2]/input";
    private static final String tehranPath = "/html/body/div[1]/div[2]/div/div/div/div/div[2]/div/div[1]/form/div/div/div/fieldset/div[1]/div/div/div/div/div/div[2]/div[2]/div";
    private static final String cityDistrictPath = "/html/body/div[1]/div[2]/div/div/div/div/div[2]/div/div[1]/form/div/div/div/fieldset/div[1]/div/div/div/div[1]/div[2]/div[2]/input";
    private static final String parvazPath ="/html/body/div[1]/div[2]/div/div/div/div/div[2]/div/div[1]/form/div/div/div/fieldset/div[1]/div/div/div/div[1]/div[2]/div[2]/div[2]/div[1]";
    private static final String sazandePath ="//*[@id=\"root_brand\"]";
    private static final String supportMultiSimPath ="//*[@id=\"root_multi_sim_card_support\"]";
    private static final String vazeiatPath ="//*[@id=\"root_status\"]";
    private static final String darhadeNo ="/html/body/div[1]/div[2]/div/div/div/div/div[2]/div/div[1]/form/div/div/div/fieldset/div[5]/div/div[2]/select/option[3]";
    private static final String chellphonePath ="/html/body/div[1]/div[2]/div/div/div/div/div[2]/div/div[1]/form/div/div/div/fieldset/div[9]/div/div/fieldset/div[1]/div/div[3]/div/div/div/input";
    private static final String phoneNum ="09950000001";
    private static final String titlePath ="/html/body/div[1]/div[2]/div/div/div/div/div[2]/div/div[1]/form/div/div/div/fieldset/div[10]/div/div[3]/div/div/div/input";
    private static final String title ="گوشی موبایل هواوی تست خودکار";
    private static final String descriptionPath ="/html/body/div[1]/div[2]/div/div/div/div/div[2]/div/div[1]/form/div/div/div/fieldset/div[11]/div/div[3]/div/div/textarea";
    private static final String description ="گوشی سالم، بدون خط و خش، در حد نو، رنگ گلد";
    private static final String imagePath ="/html/body/div[1]/div[2]/div/div/div/div/div[2]/div/div[1]/form/div/div/div/fieldset/div[2]/div/div/div/div[3]/div";
    private static final String localImageUrl ="C:\\Users\\baghe\\Desktop\\mobile.jpg";
    private static final String subitButtonPath="//*[@id=\"app\"]/div[2]/div/div/div/div/div[2]/div/div[1]/form/button";
    private static final String textConfirmationCode="/html/body/div[7]/div/div/div[2]/div/div[2]/div[1]/div/div/div/input";


    @Test
    public static void doRegister() {

        SeleniumHelper.waitForMainPage(sabteAgahiPath,"SabteAgahi");
        //Click on sabte agahi
        SeleniumHelper.waitAndClick(sabteAgahiPath,"Sabte Agahi");
        //Click on Electronic Devices
        SeleniumHelper.waitAndClick(electronicDevicesPath,"Electronic devices");
        //Click on mobile And Tablet
        SeleniumHelper.waitAndClick(mobileAndTabletPath,"mobile And Tablet");
        //Click on mobile
        SeleniumHelper.waitAndClick(mobilePath,"mobile");
        // Click and fill on city
        SeleniumHelper.waitAndFill(cityPath,"تهران");
        // Click Enter
        SeleniumHelper.sendEnter(cityPath,"تهران");
        //Click and fill mahdude
        SeleniumHelper.waitAndFill(cityDistrictPath,"پرواز");
        // Click Enter
        SeleniumHelper.sendEnter(cityDistrictPath,"پرواز");

        //Click on Upload image
        SeleniumHelper.waitAndClick(imagePath, "Select File Button");
        try {
            SeleniumHelper.uploadFile(localImageUrl);
        } catch (AWTException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //Click and fill sazande
        SeleniumHelper.waitAndFill(sazandePath,"h");
        //Click on poshtibani az chand sim
        SeleniumHelper.waitAndClick(supportMultiSimPath,"support multi sim");
        // Select support multiple sim
        SeleniumHelper.waitAndFill(vazeiatPath,"support multi sim");
        // Choose dar hade no
        SeleniumHelper.waitAndClick(darhadeNo,"dar hade no");
        // Click and fill cellphone
        SeleniumHelper.waitAndFill(chellphonePath,phoneNum);
        // Click and fill title
        SeleniumHelper.waitAndFill(titlePath,title);
        // cLICK and fill desc
        SeleniumHelper.waitAndFill(descriptionPath,description);
        // Click submit button
        SeleniumHelper.waitAndClick(subitButtonPath,"sabte agahi");
        SeleniumHelper.waitAndFill(textConfirmationCode,"147258");


    }
}
*/
