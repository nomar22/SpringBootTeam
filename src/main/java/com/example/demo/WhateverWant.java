package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.TeamDAO;
import com.example.demo.domain.Team;

@RestController
public class WhateverWant {
	@Autowired
	TeamDAO teamDao;

	
	@RequestMapping("/hi/{name}")
	public  List<Team> hiThere(@PathVariable String name){
		return teamDao.findByPlayersName(name);
	}

}
