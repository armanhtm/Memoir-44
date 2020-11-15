import java.util.HashMap;

public class Point {
    private enum Type{
        VILLAGE,
        HILL,
        RIVER,
        SHELTER,
        JUNGLE
    }
    private Type type;
    private Troop troop;
    private HashMap<String,Point> exits;
    Coordinate coordinate;
    public Point(String type,int x,int y){
       coordinate = new Coordinate(x,y);
       this.type = Type.valueOf(type);
    }
    public void setTroop(Troop troop){
        this.troop = troop;
    }

    public Troop getTroop() {
        return troop;
    }
    public void setExits(String direction,Point point){
        exits.put(direction,point);
    }
}
