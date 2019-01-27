package main;

import game.Game;
import game.GameTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import player.Player;

import java.util.Scanner;
import java.util.Timer;


public class Main extends Application implements EventHandler<KeyEvent> {

    static Controller controller;

    @Override
    public void start(Stage primaryStage) throws Exception{

        Scanner scanner = new Scanner(System.in);

        System.out.println("Geef eerste naam:");
        Player p1 = new Player(scanner.nextLine());
        System.out.println("Geef tweede naam:");
        Player p2 = new Player(scanner.nextLine());

        FXMLLoader loader = new FXMLLoader(getClass().getResource("tetris_scene.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Tetris - By Robin");
        Scene scene = new Scene(root, 920, 650);
        scene.setOnKeyPressed(this);

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

        controller = loader.getController();

        Game.initializeGame();

    }


    public static void main(String[] args) {
        launch(args);
    }

    public static Controller getController(){
        if(controller != null){
            return controller;
        }
        return null;
    }

    @Override
    public void handle(KeyEvent event){

        if(event.getCode() == KeyCode.SPACE && !Game.hasStarted){
            Game.hasStarted = true;
            Timer timer = new Timer();
            timer.schedule(new GameTimer(), 0, 1000);
            Game.start();
        }

    }

}
