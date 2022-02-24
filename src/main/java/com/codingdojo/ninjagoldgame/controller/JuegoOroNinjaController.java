package com.codingdojo.ninjagoldgame.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import javax.servlet.http.HttpSession;
import javax.swing.text.GapContent;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.ninjagoldgame.models.DateTime;
import com.codingdojo.ninjagoldgame.models.GoldGame;

@Controller
public class JuegoOroNinjaController {
	@RequestMapping("/")
	public String index(HttpSession session) {
		
		System.out.println(session.getAttribute("total"));
		System.out.println(session.getAttribute("lista"));
		if (session.getAttribute("total") == null) {
			session.setAttribute("total", 0);
		}
		if (session.getAttribute("lista") == null) {
			ArrayList<GoldGame> lista = new ArrayList<GoldGame>();
			session.setAttribute("lista", lista);
		}
		System.out.println(session.getAttribute("total"));
		System.out.println(session.getAttribute("lista"));
		return "index";
	}
	@RequestMapping(value = "/process-money", method = RequestMethod.POST)
	public String processMoney(@RequestParam(value = "stage") String stage, HttpSession session) {
		
		  if (session.getAttribute("total") == null) { 
			  session.setAttribute("total",0); } 
		  if (session.getAttribute("lista") == null) { 
			  ArrayList<GoldGame> lista = new ArrayList<GoldGame>(); 
			  session.setAttribute("lista", lista); }
		 
		
		  Integer num = randomStage(stage); 
		  DateTime dateTime = new DateTime(); 
		  String dateTimeString = dateTime.getDateFormat();
		  
		  ArrayList<GoldGame> lista = (ArrayList<GoldGame>) session.getAttribute("lista"); 
		  Integer total = (Integer) session.getAttribute("total");
		  System.out.println(lista);
		  System.out.println(total);
			
			  if (num>0) { 
				  GoldGame game = new GoldGame(stage, num, 1, dateTimeString);
				  lista.add(game); 
				  session.setAttribute("lista", lista);
				  session.setAttribute("total", total+num);
			  
			  } else { 
				  System.out.println(num);
				  GoldGame game = new GoldGame(stage, num, 0, dateTimeString);
				  lista.add(game); 
				  session.setAttribute("lista", lista);
				  session.setAttribute("total", total+num); 
				  }
			 
		return "redirect:/";
	}
	
	@RequestMapping(value = "/reset", method = RequestMethod.GET)
	public String reset(HttpSession session) {
		session.setAttribute("total", 0);
		ArrayList<GoldGame> lista = new ArrayList<GoldGame>();
		session.setAttribute("lista", lista);
		return "redirect:/";
	}
	
	private int randomStage(String stage) {
		if (stage.equals("farm")) {
			int num = randomTwoValues(10, 20);
			return num;
		}
		if (stage.equals("cave")) {
			int num = randomTwoValues(5, 10);
			return num;
		}
		if (stage.equals("house")) {
			int num = randomTwoValues(2, 5);
			return num;
		}
		if (stage.equals("casino")) {
			int num = randomTwoValues(0, 50);
			int earnOrLost =randomTwoValues(0, 1);
			if (earnOrLost == 1) {
				return num;
			} else {
				return -num;
			}
		}
		return 0;
	}
	
	private Integer randomTwoValues(int min, int max) {
		Random random = new Random();
		int randomNumber = random.nextInt((max + 1) - min);
		int result = randomNumber + min;
		return result;
	}
	
}
