
package com.galaxy;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.galaxy.model.Day;
import com.galaxy.repository.DayRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.galaxy.controller.PingController;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = WebEnvironment.DEFINED_PORT)
public class ApplicationTest {

	@LocalServerPort
	private int port;
	
	@Autowired
	private PingController pingController;
    
	@Autowired
	private DayRepository dayRepository;

	
	@Test
	public void contextLoads() throws Exception {
		assertNotNull(pingController);
		assertNotNull(dayRepository);
	}
	@Test
	public void callDayService() {
		Day day = dayRepository.getById(361);
		assertTrue(day.getWeather().equals("asd"));
	}
	
	@Test
	public void callWeatherService() {
		RestTemplate restTemplate = new RestTemplate();
		String pong = restTemplate.getForObject("http://localhost:" + port + "/ping", String.class);
		assertTrue(pong.equals("pong"));
	}

}