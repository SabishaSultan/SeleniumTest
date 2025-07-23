package ru.StepUp.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    By pageTitle = By.name("pobeda");
    By logo = By.name("logo");
    By infoMenu = By.name("info");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    //текст заголовка страницы pageTitle значением strPageTitle
    public void setPageTitle(String strPageTitle){
        driver.findElement(pageTitle).getText();
    }

    //
    public void setLogo(String strLogo){
        driver.findElement(logo).getText();
    }

    //
    public void setInfoMenu(String strInfoMenu){
        driver.findElement(infoMenu).getText();
    }


}
