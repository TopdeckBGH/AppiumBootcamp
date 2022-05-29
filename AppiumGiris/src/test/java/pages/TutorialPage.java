package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementHelper;

public class TutorialPage {


    AppiumDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;

    public TutorialPage(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelper = new ElementHelper(driver);
    }

    By tvText = By.id("com.lcwaikiki.android:id/textView");
    By tvTitleText = By.id("com.lcwaikiki.android:id/tvTitle");
    By tvDescText = By.id("com.lcwaikiki.android:id/tvContent");
    By tvSkipButton = By.id("com.lcwaikiki.android:id/tvNext");
    By tvTutorial = MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"com.lcwaikiki.android:id/vpTutorial\").childSelector(new UiSelector().className(\"android.widget.FrameLayout\").index(1))");
    By welcomeText = By.id("com.lcwaikiki.android:id/txtWelcomeHeader");

    By searchButton = MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"com.lcwaikiki.android:id/searchIcon\")");
    By searchButtonProduct = MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"com.lcwaikiki.android:id/toolbar_search\")");

    // Check Tutorial Page Components
    public void checkTutorialPage() { elementHelper.checkElementPresence(tvText);}
    public void checkTVTutorial() { elementHelper.checkElementPresence(tvTutorial);}
    public void checkTVText(String text) { elementHelper.checkElementWithText(tvText, text);}
    public void checkTVTitleText(String text) { elementHelper.checkElementWithText(tvTitleText, text);}
    public void checkTVDescText(String text) { elementHelper.checkElementText(tvDescText, text);}
    public void checkTVButton(String text) { elementHelper.checkElementText(tvSkipButton, text);}

    // Check Drag Drop TvTutorial
    public void dragAndDropTVTutorial() { elementHelper.dragAndDropElement2(600, 600, 0, 600);}

    // Click Skip Button
    public void clickTVSkipButton() { elementHelper.click(tvSkipButton);}
    public void checkWelcomeText(String  text) { elementHelper.checkElementWithText(welcomeText, text);}

    // Add to Favorites and Check
    public void clickSearchButton() { elementHelper.click(searchButton);}
    public void typeSearchButtonProduct (String text) {
        elementHelper.sendKey(searchButtonProduct, text);

        // Native Go Button Try
        /*((AndroidDriver) driver).pressKeyC(new KeyEvent(AndroidKey.SEARCH));
        ((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.SEARCH));
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }
}