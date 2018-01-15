package com.epam.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/myjournals")
public class MyJournalController {

	@RequestMapping(method = RequestMethod.GET)
	public String getMyJournals(Model model){
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		User currentUser = (User)auth.getPrincipal();
//		List<List<Journal>> userJournals = periodicalService.getUserJournals(currentUser.getId_user());
//		BigDecimal sum = periodicalService.sumToPay(currentUser.getId_user());
//		model.addAttribute("myChoiceJournals", userJournals.get(0));
//		model.addAttribute("mySubscriptionJournals", userJournals.get(1));
//		model.addAttribute("sumToPay", sum);
		return "/myjournals";
	}

}
