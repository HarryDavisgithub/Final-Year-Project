/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect.pkg4;

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
            tile[i] = new BoardTile(false, 3, count);
            count +=1;
        }
     
    }
    public void print(){
        System.out.println(Arrays.toString(tile));
    }
    
    public void addBoardTile(int num, int col){
       BoardTile t = tile[num];
       t.fillTile();
       t.setColour(col);
    }
    
    public boolean add(int num, int col){
        if(anythingBelow(num)){
            addBoardTile(num, col);
            return true;
        }
        return false;
    }
    
    public boolean tileFull(int num){
        return tile[num].isFilled();
    }
    
    public boolean anythingBelow(int num) {
        if((num+1)%6 == 0 && num != 0){
            return true;
        }else{
            return tile[num+1].isFilled();
        }
        
    }
}
