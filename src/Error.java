public class Error {
    public void cardError(){
        System.out.println("invalid card name!!! try again");
    }
    public void moveError(){
        System.out.println("this movements are not valid!!! try again");
    }
    public void farError(){
        System.out.println("target is too far no chance!");
    }
    public void badLuck(){
        System.out.println("bad luck maybe next round");
    }
    public void attackError(){
        System.out.println("sorry you can not attack this round");
    }
    public void stuck(){
        System.out.println("you are stuck in Jungle ,wait for next round! ");
    }
    public void indexError(){
        System.out.println("index out of bound");
    }
    public void property(){
        System.out.println("sorry you can not move a troop which is not yours !!!");
    }
    public void coordinateError(){
        System.out.println("you entered an invalid coordinate! try again");
    }
}
