import com.codeborne.selenide.Configuration;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class LoginTest extends Main {
    @Test
    public void checkLoginSucces(){
        Configuration.holdBrowserOpen = true;
        LoginPage loginPage = new LoginPage();
        loginPage.open_website(BASE_URL);
        loginPage.input_login("QAbot1");
        loginPage.input_password("3ml3ZdbnK9");
        loginPage.submit_login_and_password();
        ProfilePage profilePage = new ProfilePage();
        String href = profilePage.get_href_profile_page();
        System.out.print(href);
        Assert.assertTrue(href.equals("Верхнее меню"));
    }

    @Test
    public void checkNoLoginAndPassword(){
        Configuration.holdBrowserOpen = true;
        LoginPage loginPage = new LoginPage();
        loginPage.open_website(BASE_URL);
        loginPage.input_login("");
        loginPage.input_password("");
        loginPage.submit_login_and_password();
        String text_of_error = loginPage.empty_input_login_and_password();
        Assert.assertTrue(text_of_error.equals("Enter your username"));
    }

    @Test
    public void checkNoPassword(){
        Configuration.holdBrowserOpen = true;
        LoginPage loginPage = new LoginPage();
        loginPage.open_website(BASE_URL);
        loginPage.input_login("Example");
        loginPage.input_password("");
        loginPage.submit_login_and_password();
        String text_of_error = loginPage.empty_input_login_and_password();
        Assert.assertTrue(text_of_error.equals("Enter password"));
    }

    @Test
    public void checkNoLogin(){
        Configuration.holdBrowserOpen = true;
        LoginPage loginPage = new LoginPage();
        loginPage.open_website(BASE_URL);
        loginPage.input_login("");
        loginPage.input_password("Example");
        loginPage.submit_login_and_password();
        String text_of_error = loginPage.empty_input_login_and_password();
        Assert.assertTrue(text_of_error.equals("Enter your username"));
    }

    @Test
    public void checkWrongPasswordOrLogin(){
        Configuration.holdBrowserOpen = true;
        LoginPage loginPage = new LoginPage();
        loginPage.open_website(BASE_URL);
        loginPage.input_login("ExampleLogin");
        loginPage.input_password("ExamplePassword");
        loginPage.submit_login_and_password();
        String text_of_error = loginPage.empty_input_login_and_password();
        Assert.assertTrue(text_of_error.equals("Incorrect username and/or password"));
    }
}
