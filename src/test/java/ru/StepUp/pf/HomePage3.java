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

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class HomePage3 {
    // Элементы страницы
    private SelenideElement pageTitle = $("title");
    private SelenideElement logo = $("a.dp-1abiuov-root-root-root"); // класс логотипа
    private SelenideElement manageBookingLink = $("button.dp-1a3xxo5-root-SegmentedControlGroupItem-root:has(div:contains('Управление бронированием'))");
    private SelenideElement lastNameField = $("input.dp-zu3w2f-root-control[placeholder='Фамилия клиента']");
    private SelenideElement orderNumberField = $("input.dp-zu3w2f-root-control[placeholder='Номер бронирования или билета']");
    private SelenideElement searchButton = $("button.dp-1vcyfp3-root-root");
    private SelenideElement errorMessage = $("div.dp-1si76e4-root-root");

    public String getPageTitle() {
        return pageTitle.shouldBe(visible).getText();
    }

    public boolean isLogoDisplayed() {
        return logo.shouldBe(visible).isDisplayed();
    }

    public void clickManageBooking() {
        manageBookingLink.shouldBe(visible).click();
    }

    public void verifyBookingManagementPage() {
        orderNumberField.shouldBe(visible);
        lastNameField.shouldBe(visible);
        searchButton.shouldBe(visible);
    }

    public void searchForBooking(String orderNumber, String lastName) {
        orderNumberField.setValue(orderNumber);
        lastNameField.setValue(lastName);
        searchButton.click();
    }

    public void verifyErrorMessage() {
        errorMessage.shouldBe(visible).shouldHave(text("Заказ с указанными параметрами не найден"));
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
//    @FindBy(xpath = "//button[contains(@class,\"dp-1a3xxo5-root-SegmentedControlGroupItem-root\") and div[text()=\"Управление бронированием\"]]")
//    private WebElement manageBookingLink;
//
//    @FindBy(css = "input.dp-zu3w2f-root-control[placeholder=\"Фамилия клиента\"]")
//    private WebElement lastNameField;
//
//    @FindBy(css = "input.dp-zu3w2f-root-control[placeholder=\"Номер бронирования или билета\"]")
//    private WebElement orderNumberField;
//
//    @FindBy(css = "button.dp-1vcyfp3-root-root")
//    private WebElement searchButton;
//
//    @FindBy(css = "div.dp-1si76e4-root-root")
//    private WebElement errorMessage;
//
//    public HomePage3(WebDriver driver) {
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
//    public void clickManageBooking() {
//        manageBookingLink.click();
//    }
//
//    public void verifyBookingManagementPage() {
//        wait.until(ExpectedConditions.visibilityOf(orderNumberField));
//        wait.until(ExpectedConditions.visibilityOf(lastNameField));
//        wait.until(ExpectedConditions.visibilityOf(searchButton));
//    }
//
//    public void searchForBooking(String orderNumber, String lastName) {
//        orderNumberField.sendKeys(orderNumber);
//        lastNameField.sendKeys(lastName);
//        searchButton.click();
//    }
//
//    public void verifyErrorMessage() {
//        wait.until(ExpectedConditions.visibilityOf(errorMessage));
//        assert errorMessage.getText().equals("Заказ с указанными параметрами не найден");
//    }
}







