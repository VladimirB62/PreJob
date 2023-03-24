package api.tests;

import api.steps.IndustriesSteps;
import jdk.jfr.Description;
import org.testng.annotations.Test;

public class GetIndustries {

    @Test
    @Description("Get industries")
    public void getIndustries(){
        new IndustriesSteps().getIndustries();
    }
}
