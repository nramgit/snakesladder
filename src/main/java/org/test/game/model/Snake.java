package org.test.game.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Snake extends SpecialEntity {

    public Snake(int start, int end){
        super(start,end);
    }
    @Override
    public String getID() {
        return "Snake_"+this.getEnd();
    }
}
