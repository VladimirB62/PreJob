package ui.steps;

import io.cucumber.java8.En;
import ui.pages.MainPage;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;


public class MainPageSteps implements En {
    MainPage mainPage;

    public MainPageSteps() {
        Then("Main Page Title displayed", () -> {
            mainPage = page(MainPage.class);
            mainPage.titleDisplayed();
        });

        When("I check videos", () -> {
            mainPage.videosDisplayed();
        });

        And("I check video Titles", () -> {
            mainPage.titlesDisplayed();
        });

        And("I check filters", () -> {
            mainPage.filtersDisplayed();
        });

        And("I choose Parameters", () -> {
            mainPage.chooseParameters();
        });

        Then("Results are displayed", () -> {
            mainPage.matchingResultsDisplayed();
        });

//        And("check paging",()->{
//            mainPage.clickNextButton();
//        });
//
        And("click JoinToUs Button", () -> {
            mainPage.clickJoinUsButton();
        });

        Then("I'm redirected to Telegram", () -> {
            mainPage.preJobTelIssDisplayed();
        });

    }

}
