package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class PublicationsPage {
    final SelenideElement FREQUENTLY_SEARCHED = $x("//article[@class = \"wrapper__xcbcb\"]");

    public void visibleFrequntlySearchedColoumn() {
        FREQUENTLY_SEARCHED.shouldBe(Condition.visible);
    }
}
