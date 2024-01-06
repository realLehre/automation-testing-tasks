import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class TestBase {
    public static WebDriver driver = null;

    @BeforeClass
    public void setUp() {
        String browser = "chrome";

        if (browser.equals("chrome")) {
            driver = new ChromeDriver();
            WebDriverManager.chromedriver().setup();
        } else if (browser.equals("firefox")) {
            driver = new FirefoxDriver();
            WebDriverManager.firefoxdriver().setup();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    public void getURL(String url){
        driver.get(url);
    }

    public void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
        }
    }

    @AfterClass
    public void tearDown() {
        System.out.println("Inside the after class annotation");
        if (null != driver) {
//            driver.quit();
        }
    }
}
