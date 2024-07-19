import io.qameta.allure.*;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

@Epic("Тесты онлайн платежей")
@Feature("Страница платежей")
public class MtsByTest {

    @Test
    @Story("Проверка раздела онлайн платежей")
    @Description("Тест для проверки раздела 'Онлайн пополнение без комиссии'")
    @Severity(SeverityLevel.CRITICAL)
    public void onlinePaymentSectionTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        Allure.step("Перейти на сайт mts.by");
        driver.get("https://mts.by");

        Assert.assertEquals(driver.getTitle(), "МТС – мобильный оператор в Беларуси");

        WebElement paySectionTitle = driver.findElement(By.xpath("//div[@class='pay__wrapper']/h2"));
        Assert.assertEquals(paySectionTitle.getText(), "Онлайн пополнение\nбез комиссии");

        // Проверка логотипов партнеров
        WebElement visaElement = driver.findElement(By.xpath("//div[@class='pay__partners']/ul/li/img[1]"));
        Assert.assertEquals(visaElement.getAttribute("alt"), "Visa");

        WebElement verifiedByVisaElement = driver.findElement(By.xpath("//div[@class='pay__partners']/ul/li[2]/img"));
        Assert.assertEquals(verifiedByVisaElement.getAttribute("alt"), "Verified By Visa");

        WebElement masterCardElement = driver.findElement(By.xpath("//div[@class='pay__partners']/ul/li[3]/img"));
        Assert.assertEquals(masterCardElement.getAttribute("alt"), "MasterCard");

        WebElement masterCardSecureCodeElement = driver
                .findElement(By.xpath("//div[@class='pay__partners']/ul/li[4]/img"));
        Assert.assertEquals(masterCardSecureCodeElement.getAttribute("alt"), "MasterCard Secure Code");

        WebElement belCardElement = driver.findElement(By.xpath("//div[@class='pay__partners']/ul/li[5]/img"));
        Assert.assertEquals(belCardElement.getAttribute("alt"), "Белкарт");

        // Проверка ссылки "Подробнее о сервисе"
        driver.findElement(By.cssSelector("#cookie-agree")).click();

        WebElement link = driver.findElement(By.xpath(
                "//div[@class='pay__wrapper']/a[@href='/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/']"));
        Assert.assertEquals(link.getText(), "Подробнее о сервисе");

        link.click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.urlContains("poryadok-oplaty-i-bezopasnost-internet-platezhey"));

        driver.navigate().back();

        WebElement phoneInput = driver.findElement(By.cssSelector("#connection-phone"));
        phoneInput.click();
        phoneInput.sendKeys("297777777");

        WebElement sumInput = driver.findElement(By.cssSelector("#connection-sum"));
        sumInput.click();
        sumInput.sendKeys("100");

        WebElement paymentform = driver.findElement(By.cssSelector("#pay-connection"));
        paymentform.submit();

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("bepaid-app")));

        driver.quit();
    }

    @Test
    @Story("Проверка вариантов оплаты")
    @Description("Тест для проверки различных вариантов оплаты и их текстов-заполнителей")
    @Severity(SeverityLevel.NORMAL)
    public void onlinePaymentSectionVariantsTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://mts.by");

        driver.findElement(By.cssSelector("#cookie-agree")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Проверка текстов-заполнителей для "Услуги связи"
        WebElement phone = driver.findElement(By.xpath("//form[@id='pay-connection']/*/input[@class='phone']"));
        WebElement sum = driver.findElement(By.xpath("//form[@id='pay-connection']/*/input[@class='total_rub']"));
        WebElement email = driver.findElement(By.xpath("//form[@id='pay-connection']/*/input[@class='email']"));
        Assert.assertEquals(phone.getAttribute("placeholder"), "Номер телефона");
        Assert.assertEquals(sum.getAttribute("placeholder"), "Сумма");
        Assert.assertEquals(email.getAttribute("placeholder"), "E-mail для отправки чека");

        // Проверка текстов-заполнителей для "Домашний интернет"
        WebElement phoneInputInternet = driver
                .findElement(By.xpath("//form[@id='pay-internet']/*/input[@class='phone']"));
        WebElement sumInputInternet = driver
                .findElement(By.xpath("//form[@id='pay-internet']/*/input[@class='total_rub']"));
        WebElement emailInputInternet = driver
                .findElement(By.xpath("//form[@id='pay-internet']/*/input[@class='email']"));
        Assert.assertEquals(phoneInputInternet.getAttribute("placeholder"), "Номер абонента");
        Assert.assertEquals(sumInputInternet.getAttribute("placeholder"), "Сумма");
        Assert.assertEquals(emailInputInternet.getAttribute("placeholder"), "E-mail для отправки чека");

        // Проверка текстов-заполнителей для "Рассрочка"
        WebElement scoreInput = driver
                .findElement(By.xpath("//form[@id='pay-instalment']/*/input[@id='score-instalment']"));
        WebElement sumInputInstallment = driver
                .findElement(By.xpath("//form[@id='pay-instalment']/*/input[@class='total_rub']"));
        WebElement emailInputInstallment = driver
                .findElement(By.xpath("//form[@id='pay-instalment']/*/input[@class='email']"));
        Assert.assertEquals(scoreInput.getAttribute("placeholder"), "Номер счета на 44");
        Assert.assertEquals(sumInputInstallment.getAttribute("placeholder"), "Сумма");
        Assert.assertEquals(emailInputInstallment.getAttribute("placeholder"), "E-mail для отправки чека");

        // Проверка текстов-заполнителей для "Задолженность"
        WebElement scoreInputArrears = driver
                .findElement(By.xpath("//form[@id='pay-arrears']/*/input[@id='score-arrears']"));
        WebElement sumInputArrears = driver
                .findElement(By.xpath("//form[@id='pay-arrears']/*/input[@class='total_rub']"));
        WebElement emailInputArrears = driver
                .findElement(By.xpath("//form[@id='pay-arrears']/*/input[@class='email']"));
        Assert.assertEquals(scoreInputArrears.getAttribute("placeholder"), "Номер счета на 2073");
        Assert.assertEquals(sumInputArrears.getAttribute("placeholder"), "Сумма");
        Assert.assertEquals(emailInputArrears.getAttribute("placeholder"), "E-mail для отправки чека");

        // Тест "Услуги связи"
        WebElement phoneInput = driver.findElement(By.cssSelector("#connection-phone"));
        phoneInput.click();
        phoneInput.sendKeys("297777777");

        WebElement sumInput = driver.findElement(By.cssSelector("#connection-sum"));
        sumInput.click();
        sumInput.sendKeys("100");

        WebElement paymentform = driver.findElement(By.cssSelector("#pay-connection"));
        paymentform.submit();

        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("bepaid-app")));

        // Проверка наличия iframe
        try {
            WebElement iframeElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[contains(@name, 'bepaid')]")));
            System.out.println("iframe найден");

            driver.switchTo().frame(iframeElement);

            WebElement amount = driver.findElement(By.cssSelector("#beGatewayAmount"));
            WebElement phoneNum = driver.findElement(By.cssSelector("#beGatewayPhone"));
            WebElement emailGateway = driver.findElement(By.cssSelector("#beGatewayEmail"));
            WebElement cardNum = driver.findElement(By.cssSelector("#beGatewayCardNumber"));

            Assert.assertEquals(amount.getAttribute("value"), "100");
            Assert.assertEquals(phoneNum.getAttribute("value"), "+375297777777");
            Assert.assertEquals(emailGateway.getAttribute("placeholder"), "E-mail для отправки чека");
            Assert.assertEquals(cardNum.getAttribute("placeholder"), "Номер карты");
        } catch (Exception e) {
            System.out.println("iframe не найден: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
