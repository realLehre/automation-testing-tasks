import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestBrowser extends TestBase {

    WebElement usernameField;
    WebElement passwordField;
    WebElement submitBtn;
    WebElement alertMsg;

    @Test(priority = 1, description = "Validate that user cannot login using wrong credentials")
    public void validateUserCannotLoginUsingWrongCredentials() {
        getURL("https://the-internet.herokuapp.com/");

        WebElement element = driver.findElement(By.xpath("//a[@href='/login']"));
        wait(2);
        scrollToElement(driver, element);
        element.click();

        wait(1);
        usernameField = driver.findElement(By.id("username"));
        passwordField = driver.findElement(By.id("password"));
        usernameField.sendKeys("tomsmith");
        wait(1);
        passwordField.sendKeys("SuperSecretPassword");

        submitBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        submitBtn.click();


        assertTest("Your password is invalid!");


        wait(3);
    }

    @Test(priority = 2, description = "Validate that user can login with correct credentials")
    public void validateUserCanLoginWithCorrectCredentials() {
        usernameField = driver.findElement(By.id("username"));
        passwordField = driver.findElement(By.id("password"));
        usernameField.sendKeys("tomsmith");
        wait(1);
        passwordField.sendKeys("SuperSecretPassword!");

        submitBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        submitBtn.click();
        assertTest("You logged into a secure area!");
        wait(3);
    }

    public void assertTest(String textToConfirm) {
        alertMsg = driver.findElement(By.id("flash"));
        alertMsg.getText();
        Assert.assertTrue(alertMsg.getText().contains(textToConfirm));
    }

    private static void scrollToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        // Scroll to the element
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
