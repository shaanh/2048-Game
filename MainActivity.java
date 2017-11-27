package edu.purdue.shoda.cs180lab11;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import java.util.Stack;

/**
 * MainActivity class that serves the same purpose to an Android app as the heart does to humans
 * Basically, the most important class of the app
 *
 * @author Sahil Pujari (pujari@purdue.edu)
 * @author Tori Shurman (vshurman@purdue.edu)
 */
public class MainActivity extends AppCompatActivity {


    //The context of the app. Context is used to refer to certain resources of the app outside of
    //the MainActivity class
    private static Context mContext;

    /**
     * Get the context of the app
     *
     * @return the context of the app
     */
    public static Context getAppContext() {
        return mContext;
    }

    //An object of our TwentyFortyEight class
    private TwentyFortyEight twentyFortyEight;

    //An object of CustomGrid class
    private CustomGrid customGrid;

    //The score box text in the app
    private TextView scoreBox;

    private SoundEffects soundEffects;

    Stack<int[][]> undostack = new Stack<>();
    Stack<int[][]> redostack = new Stack<int[][]>();

    /**
     * Called when the activity is starting.  This is where most initialization
     * should go.
     *
     * @param savedInstanceState If the activity is being re-initialized after
     *                           previously being shut down then this Bundle contains the data it most
     *                           recently supplied in {@link #onSaveInstanceState}.
     * @see #onSaveInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = getApplicationContext();
        twentyFortyEight = new TwentyFortyEight(4);
        customGrid = new CustomGrid();
        soundEffects = new SoundEffects(this);

        GridView grid = (GridView) findViewById(R.id.mainGrid);
        scoreBox = (TextView) findViewById(R.id.scoreBox);

        grid.setAdapter(customGrid);

        //TODO: Call the reset() method of your TwentyFortyClass to reset the board when the app
        //first starts
        twentyFortyEight.reset();
        int[][] array = new int[4][4];
        undostack.push(array);
    }

    /**
     * Method invoked when the Up button is pressed
     *
     * @param view - the UI of the app
     */
    public void upAction(View view) {
        //TODO 1: Use the moveUp method of TwentyFortyEight to implement the logic to be performed
        //TODO 2: Call the updateGrid method of CustomGrid and pass your TwentyFortyEight's board
        //as parameter
        //TODO 3: Use the scoreBox.setText() method to update the value of the score box based on
        //the score from your TwentyFortyEight

        //NOTE: You should pass the String value of score to setText. Eg. scoreBox.setText(String.valueOf(twentyFortyEighty.getScore()));
        int[][] array = new int[4][4];

        while (twentyFortyEight.moveUp()) {
            customGrid.updateGrid(twentyFortyEight.getBoard());
            scoreBox.setText("Score: " + String.valueOf(twentyFortyEight.getScore()));
        }
        twentyFortyEight.placeRandom();
        customGrid.updateGrid(twentyFortyEight.getBoard());
        soundEffects.playUpSound();
        for (int i = 0; i < twentyFortyEight.getBoard().length; i++) {
            for (int j = 0; j < twentyFortyEight.getBoard()[i].length ; j++) {
                array[i][j] = twentyFortyEight.getBoard()[i][j];
            }
        }
        redostack.clear();
        undostack.push(array);
    }

    /**
     * Method invoked when the Down button is pressed
     *
     * @param view - the UI of the app
     */
    public void downAction(View view) {
        //TODO 1: Use the moveUp method of TwentyFortyEight to implement the logic to be performed
        //TODO 2: Call the updateGrid method of CustomGrid and pass your TwentyFortyEight's board
        //as parameter
        //TODO 3: Use the scoreBox.setText() method to update the value of the score box based on
        //the score from your TwentyFortyEight

        //NOTE: You should pass the String value of score to setText. Eg. scoreBox.setText(String.valueOf(twentyFortyEighty.getScore()));
        int[][] array = new int[4][4];

        while (twentyFortyEight.moveDown()) {
            customGrid.updateGrid(twentyFortyEight.getBoard());
            scoreBox.setText("Score: " + String.valueOf(twentyFortyEight.getScore()));
        }
        twentyFortyEight.placeRandom();
        customGrid.updateGrid(twentyFortyEight.getBoard());
        soundEffects.playDownSound();
        for (int i = 0; i < twentyFortyEight.getBoard().length; i++) {
            for (int j = 0; j < twentyFortyEight.getBoard()[i].length ; j++) {
                array[i][j] = twentyFortyEight.getBoard()[i][j];
            }
        }
        redostack.clear();
        undostack.push(array);
    }

    /**
     * Method invoked when the Left button is pressed
     *
     * @param view - the UI of the app
     */
    public void leftAction(View view) {
        //TODO 1: Use the moveUp method of TwentyFortyEight to implement the logic to be performed
        //TODO 2: Call the updateGrid method of CustomGrid and pass your TwentyFortyEight's board
        //as parameter
        //TODO 3: Use the scoreBox.setText() method to update the value of the score box based on
        //the score from your TwentyFortyEight

        //NOTE: You should pass the String value of score to setText. Eg. scoreBox.setText(String.valueOf(twentyFortyEighty.getScore()));
        int[][] array = new int[4][4];

        while (twentyFortyEight.moveLeft()) {
            customGrid.updateGrid(twentyFortyEight.getBoard());
            scoreBox.setText("Score: " + String.valueOf(twentyFortyEight.getScore()));
        }
        twentyFortyEight.placeRandom();
        customGrid.updateGrid(twentyFortyEight.getBoard());
        soundEffects.playLeftSound();
        for (int i = 0; i < twentyFortyEight.getBoard().length; i++) {
            for (int j = 0; j < twentyFortyEight.getBoard()[i].length ; j++) {
                array[i][j] = twentyFortyEight.getBoard()[i][j];
            }
        }
        redostack.clear();
        undostack.push(array);
    }

    /**
     * Method invoked when the Right button is pressed
     *
     * @param view - the UI of the app
     */
    public void rightAction(View view) {
        //TODO 1: Use the moveUp method of TwentyFortyEight to implement the logic to be performed
        //TODO 2: Call the updateGrid method of CustomGrid and pass your TwentyFortyEight's board
        //as parameter
        //TODO 3: Use the scoreBox.setText() method to update the value of the score box based on
        //the score from your TwentyFortyEight

        //NOTE: You should pass the String value of score to setText. Eg. scoreBox.setText(String.valueOf(twentyFortyEighty.getScore()));
        int[][] array = new int[4][4];

        while (twentyFortyEight.moveRight()) {
            customGrid.updateGrid(twentyFortyEight.getBoard());
            scoreBox.setText("Score: " + String.valueOf(twentyFortyEight.getScore()));
        }
        twentyFortyEight.placeRandom();
        customGrid.updateGrid(twentyFortyEight.getBoard());
        soundEffects.playRightSound();
        for (int i = 0; i < twentyFortyEight.getBoard().length; i++) {
            for (int j = 0; j < twentyFortyEight.getBoard()[i].length ; j++) {
                array[i][j] = twentyFortyEight.getBoard()[i][j];
            }
        }
        redostack.clear();
        undostack.push(array);
    }

    public void resetAction(View view) {
        undostack.clear();
        redostack.clear();
        twentyFortyEight.reset();
        customGrid.reset();
        customGrid.updateGrid(twentyFortyEight.getBoard());
        soundEffects.playResetSound();
        scoreBox.setText("Score: " + String.valueOf(2));
        int[][] array = new int[4][4];
        for (int i = 0; i < twentyFortyEight.getBoard().length; i++) {
            for (int j = 0; j < twentyFortyEight.getBoard()[i].length ; j++) {
                array[i][j] = twentyFortyEight.getBoard()[i][j];
            }
        }
        undostack.push(array);
    }

    public void undoAction(View view) {
        if (undostack.size() > 1) {
            int score = 0;
            redostack.push(undostack.peek());
            undostack.pop();
            for (int i = 0; i < twentyFortyEight.getBoard().length; i++) {
                for (int j = 0; j < twentyFortyEight.getBoard()[i].length ; j++) {
                    twentyFortyEight.getBoard()[i][j] = undostack.peek()[i][j];
                    if (twentyFortyEight.getBoard()[i][j] > score) {
                        score = twentyFortyEight.getBoard()[i][j];
                        scoreBox.setText("Score: " + String.valueOf(score));
                    }
                    if (undostack.size() == 1) {
                        scoreBox.setText("Score: " + String.valueOf(2));
                    }
                }
            }
            customGrid.updateGrid(undostack.peek());
        }
    }

    public void redoAction(View view) {
        if (redostack.size() > 0) {
            int score = 0;
            for (int i = 0; i < twentyFortyEight.getBoard().length; i++) {
                for (int j = 0; j < twentyFortyEight.getBoard()[i].length ; j++) {
                    twentyFortyEight.getBoard()[i][j] = redostack.peek()[i][j];
                    if (twentyFortyEight.getBoard()[i][j] > score) {
                        score = twentyFortyEight.getBoard()[i][j];
                        scoreBox.setText("Score: " + String.valueOf(score));
                    }
                }
            }
            customGrid.updateGrid(redostack.peek());
            undostack.push(redostack.peek());
            redostack.pop();
        }
    }
}