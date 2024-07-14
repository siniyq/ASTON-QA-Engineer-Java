package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Utils {

    public static void validateLogo(WebDriver driver, String xpath, String expectedAlt) {
        WebElement element = driver.findElement(By.xpath(xpath));
        Assert.assertEquals(element.getAttribute("alt"), expectedAlt);
    }

    public static void fillAndSubmitForm(WebDriver driver, String phoneSelector, String phone, String sumSelector, String sum, String formSelector) {
        WebElement phoneInput = driver.findElement(By.cssSelector(phoneSelector));
        phoneInput.click();
        phoneInput.sendKeys(phone);

        WebElement sumInput = driver.findElement(By.cssSelector(sumSelector));
        sumInput.click();
        sumInput.sendKeys(sum);

        WebElement paymentForm = driver.findElement(By.cssSelector(formSelector));
        paymentForm.submit();
    }
}

