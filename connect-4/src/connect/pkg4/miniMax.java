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
public class miniMax {
    Game game;
    Board board;
    private int bestMove;
    private int depth = 8;
    
    public miniMax(Game game, Board board){
        this.board = board;
        this.game = game;
    }
    
    public int minimax(int depth, int alpha, int beta, Colour col){
        ArrayList<Integer> possibleMoves = board.createPossibleMoves();
        
        if(depth == 0 || possibleMoves.isEmpty()){
            return scoreCheck(board.getBoard());

        }
        
        if (col == Colour.YELLOW){ //max
            //ArrayList<Integer> possibleMoves = board.createPossibleMoves();
            int maxValue = alpha;

            if(depth == 0 || possibleMoves.isEmpty()){
                return scoreCheck(board.getBoard());
            }

            for(int b: possibleMoves){
                board.addBoardTile(b, Colour.YELLOW);
                int result = minimax(depth - 1, maxValue, beta, Colour.RED);
                board.removeBoardTile(b);

                if(result > maxValue){
                    maxValue = result;

                    if(maxValue >= beta) break;

                    if(depth == this.depth) {
                       bestMove = b;
                    }
                }
            }
        return maxValue;
        
        }else{ //min
            //ArrayList<Integer> possibleMoves = board.createPossibleMoves();
            int minValue = beta;

            if(depth == 0 || possibleMoves.isEmpty()){
                return scoreCheck(board.getBoard());
            }

            for(int b: possibleMoves){
                board.addBoardTile(b, Colour.RED);
                int result = minimax(depth - 1, alpha, minValue, Colour.YELLOW);
                board.removeBoardTile(b);

                if(result < minValue){
                    minValue = result;

                    if(minValue <= alpha) break;

                    if(depth == this.depth){
                       bestMove = b;
                    }
                }
            }
            return minValue; 
        }
    
    }
    
    
//    public int min(int depth, int alpha, int beta){
//        ArrayList<Integer> possibleMoves = board.createPossibleMoves();
//        int minValue = beta;
//        
//        if(depth == 0 || possibleMoves.isEmpty()){
//            return scoreCheck(board.getBoard());
//        }
//        
//        for(int b: possibleMoves){
//            board.addBoardTile(b, Colour.RED);
//            int result = max(depth - 1, alpha, minValue);
//            board.removeBoardTile(b);
//
//            if(result < minValue){
//                minValue = result;
//
//                if(minValue <= alpha) break;
//
//                if(depth == this.depth){
//                   bestMove = b;
//                }
//            }
//        }
//        return minValue; 
//    }
//    
//    public int max(int depth, int alpha, int beta){
//        ArrayList<Integer> possibleMoves = board.createPossibleMoves();
//        int maxValue = alpha;
//        
//        if(depth == 0 || possibleMoves.isEmpty()){
//            return scoreCheck(board.getBoard());
//        }
//        
//        for(int b: possibleMoves){
//            board.addBoardTile(b, Colour.YELLOW);
//            int result = min(depth - 1, maxValue, beta);
//            board.removeBoardTile(b);
//
//            if(result > maxValue){
//                maxValue = result;
//
//                if(maxValue >= beta) break;
//
//                if(depth == this.depth) {
//                   bestMove = b;
//                }
//            }
//        }
//        return maxValue; 
//    }
    

    
    public int scoreCheck(BoardTile boardArray[]){
        int score = 0;
        //System.out.println(Arrays.toString(boardArray));
        for(int i = 0; i < 42; i++){
            score += scoreLine(boardArray, i, 1); //+ scoreLine(boardArray, i, 6) + scoreLine(boardArray, i, 5) + scoreLine(boardArray, i, 7); 
        
        }
        //System.out.println("score" + score);
        return score;
    }
    
//    public int scoreBoard(BoardTile boardArray, int pos, int step){
//        return scoreLine(boardArray, pos, -step) + scoreLine(boardArray, pos, step)
//    }
    

    
    public int scoreLine(BoardTile[] boardArray, int pos, int step){
        int score = 0;
        
        if(pos <= 23){ //row
            score += evaluateLine(new Colour[] {board.tileColour(pos), board.tileColour(pos + 6), board.tileColour(pos + 12), board.tileColour(pos + 18)});
        }
        if(pos >= 18){ //row
            score += evaluateLine(new Colour[] {board.tileColour(pos), board.tileColour(pos - 6), board.tileColour(pos - 12), board.tileColour(pos - 18)});
        }
        
        if((pos+1)%6 != 0 && (pos+2)%6 != 0 && (pos+3)%6 != 0){ //col             
            score += evaluateLine(new Colour[] {board.tileColour(pos), board.tileColour(pos + 1), board.tileColour(pos + 2), board.tileColour(pos + 3)});
        }
        if(pos != 0 && pos%6 != 0 && (pos-1)%6 != 0 && (pos-2)%6 != 0){ //col
            score += evaluateLine(new Colour[] {board.tileColour(pos), board.tileColour(pos - 1), board.tileColour(pos - 2), board.tileColour(pos - 3)});
        }

       
        if(pos == 3 || pos == 9 || pos == 15 || pos == 21 || pos == 4 || pos == 10 || pos == 16 || pos == 22 || pos == 5 || pos == 11 || pos == 17 || pos == 23){ // diagonal /(pos+15) < 41 && pos > 0 && pos%6 != 0 && (pos+5)%6 != 0 && (pos+10)%6 != 0
            score += evaluateLine(new Colour[] {board.tileColour(pos), board.tileColour(pos + 5), board.tileColour(pos + 10), board.tileColour(pos + 15)});
        }
        if(pos == 18 || pos == 24 || pos == 30 || pos == 36 || pos == 19 || pos == 25 || pos == 31 || pos == 37 || pos == 20 || pos == 26 || pos == 32 || pos == 38){ //diagonal /pos < 41 && (pos-15) > 0 && (pos-5)%6 != 0 && (pos-10)%6 != 0 && (pos-15)%6 != 0
            score += evaluateLine(new Colour[] {board.tileColour(pos), board.tileColour(pos - 5), board.tileColour(pos - 10), board.tileColour(pos - 15)});
        }
        
        
        if(pos <= 20){ // diagonal \ (pos+21) <= 41 && pos > 0 && (pos+7)%6 != 0 && (pos+14)%6 != 0 && (pos+21)%6 != 0
            score += evaluateLine(new Colour[] {board.tileColour(pos), board.tileColour(pos + 7), board.tileColour(pos + 14), board.tileColour(pos + 21)});
        }
        if(pos >= 21){ //diagonal \ pos < 41 && (pos-21) >= 0 && (pos)%6 != 0 && (pos-7)%6 != 0 && (pos-14)%6 != 0
            score += evaluateLine(new Colour[] {board.tileColour(pos), board.tileColour(pos - 7), board.tileColour(pos - 14), board.tileColour(pos - 21)});
        }

        return score;
    }
    
    public int evaluateLine(Colour[] e){
        int red = 0, yellow = 0;
        //System.out.println(Arrays.toString(e));
        for(int i =0; i < e.length; i++){
            //System.out.println(e[i]);
            if(e[i] == Colour.RED) red++;
            if(e[i] == Colour.YELLOW) yellow++;
        }
        
        
        if(yellow == 0) {
            if(red == 4) return -1000;
            if(red == 3) return -100;
            if(red == 2) return -10;
            if(red == 1) return -1;
        }

        if(red == 0) {
            if(yellow == 4) return 1000;
            if(yellow == 3) return 100;
            if(yellow == 2) return 10;
            if(yellow == 1) return 1;
        }
        return 0;
    }
    
    public int doAiMove(){
        minimax(8, Integer.MIN_VALUE, Integer.MAX_VALUE, Colour.YELLOW);
        return bestMove;
    }
}
