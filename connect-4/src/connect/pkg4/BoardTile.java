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
    private Colour colour; //3 = nothinbg 1 = red, 0 = yellow
    private int arraypos = 0;
    
    public enum Colour {
        RED,
        YELLOW,
        WHITE //empty
    }
    
    public BoardTile(boolean fill, Colour col, int pos){
        filled = fill;
        colour = col;
        arraypos = pos;
    }
    
    public boolean isFilled(){
        return filled;
    }
    
    public int getPos(){
        return arraypos;
    }
    
    public void fillTile(){
        filled = true;
    }
    
    public void emptyTile(){
        filled = false;
        colour = Colour.WHITE;
    }
    
    public Colour getColour(){
        return colour;
    }
    
    public void setColour(Colour c){
        colour = c;
    }
    
    public String toString(){
        String s = colour + "";
        return s;
    }
}
//"\n=========================\n Array Pos:" + arraypos + "\nTile filled:" + filled + "\n Colour: " + colour + "\n=========================";