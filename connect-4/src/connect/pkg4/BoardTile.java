/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect.pkg4;

/**
 *
 * @author harry
 */
public class BoardTile {
    private boolean filled;
    private int colour; //0 = nothinbg 1 = red, 2 = blue
    private int arraypos = 0;
    
    public BoardTile(boolean fill, int col, int pos){
        filled = fill;
        colour = col;
        arraypos = pos;
    }
    
    public boolean isFilled(){
        return filled;
    }
    
    public void fillTile(){
        filled = true;
    }
    
    public int getColour(){
        return colour;
    }
    
    public void setColour(int c){
        colour = c;
    }
    
    public String toString(){
        String s = "=========================\n Array Pos:" + arraypos + "\nTile filled:" + filled + "\n Colour: " + colour + "\n=========================";
        return s;
    }
}
