import com.codeborne.selenide.Selenide;
import org.junit.After;
import org.junit.Before;
import com.codeborne.selenide.Configuration;


public class BaseTest {


    final String BASE_URL = "https://ok.ru/";


    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
        Selenide.open(BASE_URL);
    }


    @Before
    public void init() {
        setUp();
    }

    @After
    public void tearDown() {
        Selenide.closeWebDriver();
    }

}
