/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect.pkg4;

import javax.swing.JOptionPane;

/**
 *
 * @author harry
 */
public class Game {
    private int col = 1;
    Board board;
    //boardGUI gui = new boardGUI();;
    
    
    public Game(){
        board = new Board();
    }
    
    
    public void addCounterVisual(int x, boardGUI gui){
        String colour = "/connect/pkg4/images/counterRed.png";
        int num = x;
        if(board.isTileFull(num) == false){
            for(int i = 0; i <6; i++){
               
               if(board.anythingBelow(num) == true){
                   if(col%2 == 0){colour = "/connect/pkg4/images/counterYellow.png";}
                   gui.placeCounter(num, colour);
                   board.addBoardTile(num, col%2);
                   hasWon(num, col%2);
                   col++;
                   break;  
               }else{
                   gui.removeCounter(x);
                   num++;
               }  
            }
        }else{System.out.println("Column full!");}
    }
    
    public boolean diaognalWin(){
        
        
        return true;
    }
    
    public boolean horizontal(int place, int col){
        int count = 1;
        int p = place;
        int o = place;
        
        p -= 6;
        o += 6;
        
        for(int i = 0; i < 3; i++){
            
            if(p > 0){
                if(board.whatsOnTile(p, col)){
                    p -= 6;
                    count++;
                    System.out.println(count);
                }
            }
            
            if(o < 41){
                if(board.whatsOnTile(o, col)){
                    o += 6;
                    count++;
                    System.out.println("backwards" + count);
                }
            }
            
            if(count == 4){
                return true;
            }
        }
        return false;
    }
    
    public void hasWon(int lastPlace, int lastCol){
        
       
            if(horizontal(lastPlace, lastCol)){
                System.out.println("Winner!");
            }
            
        
        
    }
    
    public String whatColour(int i){
        String s;
        if(col%2==0){
            s= "Yellow Wins!";
        }else{ 
            s = "Red Wins!";
        }
        return s;
    }
    
//    public boolean add(int num, int col){
//        if(board.anythingBelow(num)){
//            gui.placeCounter(num, colour);
//            board.addBoardTile(num, col);
//            return true;
//        }
//        return false;
//    }
    
}
