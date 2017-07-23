package ovh.cybuch.composite.key;

import com.github.mongobee.Mongobee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class MongobeeConfiguration {

    @Bean
    public Mongobee mongobee(){
        Mongobee runner = new Mongobee("mongodb://localhost:27017/test");
        runner.setChangeLogsScanPackage(
                "ovh.cybuch.composite.key");
        runner.setEnabled(true);

        return runner;
    }
}
