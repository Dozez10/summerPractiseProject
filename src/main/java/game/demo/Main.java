package game.demo;

import game.controller.OceanController;
import game.model.entity.Ocean;
import game.view.OceanInfoDisplay;


public class Main {

   static public  void runGame(OceanController oceanController) throws CloneNotSupportedException {
          oceanController.init();
          oceanController.connectedMethods();
          System.out.println("Game is over");
    }

    public static void main(String[] args) throws CloneNotSupportedException {

     Ocean ocean = new Ocean(3,10,1,1,0,15,15,4);
     OceanInfoDisplay oceanInfoDisplay = new OceanInfoDisplay(ocean);
     OceanController oceanController = new OceanController(ocean,oceanInfoDisplay);
     runGame(oceanController);
    }
}
