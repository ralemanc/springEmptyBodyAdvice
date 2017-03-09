package com.example.controller;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Foo Controller
 *
 * @author rafa aleman
 */
@RestController
@RequestMapping("/foo")
public class FooController {

	@PutMapping
	public String returnString() {
		return "bar";
	}

	@PutMapping("/empty")
	public void emptyBody() {
	}
}
