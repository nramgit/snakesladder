package org.test.game.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Setter
@Getter

public class Game {
    private Board board;
    private Dice dice;
    private Queue<Player> players;
    private GameStatus gameStatus;

    public Game(Board board, Dice dice){
        this.board = board;
        this.dice = dice;
        players = new LinkedList<>();
    }

    public void startGame(){
        this.gameStatus = GameStatus.RUNNING;
        board.printBoard();
        if(players.size()<2){
            System.out.println("Need 2 players to play this game.");
            return;
        }

        while(players.size() > 1){
            Player player = players.poll();
            makeMove(player);

            if(player.getPosition() == board.getTotalSize())
                System.out.println("Player "+player.getName()+" has completed the game!");
            else
                players.add(player);
        }
        this.gameStatus = GameStatus.FINISHED;
    }

    public void addPlayers(Player player) {
        players.add(player);
    }

    public void makeMove(Player player){

        int playerPosition = player.getPosition();
        int dicePosition = dice.roleDice(player);
        int targetPosition = playerPosition+dicePosition;
        System.out.println(targetPosition+" "+board.getTotalSize());
        if(targetPosition > board.getTotalSize()) {
            System.out.println("Invalid move!");
            targetPosition = playerPosition;
        } else {
            if(board.hasSpecialEntity(targetPosition)) {
                SpecialEntity entity = board.getSpecialEntity(targetPosition);
                if(entity.getID().startsWith("Ladder_"))
                    targetPosition = board.getSpecialEntity(targetPosition).getEnd();
                if(entity.getID().startsWith("Snake_"))
                    targetPosition = board.getSpecialEntity(targetPosition).getStart();
            }
        }
        player.setPosition(targetPosition);
    }

}
