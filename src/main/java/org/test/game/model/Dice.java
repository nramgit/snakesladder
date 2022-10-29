package org.test.game.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Scanner;

@Getter
@Setter
@AllArgsConstructor
public class Dice implements Serializable {
    private int maxSize;
    public int roleDice(Player player){
        //return (int)Math.floor(Math.random()*maxSize+1);
        System.out.println("Please roll the Dice.Its "+player.getName()+" turn...");
        Scanner sc = new Scanner(System.in);
        int diceCount = sc.nextInt();
        if(diceCount>6) {
            System.out.println("Invalid dice count. Please roll again!");
            diceCount = roleDice(player);
        }
        return diceCount;
    }
}
