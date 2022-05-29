package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.TutorialPage;
import util.DriverFactory;

public class TutorialSteps {

    TutorialPage tutorialPage = new TutorialPage(DriverFactory.getDriver());

    @Given("Enes is opened LcWaikiki App")
    public void assertTutorialPage() { tutorialPage.checkTutorialPage();}

    @Then("should see TvTutorial")
    public void assertTVTutorial() { tutorialPage.checkTVTutorial();}

    @Then("should see {string} text")
    public void assertTVText(String text) { tutorialPage.checkTVText(text);}

    @Then("should see {string} title")
    public void assertTVTitle(String title) { tutorialPage.checkTVTitleText(title);}

    @Then("should see {string} title description")
    public void assertTVDesc (String desc) { tutorialPage.checkTVDescText(desc);}

    @Then("should see {string} button")
    public void assertButton (String button) { tutorialPage.checkTVButton(button);}

    // DragDrop
    @When("drag and drop TvTutorial")
    public void dragAndDropTVTutorial() { tutorialPage.dragAndDropTVTutorial();}

    // Skip Button
    @When("click Skip button")
    public void skipButton() { tutorialPage.clickTVSkipButton();}

    @Then("should see {string} Home Page")
    public void welcomeButton (String welcomeText) { tutorialPage.checkWelcomeText(welcomeText);}

    // Add to Favorites and Check
    @Then("click Search button")
    public void searchButton () { tutorialPage.clickSearchButton();}

    @When("type {string} product")
    public void searchButtonType(String text) {
        tutorialPage.typeSearchButtonProduct(text);

    }
}