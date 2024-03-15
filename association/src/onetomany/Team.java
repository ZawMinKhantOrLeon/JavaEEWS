package onetomany;

import java.util.ArrayList;
import java.util.List;

public class Team {
	
	private String name;
	private List<Player> players = new ArrayList<Player>();
	
	public Team() {
		
	}


	public Team(String name) {
		super();
		this.name = name;
	}
	
	

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<Player> getPlayers() {
		return players;
	}


	public void setPlayers(List<Player> players) {
		this.players = players;
	}


	@Override
	public String toString() {
		return "Team [name=" + name + "]";
	}
	
	
}
