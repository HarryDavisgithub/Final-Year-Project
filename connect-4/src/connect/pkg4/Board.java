/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect.pkg4;

import connect.pkg4.BoardTile.Colour;
import static connect.pkg4.BoardTile.Colour.WHITE;
import java.util.ArrayList;
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
    
    public BoardTile[] getBoard(){
        return tile;
    }
    
    public void removeBoardTile(int num){
       BoardTile t = tile[num];
       t.emptyTile();
       //t.setColour(Colour.WHITE);
    }
    
    public int getPos(BoardTile b){
        return b.getPos();
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
    
    public ArrayList<Integer> createPossibleMoves(){
        ArrayList<Integer> possibleMoves = new ArrayList<>();
        
        for(int c = 0; c < 42; c++){
            if(isTileFull(c) == false){
                if(isTileBelowFull(c)){
                   possibleMoves.add(c);
                }
            }   
            
           
        }
//        for(int i: possibleMoves){
//            System.out.print(i + " ");
//        }
//        System.out.print("\n");
        return possibleMoves;
    }
    
    
}
