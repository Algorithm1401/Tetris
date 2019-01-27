package player;

import blocks.Block;
import blocks.BlockDrawer;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player {

    public static final int PLAYER1_QUEUE_X = 45;
    public static final int PLAYER_QUEUE_Y = 25;
    public static final int PLAYER2_QUEUE_X = 815;
    public static final int PLAYER_START_X = 120;
    public static final int PLAYER_START_Y = 20;

    private static Map<Integer, Player> playerMap = new HashMap<>();
    private List<Block> playerBlockQueue = new ArrayList<>();
    private List<Color> playerBlockQueueColors = new ArrayList<>();
    private int playerId;
    private String name;

    private int x = PLAYER_START_X;
    private int y = PLAYER_START_Y;

    private int[][] playerFieldBlocks = new int[20][10];
    private Color[][] playerFieldColors = new Color[20][10];

    public Player(String playerName){
        setName(playerName);
        setPlayerId();
        initQueueBlocks();
        addPlayer(getPlayerId(), this);
    }

    public void setName(String name) {
        if(name.length() >= 3) {
            this.name = name;
        }
    }

    public void setPlayerId() {
        int highestPlayerId = -1;
        for(int playerId : playerMap.keySet()){
            if(highestPlayerId < playerId){
                highestPlayerId = playerId;
            }
        }
        this.playerId = highestPlayerId + 1;
    }

    public static void addPlayer(int playerId, Player player){
        if(!playerMap.containsKey(playerId)){
            playerMap.put(playerId, player);
        }
    }

    public int getPlayerId() {
        return playerId;
    }

    public static Map<Integer, Player> getPlayerMap() {
        return playerMap;
    }

    public String getName() {
        return name;
    }

    public List<Block> getPlayerBlockQueue() {
        return playerBlockQueue;
    }

    public Color[][] getPlayerFieldColors() {
        return playerFieldColors;
    }

    public int[][] getPlayerFieldBlocks() {
        return playerFieldBlocks;
    }

    public void addBlockToQueue(Block block){
        if(getPlayerBlockQueue().size() < 3){

            getPlayerBlockQueue().add(block);
            getPlayerBlockQueueColors().add(BlockDrawer.getRandomColor());

        }
    }

    private void initQueueBlocks(){
        for(int i = 0; i<3; i++){
            addBlockToQueue(Block.random());
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public List<Color> getPlayerBlockQueueColors() {
        return playerBlockQueueColors;
    }
}
