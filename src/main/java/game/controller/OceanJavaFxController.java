package game.controller;

import game.model.entity.*;
import game.model.placing.Coordinate;
import game.util.OceanValidator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OceanJavaFxController {
    private Ocean ocean;
    private OceanValidator oceanValidator;
    public OceanJavaFxController(Ocean ocean){
        this.ocean = ocean;
        this.oceanValidator = new OceanValidator();
    }

    public boolean isValid(){
        return oceanValidator.validate(this.ocean);
    }
    public void init() throws CloneNotSupportedException {
        List<Cell> cellList = new ArrayList<>();
        insertElementToListExactAmountOfTimes(cellList, new Predator(ocean, ocean.getTimeToReproduce(),ocean.getTimeToFeed()), ocean.getNumOfPredators());
        insertElementToListExactAmountOfTimes(cellList, new Prey(ocean,ocean.getTimeToReproduce()) , ocean.getNumOfPreys());
        insertElementToListExactAmountOfTimes(cellList, new Obstacle(ocean), ocean.getNumOfObstacles());
        insertElementToListExactAmountOfTimes(cellList, new Cell(ocean), ocean.getCellsNum());
        Collections.shuffle(cellList);
        IntStream.range(0,ocean.getRowsNum()).forEach(itr->IntStream.range(itr*ocean.getColsNum(),itr*ocean.getColsNum()+ocean.getColsNum()).forEach(index->cellList.get(index).setCoordinate(new Coordinate(index%ocean.getColsNum(),itr))));
        IntStream.range(0, ocean.getRowsNum()).forEach(e -> ocean.getCellTable().put(e, cellList.stream().skip((long) e * ocean.getColsNum()).limit(ocean.getColsNum()).collect(Collectors.toList())));
    }
    private int insertElementToListExactAmountOfTimes(List<Cell> list, Cell element, int times) throws CloneNotSupportedException {
        int count = 0;
        for (int i = 0; i < times; i++) {
            list.add((Cell) element.clone());
            count++;
        }

        return count;
    }
    public void toProcessAllCells() {

        for (int i = 0; i < ocean.getRowsNum(); i++) {
            ocean.getCellTable().get(i).forEach(elm->{
                if(!elm.isGotProcessed()) {
                    elm.process();
                    elm.setGotProcessed(true);
                }
            });
        }
    }
    public void setProcessedStatusToFalse(){
        for(int i = 0; i<ocean.getRowsNum();i++){
            ocean.getCellTable().get(i).forEach(elm ->{
                elm.setGotProcessed(false);
            });
        }
    }
    public boolean checkForOneEntity(){
        return ocean.getChangeableNumOfPredators()==0||ocean.getChangeableNumOfPrey()==0;
    }
}
