package game;

import blocks.BlockDrawer;
import javafx.application.Platform;
import player.Player;

import java.util.Timer;
import java.util.TimerTask;

public class BlockTimer extends TimerTask {

    @Override
    public void run(){
        Platform.runLater(() -> {
            System.out.println("Blocktimer runned");
            BlockDrawer.updateBlockPosition(Player.getPlayerMap().get(0));
            BlockDrawer.updateBlockPosition(Player.getPlayerMap().get(1));
            Timer timer = new Timer();
            timer.schedule(new BlockTimer(), (int) Game.getDelay());
        });

    }

}
