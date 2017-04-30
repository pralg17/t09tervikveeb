package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT	)
public class T10ApplicationTests {
	@Autowired
	private TestRestTemplate restTemplate;
	@Test
	public void contextLoads() {
		assertEquals("1084.57",
				this.restTemplate.getForObject("/calc?sum=30000&period=36&intress=18",String.class));

	}

}
