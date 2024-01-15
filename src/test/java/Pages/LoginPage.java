package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    final SelenideElement USER_NAME = $x("//input[@name=\"st.email\"]");
    final SelenideElement PASSWORD_NAME = $x("//input[@name=\"st.password\"]");
    final SelenideElement SUBMIT_BUTTON = $x("//input[@value=\"Log in to OK\"]");
    final SelenideElement INFO_ABOUT_ERROR = $x("//div[@class=\"input-e login_error\"]");

    public LoginPage inputLogin(String login) {
        LoginPage tempLoginPage = new LoginPage();
        USER_NAME.shouldBe(Condition.visible).click();
        USER_NAME.sendKeys(login);
        return tempLoginPage;
    }

    public LoginPage inputPassword(String password) {
        LoginPage tempLoginPage = new LoginPage();
        PASSWORD_NAME.shouldBe(Condition.visible).click();
        PASSWORD_NAME.sendKeys(password);
        return tempLoginPage;
    }

    public void submitLoginAndPassword() {
        SUBMIT_BUTTON.shouldBe(Condition.visible).click();
    }

    public String emptyInputLoginAndPassword() {
        return INFO_ABOUT_ERROR.shouldBe(Condition.visible).getText();
    }

}
