package game.model.entity;


import game.util.HelperInterpreter;
import game.util.IValidatable;
import game.util.OceanValidator;
import java.util.*;


public class Ocean {
    private static final int MAXROWS = 25;
    private static final int MAXCOLS = 75;
    private static final int MAXITERATIONS = 1000;
    private int numOfPredators;
    private int changeableNumOfPredators;
    private int timeToReproduce;
    private int numOfPreys;
    private int changeableNumOfPrey;
    private int timeToFeed;
    private int numOfObstacles;
    private int numOfIteration;
    private int size;
    private int cellsNum;
    private int rowsNum;
    private int colsNum;
    private boolean isValid = false;
    private boolean isValidated = false;
    private HashMap<Integer, List<Cell>> cellTable = new HashMap<>();
    private static final IValidatable<Ocean> oceanIValidatable;

    static {
        oceanIValidatable = new OceanValidator();
    }

    public boolean isValid() {
        if (!isValidated) {
            isValid = oceanIValidatable.validate(this);
            isValidated = true;
        }
        return isValid;
    }
    public Ocean(){
        setDefaultValues();
    }
    public Ocean(int rows, int cols, int preyNum, int predNum, int obstaclesNum, int itrNum,int timeToReproduce,int timeToFeed) {
        this.size = rows * cols;
        setFields(rows, cols, preyNum, predNum, obstaclesNum, itrNum,timeToReproduce,timeToFeed);
    }

    public Ocean(int size, int preyNum, int predNum, int obstaclesNum, int itrNum,int timeToReproduce,int timeToFeed) {
        this.size = size;
        List<Integer> rAc = HelperInterpreter.findClosestDivisors(size);
        setFields(rAc.get(0), rAc.get(1), preyNum, predNum, obstaclesNum, itrNum,timeToReproduce,timeToFeed);
    }

    public void setFields(int rows, int cols, int preyNum, int predNum, int obstaclesNum, int itrNum,int timeToReproduce,int timeToFeed) {
        this.rowsNum = rows;
        this.colsNum = cols;
        this.numOfPreys = preyNum;
        this.timeToFeed = timeToFeed;
        this.timeToReproduce = timeToReproduce;
        this.changeableNumOfPredators = predNum;
        this.changeableNumOfPrey = preyNum;
        this.numOfPredators = predNum;
        this.numOfObstacles = obstaclesNum;
        this.numOfIteration = itrNum;
        this.cellsNum = this.size - (this.numOfPreys + this.numOfPredators + this.numOfObstacles);
    }

    public void setDefaultValues() {
        this.rowsNum = 75;
        this.colsNum = 25;
        this.numOfPreys = 150;
        this.changeableNumOfPrey = this.numOfPreys;
        this.numOfPredators = 20;
        this.changeableNumOfPredators = this.numOfPredators;
        this.numOfObstacles = 70;
        this.numOfIteration = 500;
        this.timeToReproduce = 15;
        this.timeToFeed = 6;
        this.size = 1875;
        this.cellsNum = 1635;
    }

    public static int getMAXROWS() {
        return MAXROWS;
    }

    public static int getMAXCOLS() {
        return MAXCOLS;
    }

    public static int getMAXITERATIONS() {
        return MAXITERATIONS;
    }

    public int getNumOfPredators() {
        return numOfPredators;
    }

    public void setNumOfPredators(int numOfPredators) {
        this.numOfPredators = numOfPredators;
        isValidated = false;
    }

    public int getNumOfPreys() {
        return numOfPreys;
    }

    public void setNumOfPreys(int numOfPreys) {
        this.numOfPreys = numOfPreys;
        isValidated = false;
    }

    public int getNumOfObstacles() {
        return numOfObstacles;
    }

    public void setNumOfObstacles(int numOfObstacles) {
        this.numOfObstacles = numOfObstacles;
        isValidated = false;
    }

    public int getNumOfIteration() {
        return numOfIteration;
    }

    public void setNumOfIteration(int numOfIteration) {
        this.numOfIteration = numOfIteration;
        isValidated = false;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
        isValidated = false;
    }

    public int getCellsNum() {
        return cellsNum;
    }

    public void setCellsNum(int cellsNum) {
        this.cellsNum = cellsNum;
        isValidated = false;
    }

    public int getRowsNum() {
        return rowsNum;
    }

    public void setRowsNum(int rowsNum) {
        this.rowsNum = rowsNum;
        isValidated = false;
    }

    public int getColsNum() {
        return colsNum;
    }

    public void setColsNum(int colsNum) {
        this.colsNum = colsNum;
        isValidated = false;
    }



    public HashMap<Integer, List<Cell>> getCellTable() {
        return cellTable;
    }

    public void setCellTable(HashMap<Integer, List<Cell>> cellTable) {
        this.cellTable = cellTable;
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

    public int getChangeableNumOfPredators() {
        return changeableNumOfPredators;
    }

    public void setChangeableNumOfPredators(int changeableNumOfPredators) {
        this.changeableNumOfPredators = changeableNumOfPredators;
    }

    public int getChangeableNumOfPrey() {
        return changeableNumOfPrey;
    }

    public void setChangeableNumOfPrey(int changeableNumOfPrey) {
        this.changeableNumOfPrey = changeableNumOfPrey;
    }
}
