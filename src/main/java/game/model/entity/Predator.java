package game.model.entity;

import game.model.placing.Coordinate;

public class Predator extends Cell  {
    private int  timeToReproduce;
    private int timeToFeed;
    public Predator(int timeToReproduce,int timeToFeed, Coordinate coordinate, String defaultImage ){
        super(coordinate, defaultImage);
        this.timeToReproduce = timeToReproduce;
        this.timeToFeed = timeToFeed;
    }
    public Predator(int timeToReproduce,int timeToFeed , int x,int y, String defaultImage ){
        super(x,y, defaultImage);
        this.timeToReproduce = timeToReproduce;
        this.timeToFeed = timeToFeed;
    }
    public Predator(int timeToReproduce,int timeToFeed , int x,int y){
        super(x,y, "S");
        this.timeToReproduce = timeToReproduce;
        this.timeToFeed = timeToFeed;
    }
    public Predator(int timeToReproduce,int timeToFeed,Coordinate coordinate){
        super(coordinate ,"S");
        this.timeToReproduce = timeToReproduce;
        this.timeToFeed = timeToFeed;
    }
    public Predator(int timeToReproduce,int timeToFeed){
        super(0,0,"S");
        this.timeToReproduce = timeToReproduce;
        this.timeToFeed = timeToFeed;
    }

    public int getTimeToReproduce() {
        return timeToReproduce;
    }

    public void setTimeToReproduce(int timeToReproduce) {
        this.timeToReproduce = timeToReproduce;
    }

    public int getTimeToFeed() {
        return timeToFeed;
    }

    public void setTimeToFeed(int timeToFeed) {
        this.timeToFeed = timeToFeed;
    }

    public String getDefaultImage() {
        return super.getDefImage();
    }

    public void setDefaultImage(String defaultImage) {
        super.setDefImage(defaultImage);
    }
}
