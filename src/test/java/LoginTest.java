import Pages.LoginPage;
import Pages.ProfilePage;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import model.UserModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;


public class LoginTest extends BaseTest {
    static final String CORRECT_LOGIN = "QAbot1";
    static final String CORRECT_PASSWORD = "3ml3ZdbnK9";
    static final String INCORRECT_LOGIN = "ExampleLogin";
    static final String INCORRECT_PASSWORD = "ExamplePassword";
    static final String UPPERCASE_LOGIN = "QABOT1";
    static final String UPPERCASE_PASSWORD = "3ML3ZDBNK9";
    static final String TOP_MENU = "Верхнее меню";
    static final String ENTER_YOUR_USERNAME = "Enter your username";
    static final String ENTER_PASSWORD = "Enter password";
    static final String INCORRECT_LOGIN_OR_PASSWORD = "Incorrect username and/or password";


    @Test
    @Description(value = "Тест проверяет, что вход на страницу не выполнится, если не введен пароль")
    @Owner(value = "Иванов Иван Иванович")
    public void checkNoPassword() {
        LoginPage loginPage = new LoginPage();
        loginPage.inputLogin(CORRECT_LOGIN).inputPassword("").submitLoginAndPassword();
        String text_of_error = loginPage.emptyInputLoginAndPassword();
        Assertions.assertEquals(text_of_error, ENTER_PASSWORD);
    }


    @ParameterizedTest
    @ValueSource(strings = {"", INCORRECT_PASSWORD})
    void checkEmptyLogin(String word) {
        LoginPage loginPage = new LoginPage();
        loginPage.inputLogin("").inputPassword(word).submitLoginAndPassword();
        String text_of_error = loginPage.emptyInputLoginAndPassword();
        Assertions.assertEquals(text_of_error, ENTER_YOUR_USERNAME);

    }


    @ParameterizedTest
    @MethodSource(value = "testLoginsAndPasswords")
    public void succesLoginAndPassword(UserModel userModel) {
        LoginPage loginPage = new LoginPage();
        loginPage.inputLogin(userModel.getLoginName()).inputPassword(userModel.getPassword()).submitLoginAndPassword();
        ProfilePage profilePage = new ProfilePage();
        String href = profilePage.getHrefProfilePage();
        Assertions.assertEquals(href, TOP_MENU);
    }

    private static Stream<UserModel> testLoginsAndPasswords() {
        UserModel goodLoginAndPassword = UserModel.builder().loginName(CORRECT_LOGIN).password(CORRECT_PASSWORD).build();
        UserModel uppercaseLogin = UserModel.builder().loginName(UPPERCASE_LOGIN).password(CORRECT_PASSWORD).build();
        return Stream.of(goodLoginAndPassword, uppercaseLogin);
    }

    @ParameterizedTest
    @MethodSource(value = "testLoginsAndPasswords2")
    public void nonSuccesLoginOrPassword(UserModel userModel) {
        LoginPage loginPage = new LoginPage();
        loginPage.inputLogin(userModel.getLoginName()).inputPassword(userModel.getPassword()).submitLoginAndPassword();
        String text_of_error = loginPage.emptyInputLoginAndPassword();
        Assertions.assertEquals(text_of_error, INCORRECT_LOGIN_OR_PASSWORD);
    }

    private static Stream<UserModel> testLoginsAndPasswords2() {
        UserModel user1 = UserModel.builder().loginName(INCORRECT_LOGIN).password(CORRECT_PASSWORD).build();
        UserModel user2 = UserModel.builder().loginName(CORRECT_LOGIN).password(INCORRECT_PASSWORD).build();
        UserModel user3 = UserModel.builder().loginName(CORRECT_LOGIN).password(UPPERCASE_PASSWORD).build();
        UserModel user4 = UserModel.builder().loginName(INCORRECT_LOGIN).password(INCORRECT_PASSWORD).build();
        return Stream.of(user1, user2, user3, user4);
    }

}
