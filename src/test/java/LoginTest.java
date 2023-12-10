import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LoginTest extends BaseTest {
    final String BASE_URL = "https://ok.ru/";
    final String CORRECT_LOGIN = "QAbot1";
    final String CORRECT_PASSWORD = "3ml3ZdbnK9";
    final String INCORRECT_LOGIN = "ExampleLogin";
    final String INCORRECT_PASSWORD = "ExamplePassword";
    final String UPPERCASE_LOGIN = "QABOT1";
    final String UPPERCASE_PASSWORD = "3ML3ZDBNK9";
    final String TOP_MENU = "Верхнее меню";
    final String ENTER_YOUR_USERNAME = "Enter your username";
    final String ENTER_PASSWORD = "Enter password";
    final String INCORRECT_LOGIN_OR_PASSWORD = "Incorrect username and/or password";


    @Test
    public void checkLoginSucces() {
        Configuration.holdBrowserOpen = true;
        LoginPage loginPage = new LoginPage();
        loginPage.openWebsite(BASE_URL);
        loginPage.inputLogin(CORRECT_LOGIN);
        loginPage.inputPassword(CORRECT_PASSWORD);
        loginPage.submitLoginAndPassword();
        ProfilePage profilePage = new ProfilePage();
        String href = profilePage.getHrefProfilePage();
        Assertions.assertEquals(href, TOP_MENU);
    }


    @Test
    public void checkNoPassword() {
        Configuration.holdBrowserOpen = true;
        LoginPage loginPage = new LoginPage();
        loginPage.openWebsite(BASE_URL);
        loginPage.inputLogin(CORRECT_LOGIN);
        loginPage.inputPassword("");
        loginPage.submitLoginAndPassword();
        String text_of_error = loginPage.emptyInputLoginAndPassword();
        Assertions.assertEquals(text_of_error, ENTER_PASSWORD);
    }


    @ParameterizedTest
    @ValueSource(strings = {"", INCORRECT_PASSWORD})
    void checkEmptyLogin(String word) {
        Configuration.holdBrowserOpen = true;
        LoginPage loginPage = new LoginPage();
        loginPage.openWebsite(BASE_URL);
        loginPage.inputLogin("");
        loginPage.inputPassword(word);
        loginPage.submitLoginAndPassword();
        String text_of_error = loginPage.emptyInputLoginAndPassword();
        Assertions.assertEquals(text_of_error, ENTER_YOUR_USERNAME);

    }

    @ParameterizedTest
    @ValueSource(strings = {INCORRECT_LOGIN, UPPERCASE_LOGIN})
    void checkIncorrectLogin(String word) {
        Configuration.holdBrowserOpen = true;
        LoginPage loginPage = new LoginPage();
        loginPage.openWebsite(BASE_URL);
        loginPage.inputLogin(word);
        loginPage.inputPassword(CORRECT_PASSWORD);
        loginPage.submitLoginAndPassword();
        String text_of_error = loginPage.emptyInputLoginAndPassword();
        Assertions.assertEquals(text_of_error, INCORRECT_LOGIN_OR_PASSWORD);

    }

    @ParameterizedTest
    @ValueSource(strings = {INCORRECT_PASSWORD, UPPERCASE_PASSWORD})
    void checkIncorrectPassword(String word) {
        Configuration.holdBrowserOpen = true;
        LoginPage loginPage = new LoginPage();
        loginPage.openWebsite(BASE_URL);
        loginPage.inputLogin(CORRECT_LOGIN);
        loginPage.inputPassword(word);
        loginPage.submitLoginAndPassword();
        String text_of_error = loginPage.emptyInputLoginAndPassword();
        Assertions.assertEquals(text_of_error, INCORRECT_LOGIN_OR_PASSWORD);

    }

    @Test
    public void checkSearchButtonInterests() {
        Configuration.holdBrowserOpen = true;
        LoginPage loginPage = new LoginPage();
        loginPage.openWebsite(BASE_URL);
        loginPage.clickOnSearchButtonInterests();
        InterestsPage interestsPage = new InterestsPage();
        interestsPage.visibleHeadTitle();
    }

    @Test
    public void checkSearchButtonPeople() {
        Configuration.holdBrowserOpen = true;
        LoginPage loginPage = new LoginPage();
        loginPage.openWebsite(BASE_URL);
        loginPage.clickOnSearchButtonPeople();
        PeoplePage peoplePage = new PeoplePage();
        peoplePage.visiblePeopleFoundCounter();
    }

}
