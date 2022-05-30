package util;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class ElementHelper {
    AppiumDriver driver;
    WebDriverWait wait;
    Actions action;

    public ElementHelper(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.action = new Actions(driver);
    }

    /** Finds the given element.
     * @param key Distinctive value of the element.
     * @return Specified element is returned.
     */
    public WebElement findElement(By key) {
        WebElement element = presenceElement(key);
        //scrollToElement(element);
        return element;
    }

    /** Finds given elements.
     * @param key Distinctive value of elements.
     * @return Specified elements are returned.
     */
    public List<WebElement> findElements(By key) {
        List<WebElement> elements = presenceElements(key);
        //scrollToElement(elements.get(0));
        return elements;
    }

    /** Specified element is clicked.
     * @param key Distinctive value of the element.
     */
    public void click(By key) {
        findElement(key).click();
    }

    /** Given input is written in the specified element.
     * @param key Distinctive value of the element.
     * @param text Desired input.
     */
    public void sendKey(By key, String text) {
        findElement(key).sendKeys(text);
    }

    /** Returns specified element's text value.
     * @param key Distinctive value of the element.
     * @return Specified element's text value is returned.
     */
    public String getText(By key) {
        return findElement(key).getText();
    }


    /** Checks if the specified element is present.
     * @param key Distinctive value of the element.
     */
    public void checkElementPresence(By key) {
        wait.until(ExpectedConditions.presenceOfElementLocated(key));
    }

    /** Asserts the title of the current page with the given input.
     * @param text Given input.
     * @return true, if the title of the current page is same as input; false otherwise.
     */
    public boolean checkTitle(String text) {
        return wait.until(ExpectedConditions.titleIs(text));
    }

    /** Gets the specified elements specified attribute.
     * @param key Distinctive value of the element.
     * @param attr Specified attribute.
     * @return Text of the specified elements specified attribute.
     */
    public String getAttribute(By key, String attr) {
        return findElement(key).getAttribute(attr);
    }

    /** Asserts if the specified element's specified attribute is equal to given input.
     * @param key Distinctive value of the element.
     * @param attr Specified attribute.
     * @param text Given input.
     */
    public void checkAttribute(By key, String attr, String text) {
        Assert.assertEquals(getAttribute(key, attr), text);
    }

    /** Clicks the specified element.
     * @param key Distinctive value of the element.
     * @param text Given input.
     */
    public void clickElementWithText(By key, String text) {
        boolean find = false;
        List<WebElement> elements = findElements(key);
        for (WebElement element : elements) {
            if (element.getText().contains(text)) {
                element.click();
                find = true;
                break;
            }
        }
        Assert.assertEquals(true, find);
    }

    /** Asserts if the specified element is equal to given input.
     * @param key Distinctive value of the element.
     * @param text Given input.
     */
    public void checkElementWithText(By key, String text) {
        boolean find = false;
        List<WebElement> elements = findElements(key);
        for (WebElement element : elements) {
            if (element.getText().contains(text)) {
                find = true;
                break;
            }
        }
        Assert.assertEquals(true, find);
    }

    /** Gets specified element.
     * @param key Distinctive value of the element.
     * @return Specified WebElement.
     */
    public WebElement presenceElement(By key) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(key));
    }

    /** Gets specified elements.
     * @param key Distinctive value of the element.
     * @return Specified WebElements.
     */
    public List<WebElement> presenceElements(By key) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(key));
    }

    /** Scrolls to WebElement.
     * @param element Given WebElement.
     */
    public void scrollToElement(WebElement element) {
        String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                + "var elementTop = arguments[0].getBoundingClientRect().top;"
                + "window.scrollBy(0, elementTop-(viewPortHeight/2));";
        ((JavascriptExecutor) driver).executeScript(scrollElementIntoMiddle, element);
    }

    /** Drags on the coordinates of point firstX, firstY and drops on the coordinates of lastX, lastY.
     * @param firstX X-axis of drag operation.
     * @param firstY Y-axis of drag operation.
     * @param lastX X-axis of drop operation.
     * @param lastY Y-axis of drop operation.
     */
    public void dragAndDropElement(int firstX, int firstY, int lastX, int lastY) {
        new TouchAction(driver).press(PointOption.point(firstX, firstY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
                .perform().moveTo(PointOption.point(lastX, lastY))
                .release()
                .perform();
    }
}
