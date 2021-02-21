/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect.pkg4;

import connect.pkg4.BoardTile.Colour;
import java.util.Arrays;

/**
 *
 * @author harry
 */
public class Board {
    BoardTile[] tile = new BoardTile[42];
    
    public Board(){
        int count = 0;
        for(int i = 0; i < 42; i++){
            tile[i] = new BoardTile(false, Colour.WHITE, count);
            count +=1;
        }
    }
    
    public void addBoardTile(int num, Colour col){
       BoardTile t = tile[num];
       t.fillTile();
       t.setColour(col);
    }
    
    public boolean whatsOnTile(int p, Colour c){
        if(tile[p].isFilled()){
            if(tile[p].getColour() == c){
                return true;
            }
        } 
        return false;
    }
    
    public boolean isTileFull(int num){
        return tile[num].isFilled();
    }
    
    public Colour tileColour(int i){
        return tile[i].getColour();
    }
    
    public boolean isTileBelowFull(int num) { //refactor
        if((num+1)%6 == 0 && num != 0){
            return true;
        }else{
            return tile[num+1].isFilled();
        }
        
    }
}
