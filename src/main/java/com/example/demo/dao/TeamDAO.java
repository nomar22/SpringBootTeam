package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.example.demo.domain.Player;
import com.example.demo.domain.Team;

@RestResource(path="teams", rel="teams" )
public interface TeamDAO extends CrudRepository<Team, Long> {
	
	
	List<Team>findAll();
	
	Team findByName(String name);
	
	List<Team> findByPlayersName(String name);
	
	List<Team> findByPlayers(Player name);

}
