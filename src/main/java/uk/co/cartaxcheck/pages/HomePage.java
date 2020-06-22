package uk.co.cartaxcheck.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends  BasePage {

    @FindBy(id = "vrm-input")
    private WebElement enterRegistrationField;

    @FindBy(css = "form[action='/free-car-check/'] button")
    private WebElement freeCarCheckButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void performFreeCheck(String vehicleRegistration) {
        this.enterRegistrationField.sendKeys(vehicleRegistration);
        this.freeCarCheckButton.click();
    }

    public void open() {
        this.driver.get("https://cartaxcheck.co.uk/");
    }
}
