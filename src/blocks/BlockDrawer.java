package blocks;

import java.util.*;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import main.Main;
import org.w3c.dom.css.Rect;
import player.Player;


public class BlockDrawer {

    public static final int RECTANGLE_DIMENSION = 20;
    private static Map<Player, List<Rectangle>> playerRectanglesMap = new HashMap<>();

    private static final List<Color> availableColors = Arrays.asList(
            Color.RED,
            Color.BLUE,
            Color.GREEN,
            Color.YELLOW,
            Color.ORANGE,
            Color.PINK,
            Color.CYAN);

    private static void drawBlock(Block block, Color color, int x, int y, Pane pane, Player player){

        List<Rectangle> rectangles = new ArrayList<>();

        for(int i = 0; i<block.gridFigure[0].length; i++){

            for(int j = 0; j<block.gridFigure.length; j++){

                if(block.gridFigure[j][i] == 1) {

                    Rectangle rectangle = new Rectangle(x
                            + (i * RECTANGLE_DIMENSION), y + (j * RECTANGLE_DIMENSION), RECTANGLE_DIMENSION, RECTANGLE_DIMENSION);
                    rectangle.setFill(color);
                    rectangle.setStroke(Color.BLACK);

                    pane.getChildren().add(rectangle);
                    rectangles.add(rectangle);
                }
            }
        }
        playerRectanglesMap.put(player, rectangles);

    }

    // Blok tekenen op scherm met posities op het opgegeven pane

    private static void drawBlock(Block block, Color color, int x, int y, Pane pane){

        for(int i = 0; i<block.gridFigure[0].length; i++){

            for(int j = 0; j<block.gridFigure.length; j++){

                if(block.gridFigure[j][i] == 1) {

                    Rectangle rectangle = new Rectangle(x
                            + (i * RECTANGLE_DIMENSION), y + (j * RECTANGLE_DIMENSION), RECTANGLE_DIMENSION, RECTANGLE_DIMENSION);
                    rectangle.setFill(color);
                    rectangle.setStroke(Color.BLACK);

                    pane.getChildren().add(rectangle);
                }
            }
        }

    }

    public static void drawQueueBlock(Player player) {

        Block block = player.getPlayerBlockQueue().get(1);
        Color color = player.getPlayerBlockQueueColors().get(1);
        int startX = Player.PLAYER1_QUEUE_X;
        if (player.getPlayerId() == 1) {
            startX = Player.PLAYER2_QUEUE_X;
        }

        drawBlock(block, color, startX, Player.PLAYER_QUEUE_Y, Main.getController().getPlayer1_next_block_pane());
    }

    public static void drawFieldBlock(Player player){

        Block block = player.getPlayerBlockQueue().get(0);
        Color color = player.getPlayerBlockQueueColors().get(0);
        Pane pane = getPlayerPane(player);

        drawBlock(block, color, Player.PLAYER_START_X, Player.PLAYER_START_Y, pane, player);

    }

    public static Color getRandomColor(){
        Random random = new Random();
        int colorIndex = random.nextInt(availableColors.size());
        return availableColors.get(colorIndex);
    }

    private static Pane getPlayerPane(Player player){
        Pane pane = Main.getController().getPlayer1_field();
        if(player.getPlayerId() == 1){
            pane = Main.getController().getPlayer2_field();
        }
        return pane;
    }

    public static void updateBlockPosition(Player player){
        Block currentBlock = player.getPlayerBlockQueue().get(0);
        Color color = player.getPlayerBlockQueueColors().get(0);
        Pane pane = getPlayerPane(player);
        pane.getChildren().removeAll(playerRectanglesMap.get(player));
        playerRectanglesMap.remove(player);
        drawBlock(currentBlock, color, player.getX(), player.getY() + RECTANGLE_DIMENSION, pane, player);
    }

}
