import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    final SelenideElement USER_NAME = $x("//input[@name=\"st.email\"]");
    final SelenideElement PASSWORD_NAME = $x("//input[@name=\"st.password\"]");
    final SelenideElement SUBMIT_BUTTON = $x("//input[@value=\"Log in to OK\"]");
    final SelenideElement INFO_ABOUT_ERROR = $x("//div[@class=\"input-e login_error\"]");
    final SelenideElement SEARCH_BUTTON = $x("//input[@class = \"input__prt1l __size-m__prt1l input__mofy2 input-field__on39s __right-icon__on39s __white-toolbar__on39s __redesigned__on39s\"]");
    final SelenideElement INTERESTS_BUTTON = $x("//a[@href = \"/hobby\"]");
    final SelenideElement PEOPLE_BUTTON = $x("//a[@href = \"/search/profiles\"]");


    public void openWebsite(String url) {
        Selenide.open(url);
    }

    public void inputLogin(String login) {
        $(USER_NAME).shouldBe(Condition.visible);
        USER_NAME.click();
        USER_NAME.sendKeys(login);
    }

    public void inputPassword(String password) {
        $(PASSWORD_NAME).shouldBe(Condition.visible);
        PASSWORD_NAME.click();
        PASSWORD_NAME.sendKeys(password);
    }

    public void submitLoginAndPassword() {
        $(SUBMIT_BUTTON).shouldBe(Condition.visible);
        SUBMIT_BUTTON.click();
    }

    public String emptyInputLoginAndPassword() {
        $(INFO_ABOUT_ERROR).shouldBe(Condition.visible);
        return INFO_ABOUT_ERROR.getText();
    }

    public void clickOnSearchButtonInterests() {
        $(SEARCH_BUTTON).shouldBe(Condition.visible);
        SEARCH_BUTTON.click();
        $(INTERESTS_BUTTON).shouldBe(Condition.visible);
        INTERESTS_BUTTON.click();
    }

    public void clickOnSearchButtonPeople() {
        $(SEARCH_BUTTON).shouldBe(Condition.visible);
        SEARCH_BUTTON.click();
        $(PEOPLE_BUTTON).shouldBe(Condition.visible);
        PEOPLE_BUTTON.click();
    }

}
