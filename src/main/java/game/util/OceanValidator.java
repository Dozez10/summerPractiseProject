package game.util;

import game.model.entity.Ocean;

public class OceanValidator implements IValidatable<Ocean> {
    @Override
    public boolean validate(Ocean ocean) {

        if (ocean.getRowsNum() > 25 || ocean.getColsNum() > 75 || ocean.getSize() < 2 || ocean.getNumOfIteration() <= 0 || ocean.getNumOfIteration() > 1000 || ocean.getNumOfPreys() <= 0 || ocean.getNumOfPredators() <= 0 || ocean.getCellsNum() < 0||ocean.getTimeToFeed()<=0||ocean.getTimeToReproduce()<=0)
            return false;

        return true;
    }
}
