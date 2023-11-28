import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class Main {
    final String BASE_URL = "https://ok.ru/";
    final SelenideElement UserName = $x("//input[@name=\"st.email\"]");
    final SelenideElement PasswordName = $x("//input[@name=\"st.password\"]");
    final SelenideElement SubmitButton = $x("//input[@value=\"Log in to OK\"]");
}