import java.util.ArrayList;

public class Team {
    teamName name;
    ArrayList<Troop> troops;
    enum teamName{
        AXIS,
        ALLIED
    }
    public teamName getName() {
        return name;
    }

    public void setName(String name) {
        this.name = teamName.valueOf(name);
    }

    public ArrayList<Troop> getTroops() {
        return troops;
    }

    public void setTroops(ArrayList<Troop> troops) {
        this.troops = troops;
    }
}
