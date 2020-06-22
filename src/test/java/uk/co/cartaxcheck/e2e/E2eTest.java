package uk.co.cartaxcheck.e2e;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import uk.co.cartaxcheck.pages.HomePage;
import uk.co.cartaxcheck.pages.ResultsPage;
import uk.co.cartaxcheck.utils.Util;
import uk.co.cartaxcheck.model.Car;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;


public class E2eTest {

    WebDriver driver;

    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    @DisplayName("Search For Pattern From Input Perform Search Assert Output")
    public void searchForPatternFromInputPerformSearchAssertOutput() throws IOException {
        var carInputText = Util.readFileContent("src/test/resources/car_input.txt");
        List<String> registrationNumbers = Util.getRegistrationNumbers(carInputText);
        assertThat(registrationNumbers.size()).isGreaterThan(0);

        var outputText = Util.readFileContent("src/test/resources/car_output.txt");
        SoftAssertions softAssertions = new SoftAssertions();
        for (String registrationNumber : registrationNumbers) {
            System.out.println(String.format("Registration number is %s", registrationNumber));
            HomePage homePage = new HomePage(driver);
            homePage.open();
            homePage.performFreeCheck(registrationNumber);
            ResultsPage resultsPage = new ResultsPage(driver);
            Car details = resultsPage.getDetails();
            softAssertions.assertThat(outputText)
                    .overridingErrorMessage("Expecting:\n<%s>\n to contain \"%s\"\nRegistration number was %s", outputText, details.toString(), registrationNumber)
                    .contains(details.toString());
        }
        softAssertions.assertAll();
    }

}