package game.controller;

import game.model.entity.*;
import game.model.placing.Coordinate;
import game.view.OceanInfoDisplay;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OceanController {
       private Ocean ocean;
       private OceanInfoDisplay view;
    public OceanController(Ocean ocean,OceanInfoDisplay oceanInfoDisplay){
           this.ocean = ocean;
           view = oceanInfoDisplay;
       }
       public void init() throws CloneNotSupportedException {
           if (!ocean.isValid()) ocean.setDefaultValues();
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
    public void connectedMethods(){
        view.display();
        for(int i = 0; i < ocean.getNumOfIteration();i++){
           if(checkForOneEntity())break;
            toProcessAllCells();
            setProcessedStatusToFalse();
            view.display();

        }
    }
    private void toProcessAllCells() {

        for (int i = 0; i < ocean.getRowsNum(); i++) {
            ocean.getCellTable().get(i).forEach(elm->{
                if(!elm.isGotProcessed()) {
                    elm.process();
                    elm.setGotProcessed(true);
                }
            });
        }
    }

    private void setProcessedStatusToFalse(){
        for(int i = 0; i<ocean.getRowsNum();i++){
            ocean.getCellTable().get(i).forEach(elm ->{
                elm.setGotProcessed(false);
            });
        }
    }
private boolean checkForOneEntity(){
         return ocean.getChangeableNumOfPredators()==0||ocean.getChangeableNumOfPrey()==0;
}
    public Ocean getOcean() {
        return ocean;
    }

    public void setOcean(Ocean ocean) {
        this.ocean = ocean;
    }

    public OceanInfoDisplay getView() {
        return view;
    }

    public void setView(OceanInfoDisplay view) {
        this.view = view;
    }
}
