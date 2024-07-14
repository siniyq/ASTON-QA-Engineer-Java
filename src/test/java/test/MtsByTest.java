package test;

import java.util.List;
import java.time.Duration; // Импортируем Duration
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MtsByTest {

    @Test
    public void onlinePaymentSectionTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://mts.by");
        Assert.assertEquals(driver.getTitle(), "МТС – мобильный оператор в Беларуси");

        WebElement paySectionTitle = driver.findElement(By.xpath("//div[@class='pay__wrapper']/h2"));
        Assert.assertEquals(paySectionTitle.getText(), "Онлайн пополнение\nбез комиссии");

        WebElement visaElement = driver.findElement(By.xpath("//div[@class='pay__partners']/ul/li/img[1]"));
        Assert.assertEquals(visaElement.getAttribute("alt"), "Visa");

        WebElement verifiedByVisaElement = driver.findElement(By.xpath("//div[@class='pay__partners']/ul/li[2]/img"));
        Assert.assertEquals(verifiedByVisaElement.getAttribute("alt"), "Verified By Visa");

        WebElement masterCardElement = driver.findElement(By.xpath("//div[@class='pay__partners']/ul/li[3]/img"));
        Assert.assertEquals(masterCardElement.getAttribute("alt"), "MasterCard");

        WebElement masterCardSecureCodeElement = driver.findElement(By.xpath("//div[@class='pay__partners']/ul/li[4]/img"));
        Assert.assertEquals(masterCardSecureCodeElement.getAttribute("alt"), "MasterCard Secure Code");

        WebElement belCardElement = driver.findElement(By.xpath("//div[@class='pay__partners']/ul/li[5]/img"));
        Assert.assertEquals(belCardElement.getAttribute("alt"), "Белкарт");

        driver.findElement(By.cssSelector("#cookie-agree")).click();

        WebElement link = driver.findElement(By.xpath("//div[@class='pay__wrapper']/a[@href='/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/']"));
        Assert.assertEquals(link.getText(), "Подробнее о сервисе");

        link.click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.urlContains("poryadok-oplaty-i-bezopasnost-internet-platezhey"));

        driver.navigate().back();

        WebElement phoneInput = driver.findElement(By.cssSelector("#connection-phone"));
        phoneInput.click();
        phoneInput.sendKeys("297777777");

        WebElement sumInput = driver.findElement(By.cssSelector("#connection-sum"));
        sumInput.click();
        sumInput.sendKeys("99");

        WebElement paymentform = driver.findElement(By.cssSelector("#pay-connection"));
        paymentform.submit();

        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(By.className("bepaid-app")));

        driver.quit();
    }

    @Test
    public void onlinePaymentSectionVariantsTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://mts.by");
        driver.findElement(By.cssSelector("#cookie-agree")).click();

        WebElement phone = driver.findElement(By.xpath("//form[@id='pay-connection']/*/input[@class='phone']"));
        WebElement sum = driver.findElement(By.xpath("//form[@id='pay-connection']/*/input[@class='total_rub']"));
        WebElement email = driver.findElement(By.xpath("//form[@id='pay-connection']/*/input[@class='email']"));

        Assert.assertEquals(phone.getAttribute("placeholder"), "Номер телефона");
        Assert.assertEquals(sum.getAttribute("placeholder"), "Сумма");
        Assert.assertEquals(email.getAttribute("placeholder"), "E-mail для отправки чека");

        WebElement phone_input_internet = driver.findElement(By.xpath("//form[@id='pay-internet']/*/input[@class='phone']"));
        WebElement sum_input_internet = driver.findElement(By.xpath("//form[@id='pay-internet']/*/input[@class='total_rub']"));
        WebElement email_input_internet = driver.findElement(By.xpath("//form[@id='pay-internet']/*/input[@class='email']"));

        Assert.assertEquals(phone_input_internet.getAttribute("placeholder"), "Номер абонента");
        Assert.assertEquals(sum_input_internet.getAttribute("placeholder"), "Сумма");
        Assert.assertEquals(email_input_internet.getAttribute("placeholder"), "E-mail для отправки чека");

        WebElement score_input = driver.findElement(By.xpath("//form[@id='pay-instalment']/*/input[@id='score-instalment']"));
        WebElement sum_input_installment = driver.findElement(By.xpath("//form[@id='pay-instalment']/*/input[@class='total_rub']"));
        WebElement email_input_installment = driver.findElement(By.xpath("//form[@id='pay-instalment']/*/input[@class='email']"));

        Assert.assertEquals(score_input.getAttribute("placeholder"), "Номер счета на 44");
        Assert.assertEquals(sum_input_installment.getAttribute("placeholder"), "Сумма");
        Assert.assertEquals(email_input_installment.getAttribute("placeholder"), "E-mail для отправки чека");

        WebElement score_input_arrears = driver.findElement(By.xpath("//form[@id='pay-arrears']/*/input[@id='score-arrears']"));
        WebElement sum_input_arrears = driver.findElement(By.xpath("//form[@id='pay-arrears']/*/input[@class='total_rub']"));
        WebElement email_input_arrears = driver.findElement(By.xpath("//form[@id='pay-arrears']/*/input[@class='email']"));

        Assert.assertEquals(score_input_arrears.getAttribute("placeholder"), "Номер счета на 2073");
        Assert.assertEquals(sum_input_arrears.getAttribute("placeholder"), "Сумма");
        Assert.assertEquals(email_input_arrears.getAttribute("placeholder"), "E-mail для отправки чека");

        WebElement phoneInput = driver.findElement(By.cssSelector("#connection-phone"));
        phoneInput.click();
        phoneInput.sendKeys("297777777");

        WebElement sumInput = driver.findElement(By.cssSelector("#connection-sum"));
        sumInput.click();
        sumInput.sendKeys("99");

        WebElement paymentform = driver.findElement(By.cssSelector("#pay-connection"));
        paymentform.submit();

        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(By.className("bepaid-iframe")));

        WebElement iframeElement = driver.findElement(By.className("bepaid-iframe"));
        driver.switchTo().frame(iframeElement);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement costSection = driver.findElement(By.xpath("//div[@class='pay-description__cost']"));
        WebElement payBtn = driver.findElement(By.xpath("//div[@class='app-wrapper__content']/div/*/*/*/app-card-page/div/div/button"));

        Assert.assertEquals(costSection.getText(), "99.00 BYN");
        Assert.assertEquals(payBtn.getText(), "Оплатить 99.00 BYN");

        WebElement numberSection = driver.findElement(By.xpath("//div[@class='app-wrapper__content']/*/*/*/div[@class='payment-page__container']/*/div[@class='pay-description__text']"));
        Assert.assertEquals(numberSection.getText(), "Оплата: Услуги связи Номер:375297777777");

        WebElement cardNumber = driver.findElement(By.xpath("//input[@id='cc-number']/following::label[1]"));
        Assert.assertEquals(cardNumber.getText(), "Номер карты");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> cardSystemImages = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.xpath("//div[@class='cards-brands cards-brands__container']/img")));
        Assert.assertEquals(cardSystemImages.size(), 3);


        List<WebElement> mirSystemImages = driver.findElements(By.xpath("//div[@class='cards-brands cards-brands_random']/img"));
        Assert.assertEquals(mirSystemImages.size(), 2);

        WebElement cardExpires = driver.findElement(By.xpath("//div[@class='expires-input']/*/*/*/*/label"));
        Assert.assertEquals(cardExpires.getText(), "Срок действия");

        WebElement cvc = driver.findElement(By.xpath("//div[@class='cvc-input']/*/*/*/*/label"));
        Assert.assertEquals(cvc.getText(), "CVC");

        WebElement cardName = driver.findElement(By.xpath("//div[@class='row'][3]/*/*/*/*/label"));
        Assert.assertEquals(cardName.getText(), "Имя держателя (как на карте)");

        driver.switchTo().defaultContent();
        driver.quit();
    }
}
