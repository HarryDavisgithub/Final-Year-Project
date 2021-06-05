/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect.pkg4;

import connect.pkg4.BoardTile.Colour;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author harry
 */
public class ScoreState {
    Game game;
    Board board;
    int score = 0;
     ArrayList<BoardTile> row_array = new ArrayList<>();
    
    public ScoreState(Game game, Board board){
        this.game = game;
        this.board = board;
    }
    
    public void score_position(){
        int b = 0;
        
        for(int j = 0; j < 6; j++){
            for(int i = 0; i < 6; i++){
                b +=6;
                row_array.add(board.tile[b]);
            }
            
        
        }
        
                
                
//                if(game.checkForLine(b, 6, 4, Colour.YELLOW) == 4){
//                    score += 100;
//                }
//                b += 6;
//                if(game.checkForLine(i, 6, 3, Colour.YELLOW) == 3){
//                    score += 10;
//                }
//                System.out.println("score" + score);
            
        
        row_array.forEach((i) -> {
            System.out.println(i);
        });
        
    
    }
    
    public void pick_best_score(){
        
    
    }
    
    
}
