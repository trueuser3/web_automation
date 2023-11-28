import static com.codeborne.selenide.Selenide.$x;

public class ProfilePage {
    public String get_href_profile_page(){
        return $x("//nav[@role=\"navigation\"]").getAttribute("aria-label");
    }
}
