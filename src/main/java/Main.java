import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/home/trueuser/Desktop/NIR/Test_Project3/chromedriver-linux64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://ok.ru/");
    }
}
