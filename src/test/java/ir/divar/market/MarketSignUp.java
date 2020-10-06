package ir.divar.market;

import ir.divar.TestBase;
import ir.divar.util.SeleniumHelper;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class MarketSignUp extends TestBase {

    public String baseUrl = "https://sell.divar.ir/";

    private static final String buttonSakhtMarket = "/html/body/main/section[3]/div/form/button";
    private static final String textNameFamily = "/html/body/main/section[3]/div/form/input[1]";
    private static final String textPhoneNum = "/html/body/main/section[3]/div/form/input[2]";
    private static final String textProduct = "/html/body/main/section[3]/div/form/input[3]";
    private static final String textSuccessfullySentConfirmation = "/html/body/div[6]/div/div/div[2]/div/div[1]";
    private static final String textEnterConfirmation = "/html/body/div[6]/div/div/div[2]/div/div[2]/div[1]/div/div/div/input";
    private static final String textSabteMarket = "/html/body/div[1]/div[2]/div/div/div/h2";
    private static final String textMarketName = "/html/body/div[1]/div[2]/div/div/div/div/div[1]/form/div/div/div/fieldset/div[1]/div/div[2]/div/div/div/input";
    private static final String textMarketDescription = "/html/body/div[1]/div[2]/div/div/div/div/div[1]/form/div/div/div/fieldset/div[2]/div/div[3]/div/div/div/input";
    private static final String textMarketAddress = "/html/body/div[1]/div[2]/div/div/div/div/div[1]/form/div/div/div/fieldset/div[3]/div/div[3]/div/div/textarea";
    private static final String mapMarketLocation = "/html/body/div[1]/div[2]/div/div/div/div/div[1]/form/div/div/div/fieldset/div[4]/div/div/div/div[2]/div[2]";
    private static final String buttonIsMarketLocation = "/html/body/div[1]/div[2]/div/div/div/div/div[1]/form/div/div/div/fieldset/div[4]/div/div/div/div[3]/div[2]/button";
    private static final String textMarketArea = "/html/body/div[1]/div[2]/div/div/div/div/div[1]/form/div/div/div/fieldset/div[4]/div/div/div/div[1]/div[2]/div[2]/input";
    private static final String textMarketCodePosti = "/html/body/div[1]/div[2]/div/div/div/div/div[1]/form/div/div/div/fieldset/div[6]/div/div[3]/div/div/div/input";
    private static final String imageUploaderMarketParvane = "/html/body/div[1]/div[2]/div/div/div/div/div[1]/form/div/div/div/fieldset/div[7]/div/div/div/div[3]/div/i/i[1]";
    private static final String textMarketOwnerName = "/html/body/div[1]/div[2]/div/div/div/div/div[1]/form/div/div/div/fieldset/div[9]/div/div[2]/div/div/div/input";
    private static final String textMarketOwnerCodeMeli = "/html/body/div[1]/div[2]/div/div/div/div/div[1]/form/div/div/div/fieldset/div[10]/div/div[2]/div/div/div/input";
    private static final String imageUploaderMarketOwnerCodeMeli = "/html/body/div[1]/div[2]/div/div/div/div/div[1]/form/div/div/div/fieldset/div[11]/div/div/div/div[3]/div";
    private static final String localParvaneImageUrl = "C:\\Users\\baghe\\Desktop\\parvane.jfif";
    private static final String localMeliCardImageUrl = "C:\\Users\\baghe\\Desktop\\meliCard.jfif";
    private static final String buttonMarketSubmit = "/html/body/div[1]/div[2]/div/div/div/div/div[1]/form/button";
    private static final String textSuccessfullySubmitMarket = "/html/body/div[1]/div[2]/div/div/div/div/p";
    private static final String buttonSakhteMarket = "/html/body/main/section[1]/div/button";
    private static final String textQueueForAccept = "/html/body/div[1]/div[2]/div/div/div/div/p";
    private static final String imgMeliCardUploaded = "/html/body/div[1]/div[2]/div/div/div/div/div[1]/form/div/div/div/fieldset/div[11]/div/div/div/div[3]/div/div";
    private static final String imgDeleteIconMeliCardUploaded = "/html/body/div[1]/div[2]/div/div/div/div/div[1]/form/div/div/div/fieldset/div[11]/div/div/div/div[3]/div/button/i";


    @Ignore
// باید یه کاری کنیم که اول کلاس deleteMarket اجرا شه بعد marketSignup  و بعد AcceptAdmin
    @Test(priority = 0)
    public void deleteStoreUser() {
        SeleniumHelper.deleteStoreUser_Ongoing();
    }

    @Test(priority = 1)
    public void testIsPageAvailabe() {
        SeleniumHelper.forwardPage(baseUrl, buttonSakhteMarket);

    }

    @Test(priority = 2)
    public void sellerPage() {
        SeleniumHelper.waitToBeClickable(buttonSakhteMarket);
        SeleniumHelper.click(buttonSakhteMarket);
        SeleniumHelper.waitAndFill(textNameFamily, "آرزو تستی");
        SeleniumHelper.waitAndFill(textPhoneNum, "09950000003");
        SeleniumHelper.waitAndFill(textProduct, "همه چی واسه خودکار");
        SeleniumHelper.click(buttonSakhtMarket);

//        Assert.assertTrue(SeleniumHelper.isVisibleText(textSuccessfullySentConfirmation));
        SeleniumHelper.waitAndFill(textEnterConfirmation, "147258");
//        Assert.assertTrue(SeleniumHelper.isVisibleText(textSabteMarket));

    }

    @Test(priority = 3)
    public void fillMarketPage() {
        SeleniumHelper.waitAndFill(textMarketName, "فروشگاه آرزو تست خودکار");
        SeleniumHelper.fill(textMarketDescription, "توضیحات فروشگاه آرزو");
        SeleniumHelper.fill(textMarketAddress, "تهران، پرواز، پارک پرواز");

//**************************  35.790227, 51.356671 MAP ************************************************************************
        SeleniumHelper.waitAndFill(textMarketArea, "پرواز");
        SeleniumHelper.sendEnter(textMarketArea, "پرواز");
        SeleniumHelper.waitAndClick(mapMarketLocation, "market location clicked on map");
        SeleniumHelper.waitAndClick(buttonIsMarketLocation, "button is market location clicked on map");

//************************************************************************************************
        SeleniumHelper.waitAndFill(textMarketCodePosti, "1414141414");

        SeleniumHelper.waitAndClick(imageUploaderMarketParvane, "Select Parvane File Button");
        SeleniumHelper.uploadFile(localParvaneImageUrl);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        SeleniumHelper.waitAndFill(textMarketOwnerName, "آرزو باقرزادی");
        SeleniumHelper.waitAndFill(textMarketOwnerCodeMeli, "1010101010");

        SeleniumHelper.waitAndClick(imageUploaderMarketOwnerCodeMeli, "Select Meli Card File Button");
        SeleniumHelper.uploadFile(localMeliCardImageUrl);


//        SeleniumHelper.click(localMeliCardImageUrl);


    }

    @Test(priority = 4)
    public void submitMarket() {
//        SeleniumHelper.waitAndClick(textMarketOwnerCodeMeli,"");
//        SeleniumHelper.sendTab(textMarketOwnerCodeMeli,"tab click on textMarketOwnerCodeMeli");
//        SeleniumHelper.sendTab(imgMeliCardUploaded,"tab click on imgMeliCardUploaded");
//        SeleniumHelper.sendTab(imgDeleteIconMeliCardUploaded,"tab click on imgdeleteMeliCardUploaded");
//        SeleniumHelper.sendEnter(buttonMarketSubmit,"enter clicked on imgMeliCardUploaded");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//
        SeleniumHelper.waitAndClick(buttonMarketSubmit, "buttonMarketSubmit");


//        SeleniumHelper.sendTabOnActiveElement();
//        SeleniumHelper.sendTabOnActiveElement();
//        SeleniumHelper.enterOnActiveElement();

        SeleniumHelper.isWaitToBeVisible(textQueueForAccept);
    }




}