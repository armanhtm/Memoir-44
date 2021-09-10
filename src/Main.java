/**
 * @author Arman Hatami
 * @version 1.0
 * the main class which i used to design my game menu
 */
public class Main {

    public static void main(String[] args) {
	    Input input = new Input();
	    Error error = new Error();
	    Deck deck = new Deck();
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
						counter = game.getCurrentTurn().getTeam().getCardType(deck);
						if(counter == 5) {
							counter = 3;
						}
						while (i < counter){
							System.out.println("select a troop or just enter -1 to continue");
							game.getCurrentTurn().getTeam().troops();
							num = input.getInteger();
							if(num == -1) {
								i++;
								continue;
							}
							if(game.getCurrentTurn().getTeam().getTroopsInsertion().size() != 0)
							{
								if(game.getCurrentTurn().getTeam().getTroopsInsertion().get(0) instanceof Infantry)
									if(!(game.getCurrentTurn().getTeam().getTroopsInsertion().get(0) instanceof Infantry)){
										error.repetitive();
										continue;
									}
								if(game.getCurrentTurn().getTeam().getTroopsInsertion().get(0) instanceof Cannon)
									if(!(game.getCurrentTurn().getTeam().getTroopsInsertion().get(0) instanceof Cannon)){
										error.repetitive();
										continue;
									}
								if(game.getCurrentTurn().getTeam().getTroopsInsertion().get(0) instanceof TankAxis
										|| game.getCurrentTurn().getTeam().getTroopsInsertion().get(0) instanceof TankAllied)
									if(!(game.getCurrentTurn().getTeam().getTroopsInsertion().get(0) instanceof TankAllied)
											&& !(game.getCurrentTurn().getTeam().getTroopsInsertion().get(0) instanceof TankAxis)){
										error.repetitive();
										continue;
									}

							}
							game.getCurrentTurn().getTeam().addToSelect(
									game.getCurrentTurn().getTeam().getTroops().get(num - 1));
							i++;
						}
						i = 0;
						while(i < game.getCurrentTurn().getTeam().getTroopsInsertion().size()){
							System.out.println("enter direction for moving "+
									game.getCurrentTurn().getTeam().getTroopsInsertion().get(i).TroopToString() +
									" or just enter -1");
							select = input.getInput();
							if(select.equals("-1")) {
								i++;
								continue;
							}
							game.getCurrentTurn().getTeam().getTroopsInsertion().get(i).Move(select,game.getBoard());
							i++;
						}
						game.printBoard();
						i = 0;
						while(i < game.getCurrentTurn().getTeam().getTroopsInsertion().size()){
							System.out.println("select target for "
									+ game.getCurrentTurn().getTeam().getTroopsInsertion().get(i).TroopToString() +
									" or just enter -1");
							int xCoordinate = input.getInteger();
							int yCoordinate = input.getInteger();
							if(xCoordinate == -1) {
								i++;
								continue;
							}
							if(game.getBoard().getPoint(xCoordinate,yCoordinate).getTroop() == null) {
								error.EmptyAttack();
								continue;
							}
							if(game.getCurrentTurn().getTeam().getTroopsInsertion().get(i)
									.attack(game.getBoard().getPoint(xCoordinate,yCoordinate)))
								game.getCurrentTurn().scoreIncrease(1);
							i++;
						}
						game.getCurrentTurn().getTeam().getTroopsInsertion().clear();
						game.changeTurn();
						System.out.println("press enter to continue");
						input.getInput();
						if(game.getPlayers()[0].getScore() == 5)
							if(game.getPlayers()[0].getTeam().getName() == Team.teamName.AXIS) {
								if (game.getBoard().getPoint(8, 22).getTroop().getTeam().getName() == Team.teamName.AXIS) {
									game.setStatus(Game.GameStatus.AXIS_WIN);
									game.getPlayers()[0].scoreIncrease(1);
								}
							}
						    else {
								if (game.getBoard().getPoint(2, 0).getTroop().getTeam().getName() == Team.teamName.ALLIED) {
									game.setStatus(Game.GameStatus.ALLIED_WIN);
									game.getPlayers()[0].scoreIncrease(1);
								}
							}
						if(game.getPlayers()[1].getScore() == 5)
							if(game.getPlayers()[1].getTeam().getName() == Team.teamName.AXIS) {
								if (game.getBoard().getPoint(8, 22).getTroop().getTeam().getName() == Team.teamName.AXIS) {
									game.setStatus(Game.GameStatus.AXIS_WIN);
									game.getPlayers()[1].scoreIncrease(1);
								}
							}
							else {
								if (game.getBoard().getPoint(2, 0).getTroop().getTeam().getName() == Team.teamName.ALLIED) {
									game.setStatus(Game.GameStatus.ALLIED_WIN);
									game.getPlayers()[1].scoreIncrease(1);
								}
							}
					}
					System.out.println(firstName + " "  + firstPlayer.getScore());
					System.out.println(secondName + " "  + secondPlayer.getScore());
					System.out.println("Result : " + game.getGameStatus().name());
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
