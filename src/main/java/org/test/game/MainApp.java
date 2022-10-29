package org.test.game;

import org.test.game.model.*;

/**
 * Hello world!
 *
 */
public class MainApp
{
    public static void main( String[] args ) {
        SpecialEntity entity1 = new Snake(20,50);
        SpecialEntity entity2 = new Ladder(10,90);

        Player player1 = new Player("ramesh",0);
        Player player2 = new Player("rajesh",0);
        Player player3 = new Player("suresh",0);
        Board board = new Board(100);
        board.addSpecialEntity(entity1);
        board.addSpecialEntity(entity2);

        Game newGame = new Game(board,new Dice(6));
        newGame.addPlayers(player1);
        newGame.addPlayers(player2);
        newGame.addPlayers(player3);
        //Launch the game
        newGame.startGame();
    }
}
