package ru.StepUp.pf;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PobedaTests {
    private WebDriver driver;
    private HomePage homePage;
    private HomePage2 homePage2;

    @BeforeEach
    public void setUp() {
        // Установка драйвера Chrome
        System.setProperty("webdriver.chrome.driver", "/Chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.flypobeda.ru/");
        homePage = new HomePage(driver);
        homePage2 = new HomePage2(driver);
    }

    @Test
    public void testHomePage() {
        // Проверка заголовка страницы
        Assertions.assertEquals(driver.getTitle(),"Авиакомпания «Победа» - купить авиабилеты онлайн, дешёвые билеты на самолёт, прямые и трансферные рейсы с пересадками");

        // Проверка наличия логотипа
        assertTrue(homePage.isLogoDisplayed());
    }

    @Test
    public void testInfoMenuHover() {
        homePage.hoverOverInfoMenu();

        // Получение заголовков всплывающего окна
        List<String> titles = homePage.getInfoTitles();
        // Проверка наличия необходимых заголовков
        assertTrue(titles.contains("Подготовка к полету"));
        assertTrue(titles.contains("Полезная информация"));
        assertTrue(titles.contains("О компании"));
    }

    @Test
    public void testSearchFunctionality(){

        // Вводим критерии поиска
        homePage2.enterFrom("Москва");
        homePage2.enterTo("Санкт-Петербург");

        // Скроллим к блоку поиска и проверяем его наличие
        homePage2.scrollToSearchBlock();

        // Нажимаем кнопку поиска
        homePage2.clickSearchButton();

        // Проверяем, что поле "Туда" обведено красной рамкой
        assertTrue(homePage2.isDepartureFieldHighlighted());
    }

    @AfterEach
    public void tearDown() {
            driver.quit();
    }
}