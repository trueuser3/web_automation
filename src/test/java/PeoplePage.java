import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public class PeoplePage {

    final SelenideElement PEOPLE_FOUND_COUNTER = $x("//h2[@class = \"heading__unijc __h2__unijc\"]");

    public void visiblePeopleFoundCounter() {
        $(PEOPLE_FOUND_COUNTER).shouldBe(Condition.visible);
    }
}
