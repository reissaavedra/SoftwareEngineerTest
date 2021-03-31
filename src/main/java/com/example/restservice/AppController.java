package com.example.restservice;


import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
	private final AtomicLong counter = new AtomicLong();

	@Autowired
	private Alphabet alphabet;

	@PostMapping("/es001")
	public ResponseFormat es001(@RequestParam(value = "param1") String param1) {
		ES001 es001 = new ES001(param1, alphabet);
		return new ResponseFormat(counter.incrementAndGet(), es001.solve());
	}

	@PostMapping("/es002")
	public ResponseFormat es002(@RequestParam(value = "values") ArrayList<Integer> param1) {
		ES002 es002 = new ES002(param1);
		return new ResponseFormat(counter.incrementAndGet(), String.valueOf(es002.solve()));
	}
}
