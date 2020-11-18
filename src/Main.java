public class Main {

    public static void main(String[] args) {
	    Input input = new Input();
	    Error error = new Error();
	    Deck deck = new Deck();
	    deck.setDeck();
	    Player firstPlayer;
	    Player secondPlayer;
	    Game game = new Game();
	    String firstName;
	    String secondName;
	    Team.teamName firstTeamName;
		Team.teamName secondTeamName;
	    System.out.println("please enter the first player name:");
	    firstName = input.getInput();
		System.out.println("please enter the second player name:");
		secondName = input.getInput();
		System.out.println("please select first Player team:\nALLIED\nAXIS");
		firstTeamName = Team.teamName.valueOf(input.getInput());
		if(firstTeamName == Team.teamName.ALLIED)
			secondTeamName = Team.teamName.AXIS;
		else
			secondTeamName = Team.teamName.ALLIED;
		firstPlayer = new Player(firstTeamName,firstName,true,deck);
		secondPlayer = new Player(secondTeamName,secondName,true,deck);
		System.out.println("welcome to Memoir 44");
		String select;
		while(true){
			System.out.println("1.start new game");
			System.out.println("2.change players info");
			System.out.println("3.how to play");
			System.out.println("4.about us");
			System.out.println("5.exit");
			select = input.getInput();
			switch (select){
				case "1":
					game.init(firstPlayer,secondPlayer);
					game.printBoard();
					System.out.println(firstName + " please insert your troops");
					game.insertion(firstPlayer);
					System.out.println("now " + secondName + " please insert your troops");
					game.insertion(secondPlayer);
					int i = 0;
					int num;
					int counter;
					while(firstPlayer.getScore() < 6 && secondPlayer.getScore() < 6){
						System.out.println(firstName + " "  + firstPlayer.getScore());
						System.out.println(secondName + " "  + secondPlayer.getScore());
						game.printBoard();
						System.out.println(game.getCurrentTurn().getName() + " turn");
						System.out.println("which of these cards do you want to use:");
						game.getCurrentTurn().getTeam().printCards();
						counter = game.getCurrentTurn().getTeam().getCardType();
						while (i < counter){
							System.out.println("select a troop or just enter 0 to continue");
							game.getCurrentTurn().getTeam().printTroops();
							num = input.getInteger();
							if(num == 0)
								continue;
							game.getCurrentTurn().getTeam().addToSelect(
									game.getCurrentTurn().getTeam().getTroops().get(num - 1));
							i++;
						}
						i = 0;
						while(i < game.getCurrentTurn().getTeam().getTroopsInsertion().size()){
							System.out.println("select target for"
									+ game.getCurrentTurn().getTeam().getTroopsInsertion().get(i).TroopToString() +
									"or just enter 0");
							select = input.getInput();
							if(select.equals("0"))
								continue;
							Point temp = game.getBoard().getPoint(select.charAt(0),select.charAt(1));
							game.getCurrentTurn().getTeam().getTroopsInsertion().get(i).attack(temp);
							i++;
						}
						firstPlayer.scoreIncrease(13 - secondPlayer.getTeam().getTroops().size());
						secondPlayer.scoreIncrease(13 - firstPlayer.getTeam().getTroops().size());
						if(game.getBoard().getPoint(8,22).getTroop().getTeam().getName() == Team.teamName.ALLIED)
							if(firstPlayer.getTeam().getName() == Team.teamName.ALLIED)
								firstPlayer.scoreIncrease(1);
							else
								secondPlayer.scoreIncrease(1);
						if(game.getBoard().getPoint(2,0).getTroop().getTeam().getName() == Team.teamName.AXIS)
							if(firstPlayer.getTeam().getName() == Team.teamName.AXIS)
								firstPlayer.scoreIncrease(1);
							else
								secondPlayer.scoreIncrease(1);
					}
					break;
				case "2":
					System.out.println("enter new name for first Player");
					firstName = input.getInput();
					firstPlayer.setName(firstName);
					System.out.println("enter new name for first Player");
					secondName = input.getInput();
					secondPlayer.setName(secondName);
					System.out.println("done!");
					break;
				case "3":
					System.out.println("you can learn a lot about Memoir in this link" +
							"\nhttps://www.daysofwonder.com/memoir44/en/other-expansions/guide/");
					break;
				case "4":
					System.out.println("I am Arman Hatami this is my very first game we hope you enjoy it\n" +
							"contact me : armanhatami.aut@gmail.com");
					break;
				case "5":
					System.out.println("have a nice day! come back soon");
					return;
			}
		}
    }
}
