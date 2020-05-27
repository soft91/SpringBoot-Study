package com.example.chapter01;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;

@SpringBootApplication
public class Chapter01Application {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(Chapter01Application.class);

		application.setWebApplicationType(WebApplicationType.SERVLET);
		application.setBannerMode(Banner.Mode.OFF);
		application.run(args);
	}

}
