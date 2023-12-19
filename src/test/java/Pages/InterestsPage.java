package Pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public class InterestsPage {

    final SelenideElement HEAD_TITLE = $x("//span[@class = \"hobby-head-title__xhwvb\"]");
    final SelenideElement H1_TITLE = $x("//h1[@class = \"hobby-head-description__xhwvb\"]");
    final SelenideElement INTERESTS_PAGE_SEARCH_BOX = $x("//input[@class = \"input__prt1l __size-m__prt1l input__t53m6 input-right__t53m6 search-input__hogpo\"]");

    public void visibleHeadTitle() {
        HEAD_TITLE.shouldBe(Condition.visible);
        H1_TITLE.shouldBe(Condition.visible);
        INTERESTS_PAGE_SEARCH_BOX.shouldBe(Condition.visible);
    }
}
