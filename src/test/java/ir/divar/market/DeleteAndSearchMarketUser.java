package ir.divar.market;

import ir.divar.TestBase;
import ir.divar.util.SeleniumHelper;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteAndSearchMarketUser extends TestBase {
    public String adminBaseUrl = "https://marketplace-admin.divar.ir/admin/";
    private static final String textAdminUserName = "//*[@id=\"id_username\"]";
    private static final String textAdminPass = "//*[@id=\"id_password\"]";
    private static final String buttonLoginAdmin = "/html/body/div/div[2]/div/form/div[3]/input";
    private static final String linkStoreUsers = "/html/body/div/div[2]/div[1]/div[1]/table/tbody/tr[3]/th/a";
    private static final String textSearchStoreUsers = "//*[@id=\"searchbar\"]";
    private static final String buttonSearch = "/html/body/div/div[3]/div/div/div[1]/form/div/input[2]";
    private static final String linkSearchUsersResult = "/html/body/div/div[3]/div/div/form/div[2]/table/tbody/tr/th/a";
    private static final String buttonDeleteUsers = "/html/body/div/div[3]/div/form/div/div/p/a";
    private static final String submitDeleteUsers = "/html/body/div/div[3]/form/div/input[2]";
    private static final String textSuccessfullyDeleteUser = "/html/body/div/ul/li";
    private static final String textCantDeleteUser = "/html/body/div/div[3]/h1";
    private static final String textRelatedMarketToUserForDelete = "/html/body/div/div[3]/ul/li/a";
    private static final String textChangeOngoingStore = "/html/body/div/div[3]/h1";
    private static final String buttonDeleteInOngoingStore = "/html/body/div/div[3]/div/form/div/div/p";
    private static final String buttonYesDeleteImSure = "/html/body/div/div[3]/form/div/input[2]";
    private static final String lableSuccessfullyDeleteMarket = "/html/body/div/ul/li";
    private static final String text0StoreUser = "/html/body/div/div[3]/div/div/form/p";
    private static final String textShuru = "/html/body/div/div[2]/a[1]";
    private static final String linkOngoing = "/html/body/div/div[2]/div[1]/div[1]/table/tbody/tr[1]/th/a";
    private static final String textSearchOngoing = "//*[@id=\"searchbar\"]";
    private static final String textMarketMobileNum = "9950000003";
    private static final String buttonSearchUsers = "/html/body/div/div[3]/div/div/div[1]/form/div/input[2]";


    @Test(priority = 0)
    public void testIsAdminPageAvailabe() {
        SeleniumHelper.openPage(adminBaseUrl, buttonLoginAdmin);
    }

    @Test(priority = 1)
    public void marketplaceAdminPage() {
        SeleniumHelper.waitAndFill(textAdminUserName, "arezoo.bagherzadi");
        SeleniumHelper.waitAndFill(textAdminPass, "Are516zoo");
        SeleniumHelper.waitAndClick(buttonLoginAdmin, "button login clicked");
    }
//☺☻☺
    @Test(priority = 2)
    public void searchAndDeleteMarket() {
        SeleniumHelper.waitAndClick(linkOngoing, "ongoing link clicked");
        SeleniumHelper.waitAndClick(textSearchOngoing, "ongoing search clicked");
        SeleniumHelper.waitAndFill(textSearchOngoing, textMarketMobileNum);
        SeleniumHelper.waitAndClick(buttonSearch, "buttonSearch clicked");

        SeleniumHelper.waitAndClick(linkSearchUsersResult, "linkSearchUsersResult clicked");
        SeleniumHelper.waitAndClick(buttonDeleteUsers, "buttonDeleteUsers clicked");
        SeleniumHelper.waitAndClick(submitDeleteUsers, "submitDeleteUsers clicked");
        Assert.assertTrue(SeleniumHelper.isVisibleText(text0StoreUser));
    }

    // search store user
    @Test(priority = 3)
    public void searchStoreUsers() {
        SeleniumHelper.waitAndClick(textShuru, "textShuru clicked");
        SeleniumHelper.waitAndClick(linkStoreUsers, "link store user clicked");
        SeleniumHelper.waitAndFill(textSearchStoreUsers, "9950000003");
        SeleniumHelper.waitAndClick(buttonSearchUsers, "button search user clicked");

    }

    // delete store user
    @Test(priority = 4)
    public void deleteStoreUsers() {

        SeleniumHelper.waitAndClick(linkSearchUsersResult, "link search store user clicked");
        SeleniumHelper.waitAndClick(buttonDeleteUsers, "delete button clicked");
        SeleniumHelper.waitAndClick(submitDeleteUsers, " submit delete button clicked");
    }

}
