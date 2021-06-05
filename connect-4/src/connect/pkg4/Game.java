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
    private int aiNum; 
    Board board;
    RandomAi randAi;
    DefensiveAi defAi;
    private int lastPos;
    private ScoreState SS;
    private miniMax mm;
    
    public Game(){
        board = new Board();
        randAi = new RandomAi();
        SS = new ScoreState(this, board);
        mm = new miniMax(this, board);
    }
    
    public void addCounterVisual(int x, BoardGui gui){
        String sColour = "/connect/pkg4/images/red with blue grid.jpg";
        col = Colour.RED; //Sets starting colour
        gui.currentTurnText("YELLOW", Color.orange);
        int num = x;
        
        
        if(board.isTileFull(num) == false){
            if(turn%2 == 0){
                col = Colour.YELLOW; 
                sColour = "/connect/pkg4/images/yellow with blue grid.jpg";
                gui.currentTurnText("RED", Color.red);
            }          
            
            for(int i = 0; i <6; i++){
               
               if(board.isTileBelowFull(num) == true){
                   
                   gui.placeCounter(num, sColour);
                   board.addBoardTile(num, col);
                   //System.out.println("Pos is: " + num);
                   
                   if(checkForWin(num, 4)){
                       System.out.println("winner: " + num);
                       gui.showWinningMsg(whatColour());
                   }
                   
                   turn++;
                   
                   break;  
               }else{
                   num++;
               }  
            }
            if(aiNum != 0 && turn%2 == 0) {
                //randAi.runAI(gui, this);
                //defAi.runAI(gui, this, lastPos);
                //SS.score_position();
                
                
                int move = mm.doAiMove();
                //System.out.println(move + " ");
                
                
                gui.placeCounter(move, "/connect/pkg4/images/yellow with blue grid.jpg");
                board.addBoardTile(move, Colour.YELLOW);


                if(checkForWin(move, 4)){
                    gui.showWinningMsg(whatColour());
                }
                turn++;
                
            }
        }else{System.out.println("Column full!");}
        lastPos = x;
        
    }
    
    
    
    
    
    
    public int checkForLine(int x, int step, int lineNum, Colour col){
        //Colour colour = board.tileColour(x);
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
        while(x > -1 && x < 42 && board.tileColour(x) == col && i <= lineNum){
            System.out.println("line:" + x);
            x += step;
            i++;
            if(x%6 == 0) {
                break;
            }
            
        }
        System.out.println(" ");
        return i;
    }
    
    public int getCompleteLine(int x, int step, int lineNum){
        return checkForLine(x, step, lineNum, board.tileColour(x)) + checkForLine(x, -step, lineNum, board.tileColour(x)) -1;
    }
    
    public boolean checkForWin(int x, int lineNum){
        return getCompleteLine(x, 1, lineNum) >= lineNum || getCompleteLine(x, 6, lineNum) >= lineNum || getCompleteLine(x, 5, lineNum) >= lineNum || getCompleteLine(x, 7, lineNum) >= lineNum;
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
    public void setAi(int num){
        aiNum = num;
    }

    
    public void runTest(){
        board.createPossibleMoves();
    }
}

