/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect.pkg4;

import java.util.Random;

/**
 *
 * @author harry
 */
public class DefensiveAi {
    public void runAI(BoardGui gui, Game game, int lastPos){
        if(game.checkForWin(lastPos, 3)){
            game.addCounterVisual(genRanNum(), gui);
        }
        game.addCounterVisual(genRanNum(), gui);
        System.out.println(genRanNum());
    }
    
    public int genRanNum(){
        int[] randomNum = {0, 6, 12, 18, 24, 30, 36};
        Random r = new Random();
        int randomIndex = r.nextInt(randomNum.length);
        return randomNum[randomIndex];
    }
}
