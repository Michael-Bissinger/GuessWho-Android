package yip.guesswhoihate;

import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public ImageView img_peter;
    public ImageView img_laxfax;
    public ImageView img_furb;

    public String userchoice;
    public String machinechoice;
    public String scoremessage;

    public int win_score = 0;
    public int fail_score = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img_peter = findViewById(R.id._img_peterlustig);
        img_laxfax = findViewById(R.id._img_laxfax);
        img_furb = findViewById(R.id._img_furb);

    }


    @Override
    protected void onResume() {
        super.onResume();

        //Toast.makeText(getApplicationContext(),"Add onclick-listeners",Toast.LENGTH_LONG).show();

        img_peter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startGame("Peter Lustig");
            }
        });

        img_laxfax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startGame("LaxFax");
            }
        });

        img_furb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startGame("Furb");
            }
        });


    }

    @Override
    protected void onPause() {
        super.onPause();

        img_peter.setOnClickListener(null);
        img_laxfax.setOnClickListener(null);
        img_furb.setOnClickListener(null);

    }

    private void startGame (String character_chosen) {

        userchoice = character_chosen;
        //Toast.makeText(this, "You choose: " +userchoice, Toast.LENGTH_SHORT).show();

        Random randomGenerator = new Random();
        int numberofChoice = randomGenerator.nextInt(3);

        switch (numberofChoice) {
            case 0:
                machinechoice = "Peter Lustig";
                break;
            case 1:
                machinechoice = "LaxFax";
                break;
            case 2:
                machinechoice = "Furb";
                break;
        }

        Toast.makeText(this,"You choose: " + userchoice + ". I hate: " + machinechoice,Toast.LENGTH_SHORT).show();

        if (userchoice == machinechoice) {

            gameReaction(true);
            manageScore(true);

        }   else {

            gameReaction(false);
            manageScore(false);

        }


        showScore();

    }

    private void gameReaction (boolean win) {

        if (win == true) {
            //Toast.makeText(this, "Richtig!", Toast.LENGTH_SHORT).show();
            setBackgroundColor("holo_green_light");
            win_score++;

        } else {
            //Toast.makeText(this, "Falsch!", Toast.LENGTH_SHORT).show();
            setBackgroundColor("holo_red_light");
            fail_score++;
        }

    }

    private void setBackgroundColor (String answercolor) {

        String color = answercolor;

        //setContentView(R.layout.activity_main);

        // Find the layout
        View someView = findViewById(R.id.activ_layout);
        View root = someView.getRootView();

        // Set the color
        switch (color) {
            case "holo_green_light":
                root.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
                break;
            case "holo_red_light" :
                root.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
                break;
        }


    }

    private void manageScore(boolean win) {
        // open the database
        // write/update score in it



        if (win == true) {
            ScoreHelper.addWinScore(getApplicationContext());
        } else {
            ScoreHelper.addFailScore(getApplicationContext());
        }

    }

    private void showScore() {

        int current_win_score = ScoreHelper.getWinScore(getApplicationContext());
        int current_fail_score = ScoreHelper.getFailScore(getApplicationContext());

        // create a String which adds the Score in it
        //scoremessage = "Win: " + current_win_score + " Fail: " + current_fail_score;
        scoremessage = "Win: " + win_score + " Fail: " + fail_score;

        final View myview = findViewById(android.R.id.content);

        // display the String in a Snackbar
        Snackbar.make(myview, scoremessage,Snackbar.LENGTH_SHORT).show();


    }

}
