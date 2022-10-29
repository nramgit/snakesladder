package org.test.game.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.HashMap;

@Setter
@Getter
public class Board {
    private int dimension;
    HashMap<Integer,SpecialEntity> specialEntities = new HashMap<>();
    //List<SpecialEntity> specialEntities;

    public Board(int size){
        this.dimension = size;
    }
    public boolean hasSpecialEntity(int pos){
        return specialEntities.containsKey(pos);
    }

    public void addSpecialEntity(SpecialEntity specialEntity){
        int startPos = specialEntity.getStart();
        int endPos = specialEntity.getEnd();
        specialEntities.put(startPos,specialEntity);
        specialEntities.put(endPos,specialEntity);
    }

    public SpecialEntity getSpecialEntity(int pos) {
        return specialEntities.get(pos);
    }

    public int getTotalSize() {
        return dimension;
    }

    public void printBoard() {

        for(int i=dimension;i>0;i--){
            if(i%10==0)
                System.out.println();
            System.out.print("| "+i+" ");
            if(hasSpecialEntity(i))
                System.out.print(specialEntities.get(i).getID());
            System.out.print(" |");
        }
        System.out.println("");
    }
}
