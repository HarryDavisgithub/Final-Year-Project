/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect.pkg4;

import connect.pkg4.BoardTile.Colour;
import java.awt.Color;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author harry
 */
public class Game {
    private int turn = 1;
    private Colour col;
    Board board;
    
    public Game(){
        board = new Board();
    }
    
    public void addCounterVisual(int x, BoardGui gui){
        String sColour = "/connect/pkg4/images/red with blue grid.jpg";
        col = Colour.RED; //Sets starting colour
        int num = x;
        
        
        if(board.isTileFull(num) == false){
            if(turn%2 == 0){
                col = Colour.YELLOW; 
                sColour = "/connect/pkg4/images/yellow with blue grid.jpg";
            }
            if(turn%2 == 0){
                gui.currentTurnText("RED", Color.red);
            }else{
                gui.currentTurnText("YELLOW", Color.orange);
            }
            
            
            for(int i = 0; i <6; i++){
               
               if(board.isTileBelowFull(num) == true){
                   
                   gui.placeCounter(num, sColour);
                   board.addBoardTile(num, col);
                   
                   if(checkForWin(num)){
                       gui.showWinningMsg(whatColour());
                   }
                   turn++;
                   
                   break;  
               }else{
                   gui.placeCounter(num, "/connect/pkg4/images/red with blue grid.jpg");
                   gui.placeCounter(num, "/connect/pkg4/images/empty with blue grid.png");
                   num++;
               }  
            }
        }else{System.out.println("Column full!");}
    }
    
    
    
    public int checkForLine(int x, int step){
        Colour colour = board.tileColour(x);
        int i = 0;
        
        if(step == -1 || step == -7 || step == 5 ){
            if(x == 0 || x%6 == 0){
                return 1;
            }
        }else if(step == 1 || step == 7 || step == -5 ){
            if((x+1)%6 == 0){
                return 1;
            }  
        }
        while(x > -1 && x < 42 && board.tileColour(x) == colour){
                x += step;
                i++;
        }
        return i;
    }
    
    public int getCompleteLine(int x, int step){
        return checkForLine(x, step) + checkForLine(x, -step) -1;
    }
    
    public boolean checkForWin(int x){
        return getCompleteLine(x, 1) >= 4 || getCompleteLine(x, 6) >= 4 || getCompleteLine(x, 5) >= 4 || getCompleteLine(x, 7) >= 4;
    }
   
    public String whatColour(){
        String s;
        if(turn%2==0){
            s= "Yellow Wins!";
        }else{ 
            s = "Red Wins!";
        }
        return s;
    }
    
    
}
