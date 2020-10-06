package ir.divar.market;

import ir.divar.TestBase;
import ir.divar.util.SeleniumHelper;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class SignupAgainAfterSignupMarket extends TestBase {
    public String baseUrl = "https://divar.ir/";

    private static final String buttonSakhteMarket = "/html/body/main/section[1]/div/button";
    private static final String textNameFamily = "/html/body/main/section[3]/div/form/input[1]";
    private static final String textPhoneNum = "/html/body/main/section[3]/div/form/input[2]";
    private static final String textProduct = "/html/body/main/section[3]/div/form/input[3]";
    private static final String buttonSakhtMarket = "/html/body/main/section[3]/div/form/button";
    private static final String textEnterConfirmation = "/html/body/div[6]/div/div/div[2]/div/div[2]/div[1]/div/div/div/input";
    private static final String buttonMarketSubmit = "/html/body/div[1]/div[2]/div/div/div/div/div[1]/form/button";
    private static final String textQueueForAccept = "/html/body/div[1]/div[2]/div/div/div/div/p";
    private static final String textMarketManagement = "/html/body/div[1]/div[2]/div/div/div/div[2]/div/div[1]/div/a[1]/div";
    private static final String tabMarket = "/html/body/div[1]/nav/div[2]/a[1]";


    @Test(priority = 0)
    public void testIsPageAvailabe() {
        SeleniumHelper.openPage(baseUrl, tabMarket);
    }

    @Test(priority = 1)
    public void testMarketManagePage() {
        SeleniumHelper.click(tabMarket);
    }

    @Ignore
    @Test(priority = 1)
    public void signupAgainAfterSignupMarketBeforeAdminAccept() throws InterruptedException {

        SeleniumHelper.waitToBeClickable(buttonSakhteMarket);
        SeleniumHelper.click(buttonSakhteMarket);
        SeleniumHelper.waitAndFill(textNameFamily, "آرزو تستی");
        SeleniumHelper.waitAndFill(textPhoneNum, "09950000003");
        SeleniumHelper.waitAndFill(textProduct, "همه چی واسه خودکار");
        SeleniumHelper.click(buttonSakhtMarket);

    }


}