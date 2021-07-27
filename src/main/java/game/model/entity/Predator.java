package game.model.entity;

import game.model.placing.Coordinate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Predator extends Prey  {
    private int timeToFeed;
    private int changeableTimeToFeed;
    private static String defImage;
    static {
        defImage = "s";
    }
    public Predator(Ocean ocean,int timeToReproduce,int timeToFeed, Coordinate coordinate ){
        super(ocean,timeToReproduce,coordinate);
        this.timeToFeed = timeToFeed;
        this.changeableTimeToFeed = timeToFeed;
    }
    public Predator(Ocean ocean,int timeToReproduce,int timeToFeed , int x,int y ){
        super(ocean,timeToReproduce,x,y);
        this.timeToFeed = timeToFeed;
        this.changeableTimeToFeed = timeToFeed;
    }
    public Predator(Ocean ocean,int timeToReproduce,int timeToFeed){
        super(ocean,timeToReproduce);
        this.timeToFeed = timeToFeed;
        this.changeableTimeToFeed = timeToFeed;
    }
    public Predator(Ocean ocean){
        this(ocean,20,10);
    }
    public int getTimeToReproduce() {
        return super.getTimeToReproduce();
    }

    public void setTimeToReproduce(int timeToReproduce) {
     super.setTimeToReproduce(timeToReproduce);
    }

    public int getTimeToFeed() {
        return timeToFeed;
    }

    public void setTimeToFeed(int timeToFeed) {
        this.timeToFeed = timeToFeed;
    }

    public String getDefImage() {
        return Predator.defImage;
    }

    public void setDefImage(String defaultImage) {
       Predator.defImage = defaultImage;
    }

    @Override
    public void setCoordinate(Coordinate coordinate) {
        super.setCoordinate(coordinate);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Predator predator = (Predator) super.clone();
        predator.setTimeToFeed(timeToFeed);
        predator.setChangeableTimeToReproduce(timeToFeed);
        return predator;
    }

    @Override
    public Coordinate getCoordinate() {
        return super.getCoordinate();
    }
    public Ocean getOcean(){
        return  super.getOcean();
    }
    public void setOcean(Ocean ocean){
        super.setOcean(ocean);
    }
    @Override
    public void process() {
        HashMap<Integer, List<Cell>> cellMap = getCellMap();
        Coordinate coordinate = getCoordinate();
        if(getChangeableTimeToFeed()==0){
         Cell cellNew = new Cell(getOcean(),coordinate);
         cellMap.get(coordinate.getY()).set(coordinate.getX(),cellNew);
        }
        else {
            Cell cell = findRandomFreeCell(coordinate, cellMap);
            if(cell!=null){
                cellMap.get(cell.getCoordinate().getY()).set(cell.getCoordinate().getX(),this);
                setCoordinate(cell.getCoordinate());
                if(getChangeableTimeToReproduce()==0){
                    Predator predator = new Predator(getOcean(),getTimeToReproduce(),getTimeToFeed(),coordinate);
                    cellMap.get(coordinate.getY()).set(coordinate.getX(),predator);
                    setChangeableTimeToReproduce(getTimeToReproduce());
                    getOcean().setChangeableNumOfPredators(getOcean().getNumOfPredators()+1);
                }
                else{
                    Cell cell1 = new Cell(getOcean(),coordinate);
                    cellMap.get(coordinate.getY()).set(coordinate.getX(),cell1);
                    setChangeableTimeToReproduce(getChangeableTimeToReproduce()-1);
                }

                if(cell.getDefImage().equals("f")){
                    setChangeableTimeToFeed(getTimeToFeed());
                    getOcean().setChangeableNumOfPrey(getOcean().getChangeableNumOfPrey()-1);
                }
                else{
                   setChangeableTimeToFeed(getChangeableTimeToFeed()-1);
                }
            }
          else {
                setChangeableTimeToFeed(getChangeableTimeToFeed()-1);
            }
        }


    }
    public Cell findRandomFreeCell(Coordinate coordinate,HashMap<Integer,List<Cell>> cellMap){
        List<Cell> cellListToChoose = new ArrayList<>();
        List<Cell> preyList = new ArrayList<>();
        //up
        if (cellMap.containsKey(coordinate.getY() + 1)) {
            try {
                Cell cell = cellMap.get(coordinate.getY() + 1).get(coordinate.getX());
                if (cell != null) {
                    if (cell.getDefImage().equals("-")) cellListToChoose.add(cell);
                    if (cell.getDefImage().equals("f")) preyList.add(cell);
                }
            } catch (IndexOutOfBoundsException | NullPointerException e) {

            }
        }
        //left
        try {
            Cell cell = cellMap.get(coordinate.getY()).get(coordinate.getX() - 1);
            if (cell != null) {
                if (cell.getDefImage().equals("-")) cellListToChoose.add(cell);
                if (cell.getDefImage().equals("f")) preyList.add(cell);
            }
        } catch (IndexOutOfBoundsException | NullPointerException e) {

        }
        //right
        try {
            Cell cell = cellMap.get(coordinate.getY()).get(coordinate.getX() + 1);
            if (cell != null) {
                if (cell.getDefImage().equals("-")) cellListToChoose.add(cell);
                if (cell.getDefImage().equals("f")) preyList.add(cell);
            }
        } catch (IndexOutOfBoundsException | NullPointerException e) {

        }
        //down
        if (cellMap.containsKey(coordinate.getY() - 1)) {
            try {
                Cell toInsertCell = cellMap.get(coordinate.getY() - 1).get(coordinate.getX());
                if (toInsertCell != null) {
                    if (toInsertCell.getDefImage().equals("-")) cellListToChoose.add(toInsertCell);
                    if (toInsertCell.getDefImage().equals("f")) preyList.add(toInsertCell);
                }
            } catch (IndexOutOfBoundsException | NullPointerException e) {

            }
        }
        if (preyList.size() > 0)
            return preyList.get(ThreadLocalRandom.current().nextInt(0, preyList.size()));
        if (cellListToChoose.size() > 0)
            return cellListToChoose.get(ThreadLocalRandom.current().nextInt(0, cellListToChoose.size()));
        return null;
    }

@Override
    public boolean isGotProcessed(){
        return super.isGotProcessed();
}
@Override
    public void setGotProcessed(boolean isProcessed){
        super.setGotProcessed(isProcessed);
}

    public int getChangeableTimeToFeed() {
        return changeableTimeToFeed;
    }

    public void setChangeableTimeToFeed(int changeableTimeToFeed) {
        this.changeableTimeToFeed = changeableTimeToFeed;
    }
}
