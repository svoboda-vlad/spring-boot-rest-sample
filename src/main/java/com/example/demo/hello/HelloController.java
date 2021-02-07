package com.example.demo.hello;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Data;

@RestController
public class HelloController {
	
	private static final String HELLO_URL = "/hello";
	private static final String HELLO_RESTRICTED_URL = "/hello-restricted";
	
	@GetMapping(HELLO_URL)
	public ResponseEntity<Hello> sayHello() {
		String text = "Hello World!";
		return ResponseEntity.ok(new Hello(text));
	}
	
	@GetMapping(HELLO_RESTRICTED_URL)
	public ResponseEntity<Hello> sayHelloRestricted() {
		String text = "Hello World! (restricted)";
		return ResponseEntity.ok(new Hello(text));
	}	
	
	@Data
	@AllArgsConstructor
	private class Hello {
		private String text;
	}

}
