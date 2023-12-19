package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ButtonsLoginPage {

    final SelenideElement SEARCH_BUTTON = $x("//input[@class = \"input__prt1l __size-m__prt1l input__mofy2 input-field__on39s __right-icon__on39s __white-toolbar__on39s __redesigned__on39s\"]");
    final SelenideElement INTERESTS_BUTTON = $x("//a[@href = \"/hobby\"]");
    final SelenideElement PEOPLE_BUTTON = $x("//a[@href = \"/search/profiles\"]");
    final SelenideElement PUBLICATIONS_BUTTON = $x("//a[@href = \"/search/content\"]");
    final SelenideElement VIDEO_BUTTON = $x("//a[@href = \"/video\"]");

    public void clickOnSearchButtonInterests() {
        SEARCH_BUTTON.shouldBe(Condition.visible);
        SEARCH_BUTTON.click();
        INTERESTS_BUTTON.shouldBe(Condition.visible);
        INTERESTS_BUTTON.click();
    }

    public void clickOnSearchButtonPeople() {
        SEARCH_BUTTON.shouldBe(Condition.visible);
        SEARCH_BUTTON.click();
        PEOPLE_BUTTON.shouldBe(Condition.visible);
        PEOPLE_BUTTON.click();
    }

    public void clickOnSearchButtonPublications() {
        SEARCH_BUTTON.shouldBe(Condition.visible);
        SEARCH_BUTTON.click();
        PUBLICATIONS_BUTTON.shouldBe(Condition.visible);
        PUBLICATIONS_BUTTON.click();
    }

    public void clickOnSearchButtonVideo() {
        SEARCH_BUTTON.shouldBe(Condition.visible);
        SEARCH_BUTTON.click();
        VIDEO_BUTTON.shouldBe(Condition.visible);
        VIDEO_BUTTON.click();
    }

}
