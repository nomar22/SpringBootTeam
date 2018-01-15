package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.PlayerDAO;
import com.example.demo.dao.TeamDAO;
import com.example.demo.domain.Player;
import com.example.demo.domain.Team;

@RestController
public class WhateverWant {
	@Autowired
	TeamDAO teamDao;
	
	@Autowired
	PlayerDAO playerDao;

	
	@RequestMapping(value="/playersByTeam/", method=RequestMethod.POST)
	public  List<Player> playersByTeam(@RequestBody Team team){
		return playerDao.findByTeam(team);
	}
	@RequestMapping(value="/teamsByPlayer/", method=RequestMethod.POST)
	public  List<Team> teamsByPlayer(@RequestBody Player player){
		return teamDao.findByPlayers(player);
	}
	@RequestMapping("/playersByTeam/{id}")
	public  List<Player> playersByTeamId(@PathVariable Long id){
		return playerDao.findByTeamId(id);
	}
	@RequestMapping("/playersByTeamName/{teamName}")
	public  List<Player> playersByTeamId(@PathVariable String teamName){
		return playerDao.findByTeamName(teamName);
	}
	@RequestMapping("/teamsByPlayer/{name}")
	public  List<Team> hiThere(@PathVariable String name){
		return teamDao.findByPlayersName(name);
	}
	@RequestMapping("/playerByPosition/{position}")
	public  List<Player> findByPostion(@PathVariable String position){
		return playerDao.findByPosition(position);
	}
	
	
	
	

}
