package game.model.entity;

import game.model.placing.Coordinate;

import java.util.HashMap;
import java.util.List;

public class Cell implements Cloneable {
    private Coordinate coordinate;
    private static String defImage;
    private Ocean ocean;
    private HashMap<Integer, List<Cell>> cellMap;
    private boolean gotProcessed;
    static {
        defImage = "-";
    }
    public Cell(Ocean ocean,int x,int y){
        this.ocean = ocean;
        this.cellMap = getOcean().getCellTable();
        this.coordinate = new Coordinate(x,y);
        this.gotProcessed = false;
    }
    public Cell(Ocean ocean,Coordinate coordinate){
        this.ocean = ocean;
        this.cellMap = getOcean().getCellTable();
        this.coordinate = coordinate;
        this.gotProcessed = false;
    }
    public Cell(Ocean ocean){
        this.ocean = ocean;
        this.cellMap = getOcean().getCellTable();
        this.coordinate = new Coordinate();
        this.gotProcessed = false;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Cell cell = (Cell) super.clone();
        cell.setCoordinate(new Coordinate(coordinate.getX(),coordinate.getY()));
        cell.setGotProcessed(gotProcessed);
        return cell;

    }

    public Coordinate getCoordinate() {
        return coordinate;
    }
    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }
    public String getDefImage() {
        return Cell.defImage;
    }
    public void setDefImage(String defImage) {
        Cell.defImage = defImage;
    }

    public void process() {
    }

    public Ocean getOcean() {
        return ocean;
    }

    public void setOcean(Ocean ocean) {
        this.ocean = ocean;
    }

    public HashMap<Integer, List<Cell>> getCellMap() {
        return cellMap;
    }

    public void setCellMap(HashMap<Integer, List<Cell>> cellMap) {
        this.cellMap = cellMap;
    }

    public boolean isGotProcessed() {
        return gotProcessed;
    }

    public void setGotProcessed(boolean gotProcessed) {
        this.gotProcessed = gotProcessed;
    }
}
