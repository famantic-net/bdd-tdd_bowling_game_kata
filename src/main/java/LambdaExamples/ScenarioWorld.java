package LambdaExamples;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by cla_johbac on 2016-04-15.
 */
@Component
@Scope("cucumber-glue")
public class ScenarioWorld {

    // Methods for manipulating state below

    private String state;

    public ScenarioWorld(){
        state = "Not started";
    }

    public void start(){
        state = "Started";
    }

    public String getState(){
        return state;
    }
}
