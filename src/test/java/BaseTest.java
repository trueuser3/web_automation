import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


public class BaseTest {


    final String BASE_URL = "https://ok.ru/";


    public void setUp() {
        Selenide.open(BASE_URL);
    }


    @BeforeEach
    public void init() {
        setUp();
    }

    @AfterEach
    public void cleanUpEach() {
        Selenide.closeWebDriver();
    }

}
