package com.example.ma18room;

import java.util.ArrayList;
import java.util.List;

/*
*   Exempel på singleton!
*   Används inte i detta projekt!!!!
*
*/
class ScoreBoard {

    private List<String> points;


    private static ScoreBoard ourInstance;

    static ScoreBoard getInstance() {
        if ( ourInstance == null)
            ourInstance = new ScoreBoard();

        return ourInstance;
    }

    private ScoreBoard() {
        points = new ArrayList<>();


        points.add("David");
    }

    public List<String> getPoints() {
        return points;
    }

}
