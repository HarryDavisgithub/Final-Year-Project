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
    
    public int addBoardTile(int num){
       
        return 3;
    }
    
    public void add(int num){
        if(tile[num].isFilled()){
            System.out.println("Row full");//add error message saying colum filled
        }else{
            //gui.addCounterVisual();
            for(int i = 0; i <5; i++){
                if(anythingBelow(num)){
                    addBoardTile(num);
                    break;
                }else{
                    num++;

                }
            }
        }
    }
    
    public boolean anythingBelow(int num) {
        //System.out.println("yes" + tile[num+1].isFilled());
        
        if(tile[num+1].isFilled() && num%6 != 0){
            return true;
        }else{
            return false;
        }
        
        
    }
}
