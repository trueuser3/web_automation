package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    final SelenideElement USER_NAME = $x("//input[@name=\"st.email\"]");
    final SelenideElement PASSWORD_NAME = $x("//input[@name=\"st.password\"]");
    final SelenideElement SUBMIT_BUTTON = $x("//input[@value=\"Log in to OK\"]");
    final SelenideElement INFO_ABOUT_ERROR = $x("//div[@class=\"input-e login_error\"]");


    public void inputLogin(String login) {
        USER_NAME.shouldBe(Condition.visible);
        USER_NAME.click();
        USER_NAME.sendKeys(login);
    }

    public void inputPassword(String password) {
        PASSWORD_NAME.shouldBe(Condition.visible);
        PASSWORD_NAME.click();
        PASSWORD_NAME.sendKeys(password);
    }

    public void submitLoginAndPassword() {
        SUBMIT_BUTTON.shouldBe(Condition.visible);
        SUBMIT_BUTTON.click();
    }

    public String emptyInputLoginAndPassword() {
        INFO_ABOUT_ERROR.shouldBe(Condition.visible);
        return INFO_ABOUT_ERROR.getText();
    }

}
