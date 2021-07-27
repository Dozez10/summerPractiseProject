package game.model.entity;

import game.model.placing.Coordinate;

public class Obstacle extends Cell {
    private static String defImage;
    static {
        defImage = "#";
    }
    public Obstacle(Ocean ocean,int x,int y){
       super(ocean,x,y);
    }
    public Obstacle(Ocean ocean,Coordinate coordinate){
       super(ocean,coordinate);
    }
    public Obstacle(Ocean ocean){
       super(ocean);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getDefImage() {
        return Obstacle.defImage;
    }

    @Override
    public Coordinate getCoordinate() {
        return super.getCoordinate();
    }

    @Override
    public void setCoordinate(Coordinate coordinate) {
        super.setCoordinate(coordinate);
    }
    @Override
    public void setDefImage(String defaultImage) {
        Obstacle.defImage = defaultImage;
    }
    public Ocean getOcean(){
        return  super.getOcean();
    }
    public void setOcean(Ocean ocean){
        super.setOcean(ocean);
    }
    @Override
    public boolean isGotProcessed(){
        return super.isGotProcessed();
    }
    @Override
    public void setGotProcessed(boolean isGotProcessed){
        super.setGotProcessed(isGotProcessed);
    }

}
