
package org.example.mts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Less15 {

    public static void main(String[] args) {
            System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
            WebDriver driver;
            driver = new ChromeDriver();
            driver.get("https://www.mts.by/");
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement button= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='cookie__buttons']/button[@id='cookie-agree']")));
        //Нажатие кнопки для принятия Coockies.
        button.click();
    }
}

