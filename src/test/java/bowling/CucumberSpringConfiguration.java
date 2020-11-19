package bowling;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

@CucumberContextConfiguration
@ComponentScan
@SpringBootTest
public class CucumberSpringConfiguration {

}
