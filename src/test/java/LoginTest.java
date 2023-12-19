import Pages.LoginPage;
import Pages.ProfilePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class LoginTest extends BaseTest {
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
        LoginPage loginPage = new LoginPage();
        loginPage.inputLogin(CORRECT_LOGIN);
        loginPage.inputPassword(CORRECT_PASSWORD);
        loginPage.submitLoginAndPassword();
        ProfilePage profilePage = new ProfilePage();
        String href = profilePage.getHrefProfilePage();
        Assertions.assertEquals(href, TOP_MENU);
    }


    @Test
    public void checkNoPassword() {
        LoginPage loginPage = new LoginPage();
        loginPage.inputLogin(CORRECT_LOGIN);
        loginPage.inputPassword("");
        loginPage.submitLoginAndPassword();
        String text_of_error = loginPage.emptyInputLoginAndPassword();
        Assertions.assertEquals(text_of_error, ENTER_PASSWORD);
    }


    @ParameterizedTest
    @ValueSource(strings = {"", INCORRECT_PASSWORD})
    void checkEmptyLogin(String word) {
        LoginPage loginPage = new LoginPage();
        loginPage.inputLogin("");
        loginPage.inputPassword(word);
        loginPage.submitLoginAndPassword();
        String text_of_error = loginPage.emptyInputLoginAndPassword();
        Assertions.assertEquals(text_of_error, ENTER_YOUR_USERNAME);

    }

    @ParameterizedTest
    @ValueSource(strings = {INCORRECT_LOGIN, UPPERCASE_LOGIN})
    void checkIncorrectLogin(String word) {
        LoginPage loginPage = new LoginPage();
        loginPage.inputLogin(word);
        loginPage.inputPassword(CORRECT_PASSWORD);
        loginPage.submitLoginAndPassword();
        String text_of_error = loginPage.emptyInputLoginAndPassword();
        Assertions.assertEquals(text_of_error, INCORRECT_LOGIN_OR_PASSWORD);

    }

    @ParameterizedTest
    @ValueSource(strings = {INCORRECT_PASSWORD, UPPERCASE_PASSWORD})
    void checkIncorrectPassword(String word) {
        LoginPage loginPage = new LoginPage();
        loginPage.inputLogin(CORRECT_LOGIN);
        loginPage.inputPassword(word);
        loginPage.submitLoginAndPassword();
        String text_of_error = loginPage.emptyInputLoginAndPassword();
        Assertions.assertEquals(text_of_error, INCORRECT_LOGIN_OR_PASSWORD);

    }

}
