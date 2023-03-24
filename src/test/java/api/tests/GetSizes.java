package api.tests;

import api.steps.MajorSteps;
import api.steps.SizeSteps;
import jdk.jfr.Description;
import org.testng.annotations.Test;

public class GetSizes {
    @Test
    @Description("Get sizes")
    public void getSizes(){
        new SizeSteps().getSizes();
    }
}
