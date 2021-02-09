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
            System.out.println(tile.length);
            //if(){
                tile[i] = new BoardTile(false, 0, count);
            count ++;
            //}else{
            //    tile[i] = null;
            //}
            
            
        }
     System.out.println(Arrays.toString(tile));
    }
    
    public void addBoardTile(int num){
       BoardTile t = tile[num];
       t.fillTile();
    }
    
    public boolean add(int num){
        if(anythingBelow(num)){
            addBoardTile(num);
            return true;
        }
        return false;
    }
    
    public boolean tileFull(int num){
        if(tile[num].isFilled()){
            return true;
        }else{
            return false;
        }
        
    }
    
    public boolean anythingBelow(int num) {
        //System.out.println("yes" + tile[num+1].isFilled());
        if(num%6 == 0 && num != 0){
            return true;
        }else{
            if(tile[num+1].isFilled()){
                return true;
            }else{
                return false;
            }
        }
        
    }
}
