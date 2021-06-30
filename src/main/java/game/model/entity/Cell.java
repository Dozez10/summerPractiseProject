package game.model.entity;

import game.model.placing.Coordinate;

public class Cell {
    private Coordinate coordinate;
    private String defImage;
    public Cell(int x,int y,String defaultImage){
        this.coordinate = new Coordinate(x,y);
        this.defImage = defaultImage;
    }
    public Cell(int x,int y){
        this.coordinate = new Coordinate(x,y);
        this.defImage = "-";
    }
    public Cell(Coordinate coordinate,String defaultImage){
        this.coordinate = coordinate;
        this.defImage = defaultImage;
    }
    public Cell(Coordinate coordinate){
        this.coordinate = coordinate;
        this.defImage = "-";
    }
    public Cell(){
        this.coordinate = new Coordinate();
        this.defImage = "-";
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public String getDefImage() {
        return defImage;
    }

    public void setDefImage(String defImage) {
        this.defImage = defImage;
    }
}
