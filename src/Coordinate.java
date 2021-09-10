/**
 * @author Arman Hatami
 * @version 1.0
 * coordinate class to modify movements and store x and y of location
 */
public class Coordinate {
    private int x;
    private int y;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public void Right(){
        y += 2;
    }
    public void Left(){
       y -= 2;
    }
    public void upRight(){
       y ++;
       x --;
    }
    public void upLeft(){
        x --;
        y --;
    }
    public void downRight(){
        x ++;
        y ++;
    }
    public void downLeft(){
        x ++;
        y --;
    }

    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(!(obj instanceof Coordinate))
            return false;
        else {
            Coordinate temp = (Coordinate) obj;
            return temp.getX() == this.getX() && temp.getY() == this.getY();
        }
    }
}
