package com.epam.controllers;

import com.epam.entities.Journal;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping(value="/myjournals")
@PropertySource("classpath:serverConnection.properties")
public class MyJournalController {

	private static final Logger logger = Logger.getLogger(MyJournalController.class);

	@Autowired
	private OAuth2RestTemplate oauthTemplate;

	@Value("${server.url}")
	String serverUrl;

	@RequestMapping(method = RequestMethod.GET)
	public String getMyJournals(Model model){
		logger.info("Connecting to: " + serverUrl);
		List<Journal> myChoiceJournals = oauthTemplate.getForObject(serverUrl + "/rest/mychoices", List.class);
		model.addAttribute("myChoiceJournals", myChoiceJournals);
		List<Journal> mySubscriptionJournals = oauthTemplate.getForObject(serverUrl + "/rest/mysubscriptions", List.class);
		model.addAttribute("mySubscriptionJournals", mySubscriptionJournals);
		BigDecimal sum = oauthTemplate.getForObject(serverUrl + "/rest/sumtopay", BigDecimal.class);
		model.addAttribute("sumToPay", sum);
		return "/myjournals";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String deleteMyChoice (@RequestParam Long choiceId) {
		System.out.println("deleting id: " + choiceId);
		oauthTemplate.postForLocation(serverUrl + "/rest/delete", choiceId);
		return "redirect:/myjournals";
	}

	@RequestMapping(value = "/pay", method = RequestMethod.POST)
	public String pay(@RequestParam BigDecimal sum) {
		oauthTemplate.postForLocation(serverUrl + "/rest/pay", sum);
		return "redirect:/myjournals";
	}

}
