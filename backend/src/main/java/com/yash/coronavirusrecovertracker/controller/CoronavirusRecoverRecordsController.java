package com.yash.coronavirusrecovertracker.controller;

import com.yash.coronavirusrecovertracker.model.CoronaVirusRecordsTableModel;
import com.yash.coronavirusrecovertracker.service.CoronavirusRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class CoronavirusRecoverRecordsController {
    @Autowired
    CoronavirusRecordsService service;

    
    @GetMapping(value = "/getAllRecords")
    public List<CoronaVirusRecordsTableModel> getRecords() throws URISyntaxException, IOException, InterruptedException {

        return service.getRecordsFromUrl();

    }
}
