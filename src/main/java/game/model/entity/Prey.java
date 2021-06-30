package game.model.entity;

import game.model.placing.Coordinate;

public class Prey extends Cell {
    private int  timeToReproduce;
    public Prey(int timeToReproduce, Coordinate coordinate, String defaultImage ){
        super(coordinate, defaultImage);
        this.timeToReproduce = timeToReproduce;
    }
    public Prey(int timeToReproduce, int x,int y, String defaultImage ){
        super(x,y, defaultImage);
        this.timeToReproduce = timeToReproduce;
    }
    public Prey(int timeToReproduce, int x,int y){
        super(x,y, "F");
        this.timeToReproduce = timeToReproduce;
    }
    public Prey(int timeToReproduce,Coordinate coordinate){
        super(coordinate ,"F");
        this.timeToReproduce = timeToReproduce;
    }
    public Prey(int timeToReproduce){
        super(0,0,"F");
        this.timeToReproduce = timeToReproduce;
    }

    public int getTimeToReproduce() {
        return timeToReproduce;
    }

    public void setTimeToReproduce(int timeToReproduce) {
        this.timeToReproduce = timeToReproduce;
    }

    public String getDefaultImage() {
        return super.getDefImage();
    }

    public void setDefaultImage(String defaultImage) {
       super.setDefImage(defaultImage);
    }
}
