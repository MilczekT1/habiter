package pl.konradboniecki.habiter;

import org.springframework.boot.SpringApplication;
import pl.konradboniecki.chassis.ChassisApplication;

//@EnableMongoRepositories
@ChassisApplication
public class HabiterApplication {

    public static void main(String[] args) {
        SpringApplication.run(HabiterApplication.class, args);
    }
}
