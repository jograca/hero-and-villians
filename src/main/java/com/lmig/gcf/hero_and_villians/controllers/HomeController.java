package com.lmig.gcf.hero_and_villians.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lmig.gcf.hero_and_villians.methods.Hero;
import com.lmig.gcf.hero_and_villians.methods.Monster;

@Controller
public class HomeController {

	private Monster ourMonster;
	private Hero ourHero;

	// Constructor
	public HomeController() {
		initGame();
	}

	// Method to call Constructor
	public void initGame() {

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

		ArrayList<String> list = new ArrayList<String>();
		
		list.add("Jon");
		list.add("Paul");
		list.add("Graca");
		
		for (int i = 0; i <= (list.size() -1); i ++) {
			System.out.println(list.get(i));
		}
		
		for (String name : list) {
			System.out.println(name);
		}
		
		System.out.println("Monster Health is: " + ourMonster.getHealth());
		System.out.println("Hero Health is: " + ourHero.getHealth());

		ourHero.attack(ourMonster);

		ModelAndView mv = new ModelAndView();

		mv.addObject("monster", ourMonster);
		mv.addObject("hero", ourHero);
		mv.addObject("isGameOver", this.isGameOver());
		mv.setViewName("index");

		return mv;
	}

	@RequestMapping("/death")
	public ModelAndView deathPage() {

		ourHero.attack(ourMonster);

		while (!isGameOver()) {

			System.out.println("Monster Health is: " + ourMonster.getHealth());
			System.out.println("Hero Health is: " + ourHero.getHealth());

			ourHero.attack(ourMonster);
		}

		ModelAndView mv = new ModelAndView();

		mv.addObject("monster", ourMonster);
		mv.addObject("hero", ourHero);
		mv.addObject("isGameOver", this.isGameOver());
		mv.setViewName("index");

		return mv;
	}

	@RequestMapping("/reset")
	public ModelAndView resetPage() {

		initGame();

		ModelAndView mv = new ModelAndView();

		mv.addObject("monster", ourMonster);
		mv.addObject("hero", ourHero);
		mv.addObject("isGameOver", this.isGameOver());
		mv.setViewName("index");

		return mv;
	}

	public boolean isGameOver() {
		return (!ourMonster.isAlive() || !ourHero.isAlive());
	}

}
