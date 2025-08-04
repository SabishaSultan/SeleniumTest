package ru.StepUp.pf;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class HomePage2 {

    private SelenideElement pageTitle = $("title");
    private SelenideElement logo = $("a.dp-1abiuov-root-root-root"); // класс логотипа
    private SelenideElement fromField = $("input.dp-zu3w2f-root-control[placeholder='Откуда']");
    private SelenideElement toField = $("input.dp-zu3w2f-root-control[placeholder='Куда']");
    private SelenideElement departureDateField = $("input.dp-zu3w2f-root-control[placeholder='Туда']");
    private SelenideElement returnDateField = $("input.dp-zu3w2f-root-control[placeholder='Обратно']");
    private SelenideElement searchButton = $("button.dp-1ikqo3w-root-root");

    public String getPageTitle() {
        pageTitle.shouldBe(visible);
        return pageTitle.getText();
    }

    public boolean isLogoDisplayed() {
        logo.shouldBe(visible);
        return logo.isDisplayed();
    }

    public void scrollToSearchBlock() {
        executeJavaScript("arguments[0].scrollIntoView(true);", searchButton);
        searchButton.shouldBe(visible); // Ждем, пока кнопка поиска станет видимой
    }

    public void enterFrom(String from) {
        fromField.setValue(from).pressEnter();
    }

    public void enterTo(String to) {
        toField.setValue(to).pressEnter();
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public boolean isDepartureFieldHighlighted() {
        return departureDateField.getCssValue("border").contains("red");
    }
//    private WebDriver driver;
//    private WebDriverWait wait;
//
//    @FindBy(tagName = "Авиакомпания «Победа» - купить авиабилеты онлайн, дешёвые билеты на самолёт, прямые и трансферные рейсы с пересадками")
//    private WebElement pageTitle;
//
//    @FindBy(css = "a.dp-1abiuov-root-root-root") //класс логотипа
//    private WebElement logo;
//
//    @FindBy(css = "input.dp-zu3w2f-root-control[placeholder=\"Откуда\"]")
//    private WebElement fromField;
//
//    @FindBy(css = "input.dp-zu3w2f-root-control[placeholder=\"Куда\"]")
//    private WebElement toField;
//
//    @FindBy(css = "input.dp-zu3w2f-root-control[placeholder=\"Туда\"]")
//    private WebElement departureDateField;
//
//    @FindBy(css = "input.dp-zu3w2f-root-control[placeholder=\"Обратно\"]")
//    private WebElement returnDateField;
//
//    @FindBy(css = "button.dp-1ikqo3w-root-root")
//    private WebElement searchButton;
//
//    public HomePage2(WebDriver driver) {
//        this.driver = driver;
//        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        PageFactory.initElements(driver, this);
//    }
//
//    public String getPageTitle() {
//        return pageTitle.getText();
//    }
//
//    public boolean isLogoDisplayed() {
//        wait.until(ExpectedConditions.visibilityOf(logo));
//        return logo.isDisplayed();
//    }
//
//    public void scrollToSearchBlock() {
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchButton);
//        wait.until(ExpectedConditions.visibilityOf(searchButton)); // Ждем, пока кнопка поиска станет видимой
//    }
//
//    public void enterFrom(String from) {
//        fromField.sendKeys(from);
//        fromField.sendKeys(Keys.ENTER);
//    }
//
//    public void enterTo(String to) {
//        toField.sendKeys(to);
//        toField.sendKeys(Keys.ENTER);
//    }
//
//    public void clickSearchButton() {
//        searchButton.click();
//    }
//
//    public boolean isDepartureFieldHighlighted() {
//        return departureDateField.getCssValue("border").contains("red");
//    }

}