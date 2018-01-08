package com.example.demo.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
@RequestMapping("/nav")
public class Nav {

	public static void main(String[] args) {
		SpringApplication.run(Nav.class, args);
	}

	@RequestMapping("/{id}")
	public String pathChange(@PathVariable("id") String id){
		return "/nav/"+id;
	}
}
