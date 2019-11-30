package com.tasif.apachespark.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tasif.apachespark.service.WordCountService;

@RestController
@RequestMapping("/spark")
public class WordCountController {

	@Autowired
	private WordCountService wordCountService;
	
	@GetMapping
	public Map<String, Long> count(@RequestParam(required = false) String words) {
		List<String> wordList = Arrays.asList(words.split("\\|"));
		return wordCountService.getCount(wordList);
	}
}
