package com.attendance.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class StudentAttendanceSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentAttendanceSystemApplication.class, args);
	}

}
