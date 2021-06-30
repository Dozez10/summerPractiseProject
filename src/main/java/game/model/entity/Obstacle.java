package game.model.entity;

import game.model.placing.Coordinate;

public class Obstacle extends Cell {
    public Obstacle(int x,int y,String defaultImage){
       super(x,y,defaultImage);
    }
    public Obstacle(int x,int y){
       super(x,y,"#");
    }
    public Obstacle(Coordinate coordinate,String defaultImage){
     super(coordinate,defaultImage);
    }
    public Obstacle(Coordinate coordinate){
       super(coordinate,"#");
    }
    public Obstacle(){
       super(0,0,"#");
    }
    public String getDefaultImage() {
        return super.getDefImage();
    }

    public void setDefaultImage(String defaultImage) {
        super.setDefImage(defaultImage);
    }
}
