package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class VideoPage {
    final SelenideElement WEEKLY_HITS = $x("//div[@class = \"video-content\"]");

    public void visibleWeeklyHits() {
        WEEKLY_HITS.shouldBe(Condition.visible);
    }
}
