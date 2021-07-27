package game.demo;

import game.controller.OceanController;
import game.controller.OceanJavaFxController;
import game.model.entity.Ocean;
import game.view.OceanInfoDisplay;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.EventType;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.swing.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class JavaFxApp extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        Label labelForGame = new Label("GAME");
        labelForGame.setLayoutX(300);
        labelForGame.setLayoutY(10);
        labelForGame.setStyle("-fx-font-size:40;-fx-text-fill: black;-fx-text-alignment: center;-fx-font-weight: bold");
        Label labelForGameParameters = new Label("GAME PARAMETERS");
        labelForGameParameters.setLayoutX(20);
        labelForGameParameters.setLayoutY(10);
        labelForGameParameters.setStyle("-fx-background-color: black;-fx-text-fill: white;-fx-min-width: 250px;-fx-text-alignment: center;-fx-font-weight: bold");
        Label rowsNumLabel = new Label("Input rows number between 0 and 75");
        TextField rowsNumTextField = new TextField();
        Label rowsNumErrorLabel = new Label("error msg");
        rowsNumErrorLabel.setVisible(false);
        rowsNumLabel.setLayoutX(20);
        rowsNumLabel.setLayoutY(45);
        rowsNumLabel.setStyle("-fx-font-style: italic;");
        rowsNumTextField.setLayoutX(20);
        rowsNumTextField.setLayoutY(75);
        rowsNumErrorLabel.setLayoutX(20);
        rowsNumErrorLabel.setLayoutY(115);
        rowsNumErrorLabel.setStyle("-fx-text-fill: red");

        Label colsNumLabel = new Label("Input columns number between 0 and 75");
        TextField columnsNumTextField = new TextField();
        Label columnsNumErrorLabel = new Label("error msg");
        columnsNumErrorLabel.setVisible(false);
        colsNumLabel.setLayoutX(20);
        colsNumLabel.setLayoutY(145);
        colsNumLabel.setStyle("-fx-font-style: italic");
        columnsNumTextField.setLayoutX(20);
        columnsNumTextField.setLayoutY(185);
        columnsNumErrorLabel.setLayoutX(20);
        columnsNumErrorLabel.setLayoutY(225);
        columnsNumErrorLabel.setStyle("-fx-text-fill: red");



        Label preyNumLabel = new Label("Input prey number");
        TextField preyNumTextField = new TextField();
        Label preyNumErrorLabel = new Label("error msg");
        preyNumErrorLabel.setVisible(false);
        preyNumLabel.setLayoutX(20);
        preyNumLabel.setLayoutY(255);
        preyNumLabel.setStyle("-fx-font-style: italic");
        preyNumTextField.setLayoutX(20);
        preyNumTextField.setLayoutY(295);
        preyNumErrorLabel.setLayoutX(20);
        preyNumErrorLabel.setLayoutY(335);
        preyNumErrorLabel.setStyle("-fx-text-fill: red");


        Label predatorNumLabel = new Label("Input predator number");
        TextField predatorNumTextField = new TextField();
        Label predatorNumErrorLabel = new Label("error msg");
        predatorNumErrorLabel.setVisible(false);
        predatorNumLabel.setLayoutX(20);
        predatorNumLabel.setLayoutY(365);
        predatorNumLabel.setStyle("-fx-font-style: italic");
        predatorNumTextField.setLayoutX(20);
        predatorNumTextField.setLayoutY(405);
        predatorNumErrorLabel.setLayoutX(20);
        predatorNumErrorLabel.setLayoutY(445);
        predatorNumErrorLabel.setStyle("-fx-text-fill: red");



        Label obstaclesNumLabel = new Label("Input obstacles number");
        TextField obstaclesNumTextField = new TextField();
        Label obstaclesNumErrorLabel = new Label("error msg");
        obstaclesNumErrorLabel.setVisible(false);
        obstaclesNumLabel.setLayoutX(20);
        obstaclesNumLabel.setLayoutY(475);
        obstaclesNumLabel.setStyle("-fx-font-style: italic");
        obstaclesNumTextField.setLayoutX(20);
        obstaclesNumTextField.setLayoutY(515);
        obstaclesNumErrorLabel.setLayoutX(20);
        obstaclesNumErrorLabel.setLayoutY(555);
        obstaclesNumErrorLabel.setStyle("-fx-text-fill: red");




        Label timeToReproduceNumLabel = new Label("Input time to reproduce (number) ");
        TextField timeToReproduceNumTextField = new TextField();
        Label timeToReproduceNumErrorLabel = new Label("error msg");
        timeToReproduceNumErrorLabel.setVisible(false);
        timeToReproduceNumLabel.setLayoutX(20);
        timeToReproduceNumLabel.setLayoutY(585);
        timeToReproduceNumLabel.setStyle("-fx-font-style: italic");
        timeToReproduceNumTextField.setLayoutX(20);
        timeToReproduceNumTextField.setLayoutY(625);
        timeToReproduceNumErrorLabel.setLayoutX(20);
        timeToReproduceNumErrorLabel.setLayoutY(665);
        timeToReproduceNumErrorLabel.setStyle("-fx-text-fill: red");



        Label timeToFeedNumLabel = new Label("Input time to feed (number) ");
        TextField timeToFeedNumTextField = new TextField();
        Label timeToFeedNumErrorLabel = new Label("error msg");
        timeToFeedNumErrorLabel.setVisible(false);
        timeToFeedNumLabel.setLayoutX(20);
        timeToFeedNumLabel.setLayoutY(695);
        timeToFeedNumLabel.setStyle("-fx-font-style: italic");
        timeToFeedNumTextField.setLayoutX(20);
        timeToFeedNumTextField.setLayoutY(725);
        timeToFeedNumErrorLabel.setLayoutX(20);
        timeToFeedNumErrorLabel.setLayoutY(765);
        timeToFeedNumErrorLabel.setStyle("-fx-text-fill: red");


        Label iterationNumLabel = new Label("Input iteration number between 1 and 1000");
        TextField iterationNumTextField = new TextField();
        Label iterationNumErrorLabel = new Label("error msg");
        iterationNumErrorLabel.setVisible(false);
        iterationNumLabel.setLayoutX(20);
        iterationNumLabel.setLayoutY(795);
        iterationNumLabel.setStyle("-fx-font-style: italic");
        iterationNumTextField.setLayoutX(20);
        iterationNumTextField.setLayoutY(835);
        iterationNumErrorLabel.setLayoutX(20);
        iterationNumErrorLabel.setLayoutY(875);
        iterationNumErrorLabel.setStyle("-fx-text-fill: red");


        TextArea gameSceneArea = new TextArea();

        Button startButton = new Button("start the game");
        startButton.setLayoutX(20);
        startButton.setLayoutY(905);
       startButton.setStyle("-fx-background-color: black;-fx-text-fill: white;-fx-min-width: 250px");
       startButton.setOnAction(event -> {
           //int size, int preyNum, int predNum, int obstaclesNum, int itrNum,int timeToReproduce,int timeToFeed
                   boolean checkForNumber = false;
                   rowsNumErrorLabel.setVisible(false);
                   columnsNumErrorLabel.setVisible(false);
                   preyNumErrorLabel.setVisible(false);
                   predatorNumErrorLabel.setVisible(false);
                   obstaclesNumErrorLabel.setVisible(false);
                   timeToReproduceNumErrorLabel.setVisible(false);
                   timeToFeedNumErrorLabel.setVisible(false);
                   iterationNumErrorLabel.setVisible(false);
                   int rowsNum = 0, colsNum = 0, preNum = 0, predNum = 0, obstaclesNum = 0, timeToFeed = 0, timeToReproduce = 0, iterNum = 0;
                   Ocean ocean;
                   try{
                       rowsNum = Integer.parseInt(rowsNumTextField.getText());
                   }catch (NumberFormatException e ){
                       rowsNumErrorLabel.setVisible(true);
                       rowsNumErrorLabel.setText("Rows is not a number");
                       checkForNumber = true;
                   }

                   try{
                       colsNum = Integer.parseInt(columnsNumTextField.getText());
                   }catch (NumberFormatException e ){
                       columnsNumErrorLabel.setVisible(true);
                       columnsNumErrorLabel.setText("Columns is not a number");
                       checkForNumber  = true;
                   }
                   try{
                       preNum = Integer.parseInt(preyNumTextField.getText());
                   }catch (NumberFormatException e ){
                       preyNumErrorLabel.setVisible(true);
                       preyNumErrorLabel.setText("Prey is not a number");
                       checkForNumber = true;
                   }
                   try{
                       predNum = Integer.parseInt(predatorNumTextField.getText());
                   }catch (NumberFormatException e ){
                       predatorNumErrorLabel.setVisible(true);
                       predatorNumErrorLabel.setText("Predator is not a number");
                       checkForNumber = true;
                   }
                   try{
                       obstaclesNum = Integer.parseInt(obstaclesNumTextField.getText());
                   }catch (NumberFormatException e ){
                       obstaclesNumErrorLabel.setVisible(true);
                       obstaclesNumErrorLabel.setText("Obstacle is not a number");
                       checkForNumber = true;
                   }
                   try{
                       timeToReproduce = Integer.parseInt(timeToReproduceNumTextField.getText());
                   }catch (NumberFormatException e ){
                       timeToReproduceNumErrorLabel.setVisible(true);
                       timeToReproduceNumErrorLabel.setText("Time to reproduce is not a number");
                       checkForNumber = true;
                   }
                   try{
                      timeToFeed = Integer.parseInt(timeToFeedNumTextField.getText());
                   }catch (NumberFormatException e ){
                       timeToFeedNumErrorLabel.setVisible(true);
                       timeToFeedNumErrorLabel.setText("Time to feed is not a number");
                       checkForNumber = true;
                   }
                   try{
                      iterNum =  Integer.parseInt(iterationNumTextField.getText());
                   }catch (NumberFormatException e ){
                       iterationNumErrorLabel.setVisible(true);
                       iterationNumErrorLabel.setText("Time to feed is not a number");
                       checkForNumber = true;
                   }
                   if(checkForNumber)return ;
                    ocean = new Ocean(rowsNum,colsNum,preNum,predNum,obstaclesNum,iterNum,timeToReproduce,timeToFeed);
                   if(ocean.isValid()){

                       OceanJavaFxController oceanJavaFxController = new OceanJavaFxController(ocean);
                       try {
                           oceanJavaFxController.init();
                       } catch (CloneNotSupportedException e) {
                           e.printStackTrace();
                       }
                       gameSceneArea.setPrefColumnCount(ocean.getColsNum());
                       gameSceneArea.setPrefRowCount(ocean.getRowsNum());
                       gameSceneArea.setText(OceanInfoDisplay.javaFxTextAreaShow(ocean));
                       try {
                           Thread.sleep(500);
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                       Task<Void> task = new Task<Void>() {
                           @Override
                           protected Void call() throws Exception {
                               for(int i =0;i<ocean.getNumOfIteration();i++){
                                   oceanJavaFxController.toProcessAllCells();
                                   if(oceanJavaFxController.checkForOneEntity())break;
                                   oceanJavaFxController.setProcessedStatusToFalse();
                                   Platform.runLater(()->{
                                       gameSceneArea.setText(OceanInfoDisplay.javaFxTextAreaShow(ocean));
                                   });
                                   try {
                                       Thread.sleep(500);
                                   } catch (InterruptedException e) {
                                       e.printStackTrace();
                                   }
                               }
                               return null;
                           }

                       };
                       Thread thread = new Thread(task);
                       thread.setDaemon(true);
                       thread.start();


                   }
                   else{
                       if(ocean.getRowsNum()>25||ocean.getRowsNum()<=0)
                       { rowsNumErrorLabel.setVisible(true);
                           rowsNumErrorLabel.setText("rows count must be between 0(exclusive and 75(inclusive)");}
                       if(ocean.getColsNum()>75||ocean.getRowsNum()<=0)
                       { columnsNumErrorLabel.setVisible(true);
                           columnsNumErrorLabel.setText("Cols count must be between 0(exclusive and 75(inclusive)");}
                       if(ocean.getNumOfPreys()<=0)
                       { preyNumErrorLabel.setVisible(true);
                           preyNumErrorLabel.setText("Prey count must be higher that 0");}
                       if(ocean.getNumOfPredators()<=0)
                       { predatorNumErrorLabel.setVisible(true);
                           predatorNumErrorLabel.setText("Predator count must be higher that 0");}
                       if(ocean.getNumOfObstacles()<0)
                       { obstaclesNumErrorLabel.setVisible(true);
                           obstaclesNumErrorLabel.setText("Obstacle count must be a positive number");}
                       if(ocean.getTimeToReproduce()<=0)
                       { timeToReproduceNumErrorLabel.setVisible(true);
                           timeToReproduceNumErrorLabel.setText("Time to reproduce count must be higher than 0");}
                       if(ocean.getTimeToFeed()<=0)
                       { timeToFeedNumErrorLabel.setVisible(true);
                           timeToFeedNumErrorLabel.setText("Time to feed count must be higher than 0");}
                   }

       });

        Label labelForLeftBorder = new Label(" \n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        labelForLeftBorder.setStyle("-fx-background-color: black");
        Pane gameParamsPane = new Pane();
        gameParamsPane.setPrefWidth(320);
        gameParamsPane.setPrefHeight(950);
        gameParamsPane.setLayoutX(650);
        gameParamsPane.getChildren().add(labelForGameParameters);
        gameParamsPane.getChildren().add(labelForLeftBorder);
        gameParamsPane.getChildren().add(startButton);
        gameParamsPane.getChildren().add(rowsNumLabel);
        gameParamsPane.getChildren().add(rowsNumErrorLabel);
        gameParamsPane.getChildren().add(colsNumLabel);
        gameParamsPane.getChildren().add(columnsNumErrorLabel);
        gameParamsPane.getChildren().add(preyNumLabel);
        gameParamsPane.getChildren().add(preyNumErrorLabel);
        gameParamsPane.getChildren().add(predatorNumLabel);
        gameParamsPane.getChildren().add(predatorNumErrorLabel);
        gameParamsPane.getChildren().add(obstaclesNumLabel);
        gameParamsPane.getChildren().add(obstaclesNumErrorLabel);
        gameParamsPane.getChildren().add(timeToReproduceNumLabel);
        gameParamsPane.getChildren().add(timeToReproduceNumErrorLabel);
        gameParamsPane.getChildren().add(timeToFeedNumLabel);
        gameParamsPane.getChildren().add(timeToFeedNumErrorLabel);
        gameParamsPane.getChildren().add(iterationNumLabel);
        gameParamsPane.getChildren().add(iterationNumErrorLabel);
        gameParamsPane.getChildren().add(rowsNumTextField);
        gameParamsPane.getChildren().add(columnsNumTextField);
        gameParamsPane.getChildren().add(preyNumTextField);
        gameParamsPane.getChildren().add(predatorNumTextField);
        gameParamsPane.getChildren().add(obstaclesNumTextField);
        gameParamsPane.getChildren().add(timeToReproduceNumTextField);
        gameParamsPane.getChildren().add(timeToFeedNumTextField);
        gameParamsPane.getChildren().add(iterationNumTextField);
        Pane mainPane = new Pane();
        mainPane.getChildren().add(gameSceneArea);
        gameSceneArea.setLayoutX(20);
        gameSceneArea.setLayoutY(100);
        mainPane.prefWidth(1000);
        mainPane.setPrefHeight(1000);
        mainPane.getChildren().add(labelForGame);
        mainPane.getChildren().add(gameParamsPane);
        gameParamsPane.setStyle("-fx-background-color: white;");
        Scene scene = new Scene(mainPane);
        primaryStage.setScene(scene);
        primaryStage.setWidth(1000);
        primaryStage.setHeight(1000);
        primaryStage.show();
    }
}
