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
            tile[i] = new BoardTile(false, 0, count);
            count +=1;
        }
     //System.out.println(Arrays.toString(tile));
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
        return tile[num].isFilled();
    }
    
    public boolean anythingBelow(int num) {
        //System.out.println("yes" + tile[num+1].isFilled());
        //System.out.println("num: " + num + "   num%6: " + num%6 + "   num+1%6: " + num+1%6);
        if((num+1)%6 == 0 && num != 0){
            System.out.println("yes");
            return true;
        }else{
            if(tile[num+1].isFilled()){
                System.out.println("yef");
                return true;
            }else{
                return false;
            }
        }
        
    }
}
