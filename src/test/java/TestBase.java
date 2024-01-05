import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;

public class TestBase {
    public static WebDriver driver = null;

    @BeforeClass
    public void setUp() {
        String browser = "chrome";

        if (browser.equals("chrome")) {
            driver = new ChromeDriver();
            WebDriverManager.chromedriver().setup();
        } else if(browser.equals("firefox")){
            driver = new FirefoxDriver();
            WebDriverManager.firefoxdriver().setup();
        }
    }

    public void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
        }
    }
}
