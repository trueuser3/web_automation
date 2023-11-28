import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends LoginTest{
    public void open_website(String url){
        Selenide.open(url);
    }

    public void input_login(String login){
        UserName.click();
        UserName.sendKeys(login);
    }

    public void input_password(String password){
        PasswordName.click();
        PasswordName.sendKeys(password);
    }

    public void submit_login_and_password(){
        SubmitButton.click();
    }

    public String empty_input_login_and_password(){
        return $x("//div[@class=\"input-e login_error\"]").getText();
    }
}
