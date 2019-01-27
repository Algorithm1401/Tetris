package game;

import blocks.BlockDrawer;
import main.Main;
import player.Player;

import java.util.Timer;

public class Game {

    public static boolean hasStarted = false;
    private static double delay = 500.0;

    public static void initializeGame(){

        Player p1 = Player.getPlayerMap().get(0);
        Player p2 = Player.getPlayerMap().get(1);

        Main.getController().getPlayer1_name_bottom().setText("Player 1: " + p1.getName());
        Main.getController().getPlayer2_name_bottom().setText("Player 2: " + p2.getName());
        BlockDrawer.drawQueueBlock(p1);
        BlockDrawer.drawQueueBlock(p2);

        BlockDrawer.drawFieldBlock(p1);
        BlockDrawer.drawFieldBlock(p2);

        Main.getController().getTimer().setText("Press space to start the game");

    }

    public static void start(){

        Timer timer = new Timer();
        timer.schedule(new BlockTimer(), (int)delay);

    }

    public static double getDelay() {
        return delay;
    }

    public static void setDelay(double delay) {
        Game.delay = delay;
    }
}
