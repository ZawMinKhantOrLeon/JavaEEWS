package onetomany;

public class OneToManyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Team manU = new Team("ManU");
		Player onana = new Player("Onana");
		Player macguire = new Player("Macguire");
		
		manU.getPlayers().add(onana);
		manU.getPlayers().add(macguire);
		
		
		Team liverpool = new Team("LiverPool");
		Player player1 = new Player("Jhone Doe");
		Player player2 = new Player("Alice");
		Player player3 = new Player("Grace");

		liverpool.getPlayers().add(player1);
		liverpool.getPlayers().add(player2);
		liverpool.getPlayers().add(player3);
		
		System.out.println("Player of ManU");
		for(final Player player:manU.getPlayers()) {
			System.out.println(player);
		}
		
		System.out.println("Player of LiverPool");
		for(final Player player:liverpool.getPlayers()) {
			System.out.println(player);
		}
		
		
		System.out.println("Player 3's Name : "+ player3);
	}

}
