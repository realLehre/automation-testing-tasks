import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestBrowser extends TestBase {
    @Test
    public void main() {
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/");

        WebElement element = driver.findElement(By.xpath("//a[@href='/login']"));
        wait(2);
        scrollToElement(driver, element);
        element.click();

        wait(1);
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        usernameField.sendKeys("tomsmith");
        wait(1);
        passwordField.sendKeys("SuperSecretPassword!");

        WebElement submitBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        submitBtn.click();

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://the-internet.herokuapp.com/secure";
        Assert.assertEquals(actualUrl, expectedUrl);

        wait(3);
        driver.quit();
    }

    private static void scrollToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        // Scroll to the element
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
