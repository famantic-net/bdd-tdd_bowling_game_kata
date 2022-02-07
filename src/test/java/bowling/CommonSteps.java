package bowling;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.Assert.assertNotNull;


@SpringBootTest
public class CommonSteps {
    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    BowlingGame game;

    @Before
    public void before() throws Exception {
        assertNotNull(applicationContext);
        assertNotNull(game);
        System.out.println("BEFORE: Test component=" + game.toString());
    }

    @After
    public void after() throws Exception {
        assertNotNull(applicationContext);
        assertNotNull(game);
        System.out.println("AFTER: Test component=" + game.toString());

    }
}
