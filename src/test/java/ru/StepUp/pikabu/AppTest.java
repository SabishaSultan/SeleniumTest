package ru.StepUp.pikabu;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class AppTest {
    WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void PikabuLoginTest() {
        driver.get("https://pikabu.ru/");

        Assertions.assertEquals(driver.getCurrentUrl(), "https://pikabu.ru/");
        Assertions.assertEquals(driver.getTitle(), "Горячее – самые интересные и обсуждаемые посты | Пикабу");


        WebElement button = driver.findElement(By.cssSelector("button.pkb-normal-btn.header-right-menu__login-button"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);

        driver.findElement(By.cssSelector("[class= \"popup__wrapper\"]")).isDisplayed(); //окно авторизации
        driver.findElement(By.cssSelector("div.popup__wrapper input.input__input[name='username']")).isDisplayed(); // наличие поля логин
        driver.findElement(By.cssSelector("div.popup__wrapper input.input__input[name='password']")).isDisplayed(); //наличие поля пароль
        driver.findElement(By.cssSelector("div.popup__wrapper .auth__field_firstbtn .button_success")).isDisplayed(); //наличие кнопки войти

        driver.findElement(By.cssSelector("div.popup__wrapper input.input__input[name='username']")).sendKeys("Qwerty"); //ввести логин
        driver.findElement(By.cssSelector("div.popup__wrapper input.input__input[name='password']")).sendKeys("Qwerty"); //ввести пароль
        driver.findElement(By.cssSelector("div.popup__wrapper .auth__field_firstbtn .button_success")).sendKeys(Keys.ENTER); //нажать ентер

        driver.switchTo().defaultContent();

            WebElement errorMessage = driver.findElement(By.cssSelector("span.auth__error.auth__error_top"));
            assertTrue(errorMessage.isDisplayed());
            assertEquals("Ошибка. Вы ввели неверные данные авторизации", errorMessage.getText());

        }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}

