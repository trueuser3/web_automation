import Pages.*;
import org.junit.jupiter.api.Test;

public class LoginPageButtonTest extends BaseTest {

    @Test
    public void checkSearchButtonInterests() {
        ButtonsLoginPage buttonsLoginPageLoginPage = new ButtonsLoginPage();
        buttonsLoginPageLoginPage.clickOnSearchButtonInterests();
        InterestsPage interestsPage = new InterestsPage();
        interestsPage.visibleHeadTitle();
    }

    @Test
    public void checkSearchButtonPeople() {
        ButtonsLoginPage buttonsLoginPageLoginPage = new ButtonsLoginPage();
        buttonsLoginPageLoginPage.clickOnSearchButtonPeople();
        PeoplePage peoplePage = new PeoplePage();
        peoplePage.visiblePeopleFoundCounter();
    }

    @Test
    public void checkSearchButtonPublications() {
        ButtonsLoginPage buttonsLoginPageLoginPage = new ButtonsLoginPage();
        buttonsLoginPageLoginPage.clickOnSearchButtonPublications();
        PublicationsPage publicationsPage = new PublicationsPage();
        publicationsPage.visibleFrequntlySearchedColoumn();
    }

    @Test
    public void checkSearchButtonVideo() {
        ButtonsLoginPage buttonsLoginPageLoginPage = new ButtonsLoginPage();
        buttonsLoginPageLoginPage.clickOnSearchButtonVideo();
        VideoPage videoPage = new VideoPage();
        videoPage.visibleWeeklyHits();
    }

}
