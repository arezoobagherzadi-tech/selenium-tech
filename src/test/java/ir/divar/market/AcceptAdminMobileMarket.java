package ir.divar.market;

import ir.divar.TestBase;
import ir.divar.util.SeleniumHelper;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class AcceptAdminMobileMarket extends TestBase {
    public String adminBaseUrl = "https://marketplace-admin.divar.ir/admin/";
    public String baseUrl = "https://divar.ir/";
    private static final String textAdminUserName = "//*[@id=\"id_username\"]";
    private static final String textAdminPass = "//*[@id=\"id_password\"]";
    private static final String buttonLoginAdmin = "/html/body/div/div[2]/div/form/div[3]/input";
    private static final String linkOngoingStores = "/html/body/div/div[2]/div[1]/div[1]/table/tbody/tr[1]/th/a";
    private static final String searchbarOngoingStores = "//*[@id=\"searchbar\"]";
    private static final String marketPhoneNumber = "9950000003";
    private static final String linkMarketId = "/html/body/div/div[3]/div/div/form/div[2]/table/tbody/tr/th/a";
    private static final String textSlug = "//*[@id=\"id_slug\"]";
    ////////////////CHANG SLUG////////////////////////////////////////
    private static final String slug = "testarezoo_2";
    private static final String checkboxCategory = "//*[@id=\"id_categories_14\"]";
    private static final String buttonZakhire = "/html/body/div/div[3]/div/form/div/div/input[1]";
    private static final String buttonSearch = "/html/body/div/div[3]/div/div/div[1]/form/div/input[2]";
    private static final String buttonAccept = "/html/body/div/div[3]/div/div/form/div[2]/table/tbody/tr/td[9]/a[1]";
    private static final String textStatusAccept = "/html/body/div/div[3]/div/div/form/div[2]/table/tbody/tr/td[5]";


    @Test(priority = 0)
    public void testIsAdminPageAvailabe() {
        SeleniumHelper.forwardPage(adminBaseUrl, linkOngoingStores);
    }

    @Test(priority = 1)
    public void searchMarketOngoing() {
        SeleniumHelper.click(linkOngoingStores);
        SeleniumHelper.waitAndFill(searchbarOngoingStores, marketPhoneNumber);
        SeleniumHelper.click(buttonSearch);

        SeleniumHelper.waitAndClick(linkMarketId, "market id clicked");
        SeleniumHelper.waitAndFill(textSlug, slug);
        SeleniumHelper.waitAndClick(checkboxCategory, "mobile category selected");
        SeleniumHelper.waitAndClick(buttonZakhire, "zakhire button selected");
        SeleniumHelper.waitToBeClickable(buttonAccept);
        SeleniumHelper.click(buttonAccept);
        Assert.assertTrue(SeleniumHelper.isWaitToBeVisible(textStatusAccept));
    }
}
