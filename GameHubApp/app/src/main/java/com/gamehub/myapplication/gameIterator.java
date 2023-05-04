package com.gamehub.myapplication;

import java.util.ArrayList;
import java.util.Arrays;

public class gameIterator implements IteratorContainer{
    // testing
    games Mario = new games(10, "Mario", "Nintendo", 4.0, new ArrayList<>());
    games AssassinsCreed = new games(8, "Assassins Creed", "Ubisoft", 3.0, new ArrayList<>());
    games CallofDutyBlackOps2 = new games(19, "Call of Duty Black Ops 2", "Activision", 5.0, new ArrayList<>());
    games RainbowSixSiedge = new games(88, "Rainbow Six Siedge", "Ubisoft", 3.0, new ArrayList<>());

    public games tempGames[] = {Mario, AssassinsCreed, CallofDutyBlackOps2, RainbowSixSiedge};

    @Override
    public IteratorPattern returnIteratorPattern(){
        return new GameIterator();
    }

    private class GameIterator implements IteratorPattern{

        int index;

        @Override
        public boolean validNext(){
            if(index < tempGames.length){
                return true;
            }else{
                return false;
            }
        }

        @Override
        public Object next(){
            if(this.validNext()){
                return tempGames[index++];
            }else{
                return null;
            }
        }

        // refernece: https://www.educative.io/answers/what-is-the-arraylistcontains-method-in-java
        @Override
        public void removeGame(games rGame){
            if(Arrays.asList(tempGames).contains(rGame)){
                Arrays.asList(tempGames).remove(rGame);
            }else{
                throw new NullPointerException("Game did not exsist, couldn't remove");
            }
        }

        @Override
        public void removeUser(users uNot){
            //
        }
    }

}
