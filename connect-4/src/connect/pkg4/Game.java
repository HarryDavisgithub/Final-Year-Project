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
    //"/connect/pkg4/images/empty with blue grid.png"
    
    public void addCounterVisual(int x, boardGUI gui){
        String colour = "/connect/pkg4/images/red with blue grid.jpg";
        int num = x;
        if(board.isTileFull(num) == false){
            for(int i = 0; i <6; i++){
               
               if(board.anythingBelow(num) == true){
                   if(col%2 == 0){colour = "/connect/pkg4/images/yellow with blue grid.jpg";}
                   gui.placeCounter(num, colour);
                   board.addBoardTile(num, col%2);
                   //hasWon(num, col%2);
                   if(winner(num)){
                       gui.showWinningMsg(whatColour());
                   }
                   col++;
                   break;  
               }else{
                   gui.placeCounter(num, "/connect/pkg4/images/empty with blue grid.png");
                   num++;
               }  
            }
        }else{System.out.println("Column full!");}
    }
    
    public int line(int x, int step){
        int colour = board.tileColour(x);
        int i = 0;
        
            if(step == -1 || step == -7 || step == 5 ){
                if(x == 0 || x%6 == 0){
                    return 0;
                }
            }else if(step == 1 || step == 7 || step == -5 ){
                if((x+1)%6 == 0){
                    return 0;
                }  
            }
            while((x > 0 && x < 41 && board.tileColour(x) == colour)){
                    x += step;
                    i++;
            }
        return i;
    }
    
    public int line2(int x, int step){
        return line(x, step) + line(x, -step) - 1;
    }
    
    public boolean winner(int x){
        return line2(x, 1) >= 4 || line2(x, 6) >= 4 || line2(x, 5) >= 4 || line2(x, 7) >= 4;
    }
   
    
//    public boolean horizontal(int place, int col){
//        int count = 1;
//        int p = place, o = place;
//        
//        p -= 6;
//        o += 6;
//        
//        for(int i = 0; i < 3; i++){
//            if(p > 0){
//                if(board.whatsOnTile(p, col)){
//                    p -= 6;
//                    count++;
//                }
//            }
//            if(o < 41){
//                if(board.whatsOnTile(o, col)){
//                    o += 6;
//                    count++;
//                }
//            }
//            if(count == 4){
//                return true;
//            }
//        }
//        return false;
//    }
//    
//    public boolean vertical(int place, int col){
//        int count = 1;
//        int p = place, o = place;
//        
//        p -= 1;
//        o += 1;
//        
//        for(int i = 0; i < 3; i++){
//            if((p+1)%6 != 0){
//                if(board.whatsOnTile(p, col)){
//                    p -= 1;
//                    count++;
//                }
//            }
//            if(o%6 != 0){
//                if(board.whatsOnTile(o, col)){
//                    o += 1;
//                    count++;
//                }
//            }
//            if(count == 4){
//                return true;
//            }
//        }
//        return false;
//    }
//    //BackSlash ////
//    public boolean backSlash(int place, int col){
//        int count = 1;
//        int p = place, o = place;
//        
//        if((p+1)%6 != 0){
//            
//        }
//        
//        p -= 5;
//        o += 5;
//
//        for(int i = 0; i < 3; i++){
//            
//            if((p+1)%6 != 0 && p > 0){
//                if(board.whatsOnTile(p, col)){
//                    p -= 5;
//                    count++;
//                }
//            }
//            if((o-5)%6 != 0 && o < 41){
//                if(board.whatsOnTile(o, col)){
//                    o += 5;
//                    count++;
//                }
//            }
//            System.out.println("cont " + count);
//            if(count == 4){
//                return true;
//            }
//        }
//        return false;
//    }
//    //Slash \\\\\
//    public boolean slash(int place, int col){
//        int count = 1;
//        int p = place, o = place;
//        
//        p -= 7;
//        o += 7;
//        
//        for(int i = 0; i < 3; i++){
//            if((p+6)%6 != 0 && p > 0){
//                if(board.whatsOnTile(p, col)){
//                    p -= 7;
//                    count++;
//                }
//            }
//            if((o-7)%6 != 0 && o < 41){
//                if(board.whatsOnTile(o, col)){
//                    o += 7;
//                    count++;
//                }
//            }
//            System.out.println("cont " + count);
//            if(count == 4){
//                return true;
//            }
//        }
//        return false;
//    }
//    
//    
//    public void hasWon(int lastPlace, int lastCol){
//        //horizontal(lastPlace, lastCol) || vertical(lastPlace, lastCol) || 
//       
//            if(slash(lastPlace, lastCol)) {
//                System.out.println("Winner at " + lastPlace);
//            }
//        
////            if(slash(lastPlace, lastCol) || backSlash(lastPlace, lastCol) || vertical(lastPlace, lastCol) || horizontal(lastPlace, lastCol)){
////                
////            }
//            
//        
        
//    }
    
    public String whatColour(){
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
