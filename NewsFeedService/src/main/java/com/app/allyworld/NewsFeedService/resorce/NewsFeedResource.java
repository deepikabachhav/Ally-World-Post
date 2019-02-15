package com.app.allyworld.NewsFeedService.resorce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.app.allyworld.NewsFeedService.entity.Post;


@RestController
@RequestMapping("/newsfeed")
public class NewsFeedResource {
	
	/*
	 * @Autowired private NewsFeedService newsFeedService;
	 */
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/hi")
	public String hello() {
		System.out.println("Hello World!!");
		return "Hello World!!";
	}

	@GetMapping
	public ResponseEntity<List<Post>> getAllPosts(@RequestBody Post post) {
		ResponseEntity<List> entity=restTemplate.getForEntity("http://localhost:8989/posts", List.class);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
