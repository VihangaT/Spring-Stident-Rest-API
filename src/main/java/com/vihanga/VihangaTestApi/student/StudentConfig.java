package com.vihanga.VihangaTestApi.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student vt= new Student(
                    1L,
                    "Vihanga",
                    "liyanage.vihanga99@gmail.com",
                    LocalDate.of(2021, Month.FEBRUARY,12),
                    22
            );

            Student iy =new Student(
                    "isuri",
                    "isuri.vihanga99@gmail.com",
                    LocalDate.of(2020, Month.FEBRUARY,12),
                    22
            );
        };
    };
}
