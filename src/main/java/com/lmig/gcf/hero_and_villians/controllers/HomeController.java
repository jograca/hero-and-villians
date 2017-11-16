package com.lmig.gcf.hero_and_villians.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lmig.gcf.hero_and_villians.methods.Hero;
import com.lmig.gcf.hero_and_villians.methods.Monster;

@Controller
public class HomeController {

	private Monster ourMonster;
	private Hero ourHero;

	public HomeController() {
		ourMonster = new Monster("Steve", 100, "Vampire");
		ourHero = new Hero("Clark Kent", 100, "Superman");
	}

	@RequestMapping("/")
	public ModelAndView defaultPage() {

		ModelAndView mv = new ModelAndView();
		
		mv.addObject("monster", ourMonster);
		mv.addObject("hero", ourHero);
		mv.setViewName("index");

		return mv;
	}
	
	@RequestMapping("/attack")
	public ModelAndView attackPage() {
		
		ourHero.attack(ourMonster);

		ModelAndView mv = new ModelAndView();
		
		mv.addObject("monster", ourMonster);
		mv.addObject("hero", ourHero);
		mv.setViewName("index");

		return mv;
	}

}
