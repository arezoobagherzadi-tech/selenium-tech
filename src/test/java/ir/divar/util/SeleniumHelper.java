package ir.divar.util;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Date;

public class SeleniumHelper {
    static {
        System.setProperty("webdriver.gecko.driver", "C:\\MyWorks\\lib\\geckodriver.exe");
    }

    public static WebDriver driver = new FirefoxDriver();
    public static WebDriverWait wait = new WebDriverWait(driver, 50);
    public static WebDriverWait longWait = new WebDriverWait(driver, 70);

    private static final String adminBaseUrl = "https://marketplace-admin.divar.ir/admin/";
    private static final String buttonLoginAdmin = "/html/body/div/div[2]/div/form/div[3]/input";
    private static final String textAdminUserName = "//*[@id=\"id_username\"]";
    private static final String textAdminPass = "//*[@id=\"id_password\"]";
    private static final String linkStoreUsers = "/html/body/div/div[2]/div[1]/div[1]/table/tbody/tr[3]/th/a";
    private static final String textSearchStoreUsers = "//*[@id=\"searchbar\"]";
    private static final String buttonSearchUsers = "/html/body/div/div[3]/div/div/div[1]/form/div/input[2]";
    private static final String linkSearchUsersResult = "/html/body/div/div[3]/div/div/form/div[2]/table/tbody/tr/th/a";
    private static final String buttonDeleteUsers = "/html/body/div/div[3]/div/form/div/div/p/a";
    private static final String submitDeleteUsers = "/html/body/div/div[3]/form/div/input[2]";
    private static final String textSuccessfullyDeleteUser = "/html/body/div/ul/li";
    private static final String text0StoreUser = "/html/body/div/div[3]/div/div/form/p";

    /**
     * to wait until the given path is clickable then click
     * @param path element path
     * @param name element name
     */
    public static void waitAndClick(String path, String name) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(path)));
        driver.findElement(By.xpath(path)).click();
        System.out.println(name + " clicked " + new Date());
    }

    /**
     * to click on given path
     * @param path element path
     */
    public static void click(String path) {
        driver.findElement(By.xpath(path)).click();
    }

    /**
     * to wait until the given path is clickable
     * @param path element path
     */
    public static void waitToBeClickable(String path) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(path)));
    }

    /**
     * to check if element with the given path is clickable
     * @param path element path
     * @return true if item is clickable otherwise false
     */
    public static boolean isClickable(String path) {
        return driver.findElement(By.xpath(path)).isEnabled();
    }

    /**
     *
     * @param path
     * @param value
     */
    public static void waitAndFill(String path, String value) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(path)));
        driver.findElement(By.xpath(path)).sendKeys(value);
        System.out.println(value + " sent " + new Date());
    }

    public static void fill(String path, String value) {
        driver.findElement(By.xpath(path)).sendKeys(value);
    }

    public static void sendEnter(String path, String name) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(path)));
        driver.findElement(By.xpath(path)).sendKeys(Keys.ENTER);
        System.out.println(name + " enter sent " + new Date());
    }

    public static void enterOnActiveElement() {
        WebElement currentElement = driver.switchTo().activeElement();
        currentElement.sendKeys(Keys.ENTER);
        System.out.println(" enter sent for submit button " + new Date());
    }

    public static void sendTab(String path, String name) {
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(path)));
        driver.findElement(By.xpath(path)).sendKeys(Keys.TAB);
        System.out.println(name + " tab sent " + new Date());
    }

    public static void sendTabOnActiveElement() {
        WebElement currentElement = driver.switchTo().activeElement();
        currentElement.sendKeys(Keys.TAB);
        System.out.println(" Tab sent " + new Date());
    }

    /**
     * Uploade file with the filePath
     *
     * @param filePath the path to file
     */
    public static void uploadFile(String filePath) {
        StringSelection ss = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
            System.exit(1);
        }

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.delay(5000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        System.out.println("file uploaded " + filePath);
    }


    public static void openPage(String url, String elementPath) {
        System.out.println("Opening page : " + url);
        driver.manage().window().maximize();
        driver.get(url);
        if (elementPath != null)
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elementPath)));
    }

    public static void forwardPage(String url, String elementPath) {
        driver.navigate().to(url);
        if (elementPath != null)
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elementPath)));
    }

    public static boolean isVisibleText(String path) {
        return driver.findElement(By.xpath(path)).isDisplayed();

    }

    public static boolean isWaitToBeVisible(String path) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(path)));
        return driver.findElement(By.xpath(path)).isDisplayed();
    }

    public static boolean isAvailabe(String path) {
        try {
            driver.findElement(By.xpath(path));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }

    }

    public static void clearText(String path) {
        driver.findElement(By.xpath(path)).clear();
    }


    // Delete store user and ongoing store if it has

    public static boolean deleteStoreUser_Ongoing() {
        //Login marketplaceAdmin Page
        openPage(adminBaseUrl, buttonLoginAdmin);
        waitAndFill(textAdminUserName, "arezoo.bagherzadi");
        fill(textAdminPass, "Are516zoo");
        waitAndClick(buttonLoginAdmin, "button login clicked");
        //SearchStoreUsers Page
        waitAndClick(linkStoreUsers, "link store user clicked");
        fill(textSearchStoreUsers, "9950000003");
        waitAndClick(buttonSearchUsers, "button search user clicked");
        //Delete StoreUsers
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (isAvailabe(linkSearchUsersResult)) {
            waitAndClick(linkSearchUsersResult, "link search store user clicked");
            waitAndClick(buttonDeleteUsers, "delete button clicked");
            waitAndClick(submitDeleteUsers, " submit delete button clicked");
            return true;
        } else {
            if (isVisibleText(text0StoreUser) == true) {

                return true;
            }
        }
        return false;

    }

}
