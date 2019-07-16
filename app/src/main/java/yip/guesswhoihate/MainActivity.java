package yip.guesswhoihate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public ImageView img_peter;
    public ImageView img_laxfax;
    public ImageView img_furb;

    public String choice;

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

        Toast.makeText(getApplicationContext(),"Add onclick-listeners",Toast.LENGTH_LONG).show();

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

        choice = character_chosen;
        Toast.makeText(this, choice, Toast.LENGTH_SHORT).show();

    }

}
