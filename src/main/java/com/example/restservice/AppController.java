package com.example.restservice;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
//		CharacterIterator iterator = new StringCharacterIterator(param1);
//		while (iterator.current() != CharacterIterator.DONE){
//			System.out.print(iterator.current());
//			iterator.next();
//		}
		StringBuilder sb = new StringBuilder();
		LinkedHashMap<String, String> list_alphabet = alphabet.getAlphabet();
		for(int i=0, len=param1.length(); i<len; i++) {
			char c = param1.charAt(i);
			String a = list_alphabet.get(String.valueOf(Character.toLowerCase(c)));
			if(a == null){
				sb.append(c);
			}else{
				if(!Character.isUpperCase(c)){
					sb.append(a);
				}else{
					sb.append(a.toUpperCase());
				}
			}
		}
		return new ResponseFormat(counter.incrementAndGet(), String.valueOf(sb));
	}

	@PostMapping("/es002")
	public ResponseFormat es002(@RequestParam(value = "values") List<Integer> param1) {
		HeapSortedArray heapSortedArray = new HeapSortedArray(param1);
//		CompletedArray.solve(heapSortedArray.getArray().toArray());
		return new ResponseFormat(counter.incrementAndGet(), Arrays.toString(heapSortedArray.getArray().toArray()));
	}

}
