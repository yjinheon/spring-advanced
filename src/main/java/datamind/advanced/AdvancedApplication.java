package datamind.advanced;

import datamind.advanced.proxy.config.AppV2Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Import;
import datamind.advanced.proxy.config.AppV1Config;



@Import(AppV2Config.class)
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class} , scanBasePackages = "datamind.advanced.proxy.app")
// DataSourceAutoConfiguration.class를 제외시킨다.\
//@SpringBootApplitcation(scanBasePackagees = "hello.proxy.app.v3")
public class AdvancedApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdvancedApplication.class, args);
    }
}
