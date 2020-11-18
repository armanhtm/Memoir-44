public class Player {
    private Team team;
    private String name;
    private int score = 0;
    public boolean humanPlayer;
    public Player(Team.teamName teamName,String name,boolean human,Deck deck){
        team = new Team(teamName,deck);
        this.name = name;
        this.humanPlayer = human;
    }

    public Team getTeam() {
        return team;
    }

    public String getName() {
        return name;
    }

    public boolean isHumanPlayer() {
        return humanPlayer;
    }

    public int getScore() {
        return score;
    }
    public void scoreIncrease(int count){
        score += count;
    }
    public void scoreDecrease(){
        score --;
    }

    public void setName(String name) {
        this.name = name;
    }
}
