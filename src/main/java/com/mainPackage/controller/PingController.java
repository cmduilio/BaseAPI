package com.mainPackage.controller;

import com.mainPackage.repository.DayRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//implementation of controller interface
@RestController
public class PingController implements com.mainPackage.controller.Controller{

    @Autowired
    private DayRepository dayRepository;

    private static final Logger log = LoggerFactory.getLogger(PingController.class);


    @GetMapping
	@RequestMapping(value = {"/ping" })
	public String getWeather() throws Exception{

        log.info("pong");
        return "pong";
	}

    @GetMapping
    @RequestMapping(value = {"/pings" })
    public String getAll() throws Exception{

        dayRepository.getList();
        return "pong";
    }
}
