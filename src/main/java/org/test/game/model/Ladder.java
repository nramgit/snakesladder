package org.test.game.model;

public class Ladder extends SpecialEntity {

    public Ladder(int start, int end){
        super(start,end);
    }
    @Override
    public String getID() {
        return "Ladder_"+getEnd();
    }
}
