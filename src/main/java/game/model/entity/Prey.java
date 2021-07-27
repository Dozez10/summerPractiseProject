package game.model.entity;

import game.model.placing.Coordinate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Prey extends Cell {
    private int  timeToReproduce;
    private int changeableTimeToReproduce;
    private static String defImage;
    static {
        defImage = "f";
    }
    public Prey(Ocean ocean,int timeToReproduce, Coordinate coordinate){
        super(ocean,coordinate);
        this.timeToReproduce = timeToReproduce;
        this.changeableTimeToReproduce = timeToReproduce;
    }
    public Prey(Ocean ocean,int timeToReproduce, int x,int y){
        super(ocean,x,y);
        this.timeToReproduce = timeToReproduce;
        this.changeableTimeToReproduce = timeToReproduce;
    }

    public Prey(Ocean ocean,int timeToReproduce){
        super(ocean);
        this.timeToReproduce = timeToReproduce;
        this.changeableTimeToReproduce = timeToReproduce;
    }
    public Prey(Ocean ocean){
       this(ocean,15);
    }
    public int getTimeToReproduce() {
        return timeToReproduce;
    }

    public void setTimeToReproduce(int timeToReproduce) {
        this.timeToReproduce = timeToReproduce;
    }

    public String getDefImage() {
        return Prey.defImage;
    }

    public void setDefImage(String defaultImage) {
      Prey.defImage = defaultImage;
    }

    @Override
    public void setCoordinate(Coordinate coordinate) {
        super.setCoordinate(coordinate);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Prey prey = (Prey)super.clone();
        prey.setTimeToReproduce(timeToReproduce);
        prey.setChangeableTimeToReproduce(timeToReproduce);
        return prey;
    }


    @Override
    public Coordinate getCoordinate() {
        return super.getCoordinate();
    }
public Ocean getOcean(){
        return  super.getOcean();
}
public void setOcean (Ocean ocean){
        super.setOcean(ocean);
}
public HashMap<Integer,List<Cell>> getCellTable(){
        return super.getCellMap();
}
public void setCellMap(HashMap<Integer,List<Cell>> cellMap){
        super.setCellMap(cellMap);
}
    @Override
    public void process() {
        HashMap<Integer,List<Cell>> cellMap = getCellMap();
        Coordinate coordinate = getCoordinate();
        Cell cell = findRandomFreeCell(coordinate,cellMap);
        if(cell != null){
            cellMap.get(cell.getCoordinate().getY()).set(cell.getCoordinate().getX(),this);
            setCoordinate(cell.getCoordinate());
            if(changeableTimeToReproduce==0){
                Prey prey = new Prey(getOcean(),getTimeToReproduce(),coordinate);
                cellMap.get(coordinate.getY()).set(coordinate.getX(),prey);
                changeableTimeToReproduce = timeToReproduce;
                getOcean().setChangeableNumOfPrey(getOcean().getChangeableNumOfPredators()+1);
            }
            else{
                Cell cellToReplace = new Cell(getOcean(),coordinate);
                cellMap.get(coordinate.getY()).set(coordinate.getX(),cellToReplace);
                changeableTimeToReproduce--;
            }
        }

    }
    public Cell findRandomFreeCell(Coordinate coordinate,HashMap<Integer,List<Cell>> cellMap){
        List<Cell> cellListToChoose = new ArrayList<>();
        //up
        if (cellMap.containsKey(coordinate.getY() + 1)) {
            try { Cell cell = cellMap.get(coordinate.getY() + 1).get(coordinate.getX());
                if (cell != null && cell.getDefImage().equals("-")) cellListToChoose.add(cell);
            } catch (IndexOutOfBoundsException | NullPointerException e) {

            }
        }
        //left
        try { Cell cell = cellMap.get(coordinate.getY()).get(coordinate.getX() - 1);
            if (cell != null && cell.getDefImage().equals("-")) cellListToChoose.add(cell);
        } catch (IndexOutOfBoundsException | NullPointerException e) {

        }
        //right
        try { Cell cell = cellMap.get(coordinate.getY()).get(coordinate.getX() + 1);
            if (cell != null && cell.getDefImage().equals("-")) cellListToChoose.add(cell);
        } catch (IndexOutOfBoundsException | NullPointerException e) {

        }
        //down
        if (cellMap.containsKey(coordinate.getY() - 1)) {
            try { Cell toInsertCell = cellMap.get(coordinate.getY() - 1).get(coordinate.getX());
                if (toInsertCell != null && toInsertCell.getDefImage().equals("-")) cellListToChoose.add(toInsertCell);
            } catch (IndexOutOfBoundsException | NullPointerException e) {

            }
        }
        if (cellListToChoose.size() > 0)
            return cellListToChoose.get(ThreadLocalRandom.current().nextInt(0, cellListToChoose.size()));
        return null;
    }
    public boolean isGotProcessed() {
        return super.isGotProcessed();
    }

    public void setGotProcessed(boolean gotProcessed) {
        super.setGotProcessed(gotProcessed);
    }

    public int getChangeableTimeToReproduce() {
        return changeableTimeToReproduce;
    }

    public void setChangeableTimeToReproduce(int changeableTimeToReproduce) {
        this.changeableTimeToReproduce = changeableTimeToReproduce;
    }
}
