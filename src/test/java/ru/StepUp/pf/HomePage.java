package ru.StepUp.pf;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


public class HomePage {
    private SelenideElement pageTitle = $("title"); // заголовок страницы
    private SelenideElement logo = $("a.dp-1abiuov-root-root-root"); // класс логотипа
    private SelenideElement infoMenu = $("a:contains('Информация')"); // меню информации
    private SelenideElement infoTitles = $("div.dp-1hdvter-root"); // заголовки всплывающего окна

    public String getPageTitle() {
        pageTitle.shouldBe(attribute("title"), Duration.ofSeconds(10));
        return pageTitle.getText();
    }

    public boolean isLogoDisplayed() {
        return logo.shouldBe(visible).isDisplayed();
    }

    public void hoverOverInfoMenu() {
        infoMenu.hover();// Наводим курсор на меню
    }

    public String getInfoTitles() {
        infoTitles.shouldBe(visible);
        StringBuilder titles = new StringBuilder();
        titles.append(infoTitles.$("a.dp-17i9q9s-root-root[href=\"/information#flight\"]").shouldBe(visible).getText()).append("\n");
        titles.append(infoTitles.$("a.dp-17i9q9s-root-root[href=\"/information#useful\"]").shouldBe(visible).getText()).append("\n");
        titles.append(infoTitles.$("a.dp-17i9q9s-root-root[href=\"/information#company\"]").shouldBe(visible).getText()).append("\n");

         return titles.toString();
    }
}

//public class HomePage {
//    private WebDriver driver;
//    private WebDriverWait wait;
//
//    @FindBy(tagName = "Авиакомпания «Победа» - купить авиабилеты онлайн, дешёвые билеты на самолёт, прямые и трансферные рейсы с пересадками")
//    private WebElement pageTitle;
//
//    @FindBy(css = "a.dp-1abiuov-root-root-root") //класс логотипа
//    private WebElement logo;
//
//    @FindBy(linkText = "Информация")
//    private WebElement infoMenu;
//
//    @FindBy(css = "div.dp-1hdvter-root") // заголовки всплывающего окна
//    private List<WebElement> infoTitles;
//
//    public HomePage(WebDriver driver) {
//        this.driver = driver;
//        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        PageFactory.initElements(driver, this);
//    }
//
//    public String getPageTitle() {
//        wait.until(ExpectedConditions.visibilityOf(pageTitle));
//        return pageTitle.getText();
//    }
//
//    public boolean isLogoDisplayed() {
//        return logo.isDisplayed();
//    }
//
//    public void hoverOverInfoMenu() {
//        wait.until(ExpectedConditions.visibilityOf(infoMenu));
//        Actions actions = new Actions(driver);
//        actions.moveToElement(infoMenu).perform();
//    }
//
//    public List<String> getInfoTitles() {
//        wait.until(ExpectedConditions.visibilityOfAllElements(infoTitles));
//        return infoTitles.stream().map(WebElement::getText).collect(Collectors.toList());
//    }
//}
