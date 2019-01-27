package game;

import javafx.application.Platform;
import main.Main;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.TimerTask;

public class GameTimer extends TimerTask {

    private LocalTime localTime = LocalTime.of(0, 5, 0);

    public void run(){
        Platform.runLater(() -> {
            if(!(localTime.getSecond() == 0 && localTime.getMinute() == 0)) {
                    localTime = localTime.minusSeconds((long) 1);
                    Main.getController().getTimer().setText(localTime.format(DateTimeFormatter.ofPattern("mm:ss")));
                Game.setDelay(Game.getDelay() - 0.5);
            }else{
                this.cancel();
            }
        });

    }

}
