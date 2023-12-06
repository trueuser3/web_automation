import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.SelenideElement;

public class ProfilePage {

    final SelenideElement TOP_MENU_PATH = $x("//nav[@role=\"navigation\"]");
    final String ATTRIBUTE_ARIA_LABEL = "aria-label";

    public String getHrefProfilePage() {
        return TOP_MENU_PATH.getAttribute(ATTRIBUTE_ARIA_LABEL);
    }
}
