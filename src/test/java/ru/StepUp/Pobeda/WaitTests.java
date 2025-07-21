package ru.StepUp.Pobeda;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitTests {
    private WebDriver driver;
    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.google.com/");
    }
    @Test
    public void openPobedaPage() {
        driver.findElement(By.cssSelector("[aria-label=\"Найти\"]")).click();
        driver.findElement(By.cssSelector("[aria-label=\"Найти\"]")).sendKeys("Сайт компании Победа");
        driver.findElement(By.cssSelector("[aria-label=\"Найти\"]")).sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".h3"))));
        driver.findElement(By.cssSelector("h3")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("img.dp-1fm1i7d-root"))));
        Assertions.assertEquals(driver.getClass(), "img.dp-1fm1i7d-root");

        driver.findElement(By.cssSelector("button.dp-etauof-root-root")).click(); //кликнуть по кнопке выбора языка
        driver.findElement(By.cssSelector("div.dp-mmdut6-root-root-root")).click(); //выбрать английский
        driver.findElement(By.xpath("//div[contains(text(), 'Ticket search')]")).isDisplayed();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div"), "[contains(text(),'Ticket search')]"));
        driver.findElement(By.xpath("//div[contains(text(), 'Ticket search')]")).isDisplayed();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div"), "[contains(text(),'Online check-in')]"));
        driver.findElement(By.xpath("//div[contains(text(), 'Online check-in')]")).isDisplayed();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div"), "[contains(text(),'Manage my booking')]"));
        driver.findElement(By.xpath("//div[contains(text(), 'Manage my booking')]")).isDisplayed();
    }
    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
