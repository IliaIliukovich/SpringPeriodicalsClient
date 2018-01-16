package com.epam.controllers;

import com.epam.entities.Journal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value="/myjournals")
public class MyJournalController {

	@Autowired
	private OAuth2RestTemplate oauthTemplate;

	@RequestMapping(method = RequestMethod.GET)
	public String getMyJournals(Model model){
		List<Journal> mySubscriptionJournals = oauthTemplate.getForObject("http://localhost:3080/SpringPeriodicals-1.0-SNAPSHOT/api/mysubscriptions",List.class);
		model.addAttribute("mySubscriptionJournals", mySubscriptionJournals);
		return "/myjournals";
	}

}
