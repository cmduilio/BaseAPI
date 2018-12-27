package com.galaxy.controller;

import com.galaxy.repository.DayRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//implementation of controller interface
@RestController
public class PingController implements com.galaxy.controller.Controller{

    private static final Logger log = LoggerFactory.getLogger(PingController.class);
	@GetMapping
	@RequestMapping(value = {"/ping" })
	public String getWeather() throws Exception{

        log.info("pong");
        return "pong";
	}
}
