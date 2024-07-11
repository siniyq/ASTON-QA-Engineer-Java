package org.example.mts;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.jupiter.api.Assertions.*;
import io.qameta.allure.Description;

import java.util.List;

public class MtsByTests {

    public static WebDriver driver;

    @BeforeAll
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.mts.by/");
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@class='cookie__buttons']/button[@id='cookie-agree']")));
        assertNotNull(button, "Кнопка принятия cookie не должна быть null");
        button.click();
    }

    @Test
    @Description("Проверка названия блока 'Онлайн пополнение без комиссии'")
    public void testBlockTitle() {

        WebElement onlineReplenishmentBlock = driver.findElement(By.cssSelector(".pay__wrapper"));
        assertNotNull(onlineReplenishmentBlock, "Блок онлайн пополнения не должен быть null");

        String blockTitle = onlineReplenishmentBlock.findElement(By.tagName("h2")).getText().replaceAll("\\n", " ");
        assertNotNull(blockTitle, "Заголовок блока не должен быть null");
        assertEquals("Онлайн пополнение без комиссии", blockTitle);
    }

    @Test
    @Description("Проверка наличия логотипов платёжных систем")
    public void testPaymentLogos() {

        WebElement paymentSystemLogosBlock = driver.findElement(By.cssSelector(".pay__partners"));
        assertNotNull(paymentSystemLogosBlock, "Блок логотипов платёжных систем не должен быть null");
        assertTrue(paymentSystemLogosBlock.isDisplayed());

        List<WebElement> paymentSystemLogos = paymentSystemLogosBlock.findElements(By.tagName("img"));
        assertNotNull(paymentSystemLogos, "Логотипы платёжных систем не должны быть null");
        assertEquals(5, paymentSystemLogos.size());

        for (WebElement logo : paymentSystemLogos) {
            assertNotNull(logo, "Каждый логотип платёжной системы не должен быть null");
            assertTrue(logo.isDisplayed());
        }
    }

    @Test
    @Description("Проверка работы ссылки 'Подробнее о сервисе'")
    public void testMoreAboutServiceLink() {

        WebElement moreAboutServiceLink = driver.findElement(By.linkText("Подробнее о сервисе"));
        assertNotNull(moreAboutServiceLink, "Ссылка 'Подробнее о сервисе' не должна быть null");
        moreAboutServiceLink.click();
        assertTrue(driver.getCurrentUrl().contains("help"));
        driver.navigate().back();
    }

    @Test
    @Description("Проверка работы кнопки 'Продолжить'")
    public void testContinueButton() {
        // Заполняем поле номера телефона
        WebElement communicationServicesInput = driver.findElement(By.id("connection-phone"));
        assertNotNull(communicationServicesInput, "Поле ввода номера телефона не должно быть null");
        communicationServicesInput.sendKeys("297777777");

        WebElement sumInput = driver.findElement(By.id("connection-sum"));
        assertNotNull(sumInput, "Поле ввода суммы не должно быть null");
        sumInput.sendKeys("978");

        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//form[@id='pay-connection']//button[@type='submit']")));
        assertNotNull(continueButton, "Кнопка 'Продолжить' не должна быть null");
        continueButton.click();

        WebElement cardForm = driver.findElement(By.xpath("//section/div/div/div"));
        assertNotNull(cardForm, "Форма ввода данных карты не должна быть null");
        assertTrue(cardForm.isDisplayed());
    }

    @AfterAll
    public static void shutDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
