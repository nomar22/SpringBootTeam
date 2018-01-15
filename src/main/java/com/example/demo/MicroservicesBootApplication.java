package com.example.demo;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import com.example.demo.dao.TeamDAO;
import com.example.demo.domain.Player;
import com.example.demo.domain.Team;

@SpringBootApplication
public class MicroservicesBootApplication extends SpringBootServletInitializer{

	/**
	 * Used when run as a JAR
	 */
	public static void main(String[] args) {
		SpringApplication.run(MicroservicesBootApplication.class, args);
	}

	/**
	 * Used when run as a WAR
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(MicroservicesBootApplication.class);
	}
	
	@PostConstruct
	public void init() {
		Set<Player> players = new HashSet<>();
		Player rafael = new Player("Rafael","Volante");
		players.add(rafael);
		players.add(new Player("Egidio", "Zagueiro"));
		
		Team team = new Team("500","Contagem","Mula",players);
		
		teamDao.save(team);
		
		players.clear();
		players.add(new Player("Robinho","Volante"));
		players.add(new Player("Arrascaeta","Meia"));
		players.add(new Player("Fred","Atacante"));
		players.add(new Player("Thiago Neves","Meia"));
		players.add(new Player("Sassa","Atacante"));
		players.add(new Player("Rafael","Goleiro"));
		
		Team team2 = new Team("Cruzeiro","Belo Horizonte","Raposa",players);
		
		
		
		teamDao.save(team2);
	}
	
	@Autowired
	TeamDAO teamDao;

	
	
}
