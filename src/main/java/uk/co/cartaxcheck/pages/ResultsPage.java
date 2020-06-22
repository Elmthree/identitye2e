package uk.co.cartaxcheck.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import uk.co.cartaxcheck.model.Car;

public class ResultsPage extends  BasePage {

    @FindBy(xpath = ".//dt[contains(text(),'Registration')]/following-sibling::dd")
    private WebElement registrationValueField;

    @FindBy(xpath = "//dt[contains(text(),'Make')]/following-sibling::dd")
    private WebElement makeValueField;

    @FindBy(xpath = "//dt[contains(text(),'Model')]/following-sibling::dd")
    private WebElement modelValueField;

    @FindBy(xpath = "//dt[contains(text(),'Colour')]/following-sibling::dd")
    private WebElement colourValueField;

    @FindBy(xpath = "//dt[contains(text(),'Year')]/following-sibling::dd")
    private WebElement yearValueField;

    public ResultsPage(WebDriver driver) {
        super(driver);
    }

    public Car getDetails() {
        String registrationNo = this.registrationValueField.getText();
        String make = this.makeValueField.getText();
        String model = this.modelValueField.getText();
        String colour = this.colourValueField.getText();
        String year = this.yearValueField.getText();
        return new Car(registrationNo, make, model, colour, year);
    }

}
