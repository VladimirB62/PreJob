package ui.steps;



import io.cucumber.java8.En;
import ui.pages.HomePage;

import static com.codeborne.selenide.Selenide.open;
import static ui.pages.HomePage.baseURL;


public class HomePageSteps implements En {

    HomePage home;

    public HomePageSteps() {
        Given("Navigate to Home Page", () -> {
            //System.setProperty("selenide.browser", "Firefox");
            home = open(baseURL, HomePage.class);
        });

        When("Check title", () -> {
            home.titleDisplayed();
        });

        And("Check Telegram QR-code",()->{
           home.telegramQrDisplayed();
       });

        And("Check Telegram Link",()->{
            home.telegramLinkDisplayed();
        });

        And("I choose profession",()->{
            home.chooseProfession();
        });

    }
}

