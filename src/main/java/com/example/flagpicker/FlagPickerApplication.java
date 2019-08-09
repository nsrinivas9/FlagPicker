package com.example.flagpicker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author SRINIVASARAON
 *
 */

@SpringBootApplication
public class FlagPickerApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(FlagPickerApplication.class, args);
	}
@Override
protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	// TODO Auto-generated method stub
	return builder.sources(FlagPickerApplication.class);
}
	}
