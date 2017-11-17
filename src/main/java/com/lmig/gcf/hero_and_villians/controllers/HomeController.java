package com.lmig.gcf.hero_and_villians.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lmig.gcf.hero_and_villians.methods.Hero;
import com.lmig.gcf.hero_and_villians.methods.Monster;

@Controller
public class HomeController {

	private ArrayList<Monster> ourMonsters;
	private Hero ourHero;

	// Constructor
	public HomeController() {
		initGame();
	}

	// Method to call Constructor
	public void initGame() {

		ourHero = new Hero("Clark Kent", 100, "Superman");

		ourMonsters = new ArrayList<Monster>();

		Monster monster1 = new Monster("Steve", 1, "Vampire");
		Monster monster2 = new Monster("Jeff", 1, "Ogre");
		Monster monster3 = new Monster("Kevin", 1, "Warewolf");
		Monster monster4 = new Monster("Sam", 1, "Vampire");
		Monster monster5 = new Monster("Kevin", 100, "Zombie");

		ourMonsters.add(monster1);
		ourMonsters.add(monster2);
		ourMonsters.add(monster3);
		ourMonsters.add(monster4);
		ourMonsters.add(monster5);

	}

	@RequestMapping("/")
	public ModelAndView defaultPage() {

		ModelAndView mv = new ModelAndView();

		mv.addObject("monsters", ourMonsters);
		mv.addObject("hero", ourHero);
		mv.setViewName("index");

		return mv;

	}

	@RequestMapping("/reset")
	public ModelAndView resetPage() {

		initGame();

		ModelAndView mv = new ModelAndView();

		mv.addObject("monsters", ourMonsters);
		mv.addObject("hero", ourHero);
		mv.setViewName("index");

		return mv;
	}

	public boolean isGameOver() {
		return (!ourHero.isAlive() || ourMonsters.size() == 0);
	}

	public void killMonster(Monster monster) {
		ourMonsters.remove(monster);
	}
	
	@RequestMapping("/death")
	public ModelAndView deathPage() {

		while (!isGameOver()) {

			for (Monster monster : ourMonsters) {

				ourHero.attack(monster);

				if (!monster.isAlive()) {
					killMonster(monster);
				}
				break;
			}
		
		}

		ModelAndView mv = new ModelAndView();

		mv.addObject("monsters", ourMonsters);
		mv.addObject("hero", ourHero);
		mv.addObject("isGameOver", this.isGameOver());
		mv.setViewName("index");

		return mv;
	}

}