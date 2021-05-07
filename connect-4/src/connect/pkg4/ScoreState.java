/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect.pkg4;

import connect.pkg4.BoardTile.Colour;
import java.util.ArrayList;

/**
 *
 * @author harry
 */
public class ScoreState {
    Game game;
    Board board;
    int score = 0;
    
    public ScoreState(Game game, Board board){
        this.game = game;
        this.board = board;
    }
    
    public void score_position(){
        int b = 5;
        System.out.println("b: " + b);    
        System.out.println("scoreb: " + score);
        
        for(int i = 0; i < 6; i++){
            if(game.checkForLine(b, 6, 4, Colour.YELLOW) == 4){
                score += 100;
            }
            b += 6;
            if(game.checkForLine(i, 6, 3, Colour.YELLOW) == 3){
                score += 10;
            }
        }
        System.out.println("score: " + score);
    
    }
    
    public void pick_best_score(){
        
    
    }
    
    
}
