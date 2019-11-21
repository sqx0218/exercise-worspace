package com.jk;

import com.spring4all.mongodb.EnableMongoPlus;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableMongoPlus
public class WebExerciseConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebExerciseConsumerApplication.class, args);
    }

}
