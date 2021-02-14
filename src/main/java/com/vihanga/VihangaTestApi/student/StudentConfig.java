package com.vihanga.VihangaTestApi.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student vt= new Student(
                    1L,
                    "Vihanga",
                    "liyanage.vihanga99@gmail.com",
                    LocalDate.of(1998, Month.FEBRUARY,12)
            );

            Student iy =new Student(
                    2L,
                    "isuri",
                    "isuri.vihanga99@gmail.com",
                    LocalDate.of(1997, Month.FEBRUARY,12)
            );

            repository.saveAll(List.of(vt,iy));
        };
    };
}
