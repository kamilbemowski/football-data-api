package pl.bemowski.football.data.api.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * Created by Kamil Bemowski on 2017-02-13.
 */
@ComponentScan(basePackages = "pl.bemowski.football.data.api.*")
@Component
@EnableAutoConfiguration
public class BootRunner {

    public static void main(String[] args) {
        SpringApplication.run(BootRunner.class, args);
    }
}
