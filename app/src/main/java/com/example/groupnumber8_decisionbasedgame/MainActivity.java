package com.example.groupnumber8_decisionbasedgame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.HtmlCompat;

import android.content.pm.ActivityInfo;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;

@SuppressWarnings("ALL")
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView name, textBox;
    ImageView character, background, logo,nameBG;
    Button button,  button2,  button3,  button4, extra, start;
    String[] array;
    String choice;
    Drawable charImage, bgImage;
    MediaPlayer mediaPlayer;

    int arrayID;
    int characterID;
    int backgroundID;

    int buttonVal;
    int scenarioVal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //buttons
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        extra = findViewById(R.id.button5);
        start = findViewById(R.id.start);

        //onClickListener
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        extra.setOnClickListener(this);
        start.setOnClickListener(this);

        //text and image View
        name = findViewById(R.id.textView);
        textBox = findViewById(R.id.textView2);
        character = findViewById(R.id.imageView);
        background = findViewById(R.id.imageView2);
        logo = findViewById(R.id.logo);
        nameBG = findViewById(R.id.nameBG);

        mediaPlayer();

        //start
        start();
    }

    @Override
    public void onClick(View v) {
        textBox = findViewById(R.id.textView2);
        switch (v.getId()) {
            case R.id.button:
                buttonVal = 4; // Assigning each button an integer
                scenario();
                break;
            case R.id.button2:
                buttonVal = 3; // Assigning each button an integer
                scenario();
                break;
            case R.id.button3:
                buttonVal = 2; // Assigning each button an integer
                scenario();
                break;
            case R.id.button4:
                buttonVal = 1; // Assigning each button an integer
                scenario();
                break;
            case R.id.button5:
                buttonVal = 0; // Assigning each button an integer
                scenario();
                break;
            case R.id.start:
                scenario();
        }
    }

    //bgm
    public void mediaPlayer() {
        mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.bg_music);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
    }

    //Starting screeen
    public void start() {
        logo.setVisibility(View.VISIBLE);
        start.setVisibility(View.VISIBLE);
        nameBG.setVisibility(View.INVISIBLE);
        textBox.setVisibility(View.INVISIBLE);
        button.setVisibility(View.INVISIBLE);
        button2.setVisibility(View.INVISIBLE);
        button3.setVisibility(View.INVISIBLE);
        button4.setVisibility(View.VISIBLE);
        extra.setVisibility(View.INVISIBLE);
        name.setVisibility(View.INVISIBLE);
        character.setVisibility(View.INVISIBLE);
        textBox.setVisibility(View.INVISIBLE);
        start.setEnabled(true);
        button.setEnabled(false);
        button2.setEnabled(false);
        button3.setEnabled(false);
        button4.setEnabled(false);
        extra.setEnabled(false);
    }

    public void scenario() {
        if(scenarioVal == 0) {// Starts from Scenario_0
            array = getResources().getStringArray(R.array.Scenario_0);
        } else {// Scenario changes depending on scenarioVal+buttonVal
            choice = array[scenarioVal+buttonVal];
            arrayID = getResources().getIdentifier(choice, "array", getPackageName());
            array = getResources().getStringArray(arrayID);
        }
        if (array.length == 13) {//4 Choices, no exta button
            logo.setVisibility(View.GONE);
            start.setVisibility(View.GONE);
            textBox.setVisibility(View.VISIBLE);
            nameBG.setVisibility(View.INVISIBLE);
            button.setVisibility(View.VISIBLE);
            button2.setVisibility(View.VISIBLE);
            button3.setVisibility(View.VISIBLE);
            button4.setVisibility(View.VISIBLE);
            extra.setVisibility(View.INVISIBLE);
            name.setVisibility(View.INVISIBLE);
            character.setVisibility(View.INVISIBLE);
            textBox.setVisibility(View.VISIBLE);
            start.setEnabled(false);
            button.setEnabled(true);
            button2.setEnabled(true);
            button3.setEnabled(true);
            button4.setEnabled(true);
            extra.setEnabled(false);
            textBox.setText(HtmlCompat.fromHtml(array[0],HtmlCompat.FROM_HTML_MODE_COMPACT));
            button.setText(array[1]);
            button2.setText(array[2]);
            button3.setText(array[3]);
            button4.setText(array[4]);
            extra.setText(array[5]);
            backgroundID = getResources().getIdentifier(array[6] , "drawable", getPackageName());
            bgImage =getResources().getDrawable(backgroundID);
            background.setImageDrawable(bgImage);
            // Assigning array.length an integer
            scenarioVal = 7;
        }
        if (array.length == 12) {// 4 choices
            logo.setVisibility(View.GONE);
            start.setVisibility(View.GONE);
            textBox.setVisibility(View.VISIBLE);
            nameBG.setVisibility(View.INVISIBLE);
            button.setVisibility(View.VISIBLE);
            button2.setVisibility(View.VISIBLE);
            button3.setVisibility(View.VISIBLE);
            button4.setVisibility(View.VISIBLE);
            extra.setVisibility(View.VISIBLE);
            name.setVisibility(View.INVISIBLE);
            character.setVisibility(View.INVISIBLE);
            textBox.setVisibility(View.VISIBLE);
            start.setEnabled(false);
            button.setEnabled(true);
            button2.setEnabled(true);
            button3.setEnabled(true);
            button4.setEnabled(true);
            extra.setEnabled(true);
            textBox.setText(HtmlCompat.fromHtml(array[0],HtmlCompat.FROM_HTML_MODE_COMPACT));
            button.setText(array[1]);
            button2.setText(array[2]);
            button3.setText(array[3]);
            button4.setText(array[4]);
            extra.setText(array[5]);
            backgroundID = getResources().getIdentifier(array[6] , "drawable", getPackageName());
            bgImage =getResources().getDrawable(backgroundID);
            background.setImageDrawable(bgImage);
            // Assigning array.length an integer
            scenarioVal = 7;
        }
        if (array.length == 10) { //3 choices
            logo.setVisibility(View.GONE);
            start.setVisibility(View.GONE);
            textBox.setVisibility(View.VISIBLE);
            nameBG.setVisibility(View.INVISIBLE);
            button.setVisibility(View.INVISIBLE);
            button2.setVisibility(View.VISIBLE);
            button3.setVisibility(View.VISIBLE);
            button4.setVisibility(View.VISIBLE);
            extra.setVisibility(View.VISIBLE);
            name.setVisibility(View.INVISIBLE);
            character.setVisibility(View.INVISIBLE);
            textBox.setVisibility(View.VISIBLE);
            start.setEnabled(false);
            button.setEnabled(false);
            button2.setEnabled(true);
            button3.setEnabled(true);
            button4.setEnabled(true);
            extra.setEnabled(true);
            textBox.setText(HtmlCompat.fromHtml(array[0],HtmlCompat.FROM_HTML_MODE_COMPACT));
            button2.setText(array[1]);
            button3.setText(array[2]);
            button4.setText(array[3]);
            extra.setText(array[4]);
            backgroundID = getResources().getIdentifier(array[5] , "drawable", getPackageName());
            bgImage =getResources().getDrawable(backgroundID);
            background.setImageDrawable(bgImage);
            // Assigning array.length an integer
            scenarioVal = 6;
        }
        if (array.length == 9) {//1 Choice
            logo.setVisibility(View.GONE);
            start.setVisibility(View.GONE);
            textBox.setVisibility(View.VISIBLE);
            nameBG.setVisibility(View.INVISIBLE);
            button.setVisibility(View.INVISIBLE);
            button2.setVisibility(View.INVISIBLE);
            button3.setVisibility(View.VISIBLE);
            button4.setVisibility(View.INVISIBLE);
            extra.setVisibility(View.VISIBLE);
            name.setVisibility(View.INVISIBLE);
            character.setVisibility(View.INVISIBLE);
            textBox.setVisibility(View.VISIBLE);
            start.setEnabled(false);
            button.setEnabled(false);
            button2.setEnabled(false);
            button3.setEnabled(true);
            button4.setEnabled(false);
            extra.setEnabled(true);
            textBox.setText(HtmlCompat.fromHtml(array[0],HtmlCompat.FROM_HTML_MODE_COMPACT));
            button3.setText(array[1]);
            button4.setText(array[2]);
            extra.setText(array[3]);
            backgroundID = getResources().getIdentifier(array[4] , "drawable", getPackageName());
            bgImage =getResources().getDrawable(backgroundID);
            background.setImageDrawable(bgImage);
            // Assigning array.length an integer
            scenarioVal = 5;
        }
        if (array.length == 8) { //2 choices
            logo.setVisibility(View.GONE);
            start.setVisibility(View.GONE);
            textBox.setVisibility(View.VISIBLE);
            nameBG.setVisibility(View.INVISIBLE);
            button.setVisibility(View.INVISIBLE);
            button2.setVisibility(View.INVISIBLE);
            button3.setVisibility(View.VISIBLE);
            button4.setVisibility(View.VISIBLE);
            extra.setVisibility(View.VISIBLE);
            name.setVisibility(View.INVISIBLE);
            character.setVisibility(View.INVISIBLE);
            textBox.setVisibility(View.VISIBLE);
            start.setEnabled(false);
            button.setEnabled(false);
            button2.setEnabled(false);
            button3.setEnabled(true);
            button4.setEnabled(true);
            extra.setEnabled(true);
            textBox.setText(HtmlCompat.fromHtml(array[0],HtmlCompat.FROM_HTML_MODE_COMPACT));
            button3.setText(array[1]);
            button4.setText(array[2]);
            extra.setText(array[3]);
            backgroundID = getResources().getIdentifier(array[4] , "drawable", getPackageName());
            bgImage =getResources().getDrawable(backgroundID);
            background.setImageDrawable(bgImage);
            // Assigning array.length an integer
            scenarioVal = 5;
        }
        if (array.length == 7) {//2 choices, no extra button
            logo.setVisibility(View.GONE);
            start.setVisibility(View.GONE);
            textBox.setVisibility(View.VISIBLE);
            nameBG.setVisibility(View.INVISIBLE);
            button.setVisibility(View.INVISIBLE);
            button2.setVisibility(View.INVISIBLE);
            button3.setVisibility(View.VISIBLE);
            button4.setVisibility(View.VISIBLE);
            extra.setVisibility(View.INVISIBLE);
            name.setVisibility(View.INVISIBLE);
            character.setVisibility(View.INVISIBLE);
            textBox.setVisibility(View.VISIBLE);
            start.setEnabled(false);
            button.setEnabled(false);
            button2.setEnabled(false);
            button3.setEnabled(true);
            button4.setEnabled(true);
            extra.setEnabled(false);
            textBox.setText(HtmlCompat.fromHtml(array[0],HtmlCompat.FROM_HTML_MODE_COMPACT));
            button3.setText(array[1]);
            button4.setText(array[2]);
            extra.setText(array[3]);
            backgroundID = getResources().getIdentifier(array[4] , "drawable", getPackageName());
            bgImage =getResources().getDrawable(backgroundID);
            background.setImageDrawable(bgImage);
            // Assigning array.length an integer
            scenarioVal = 4;
        }
        if (array.length == 6) { //no choices
            logo.setVisibility(View.GONE);
            start.setVisibility(View.GONE);
            textBox.setVisibility(View.VISIBLE);
            button.setVisibility(View.INVISIBLE);
            button2.setVisibility(View.INVISIBLE);
            button3.setVisibility(View.INVISIBLE);
            button4.setVisibility(View.INVISIBLE);
            extra.setVisibility(View.VISIBLE);
            name.setVisibility(View.VISIBLE);
            character.setVisibility(View.VISIBLE);
            nameBG.setVisibility(View.VISIBLE);
            textBox.setVisibility(View.VISIBLE);
            start.setEnabled(false);
            button.setEnabled(false);
            button2.setEnabled(false);
            button3.setEnabled(false);
            button4.setEnabled(false);
            extra.setEnabled(true);
            textBox.setText(HtmlCompat.fromHtml(array[0],HtmlCompat.FROM_HTML_MODE_COMPACT));
            extra.setText(array[1]);
            name.setText(array[2]);
            characterID = getResources().getIdentifier(array[3] , "drawable", getPackageName());
            charImage =getResources().getDrawable(characterID);
            character.setImageDrawable(charImage);
            backgroundID = getResources().getIdentifier(array[4] , "drawable", getPackageName());
            bgImage =getResources().getDrawable(backgroundID);
            background.setImageDrawable(bgImage);
            // Assigning array.length an integer
            scenarioVal = 5;
        }
        if (array.length == 5) { //no choices, no name
            logo.setVisibility(View.GONE);
            start.setVisibility(View.GONE);
            textBox.setVisibility(View.VISIBLE);
            nameBG.setVisibility(View.INVISIBLE);
            button.setVisibility(View.INVISIBLE);
            button2.setVisibility(View.INVISIBLE);
            button3.setVisibility(View.INVISIBLE);
            button4.setVisibility(View.INVISIBLE);
            extra.setVisibility(View.VISIBLE);
            name.setVisibility(View.INVISIBLE);
            character.setVisibility(View.VISIBLE);
            textBox.setVisibility(View.VISIBLE);
            start.setEnabled(false);
            button.setEnabled(false);
            button2.setEnabled(false);
            button3.setEnabled(false);
            button4.setEnabled(false);
            extra.setEnabled(true);
            textBox.setText(HtmlCompat.fromHtml(array[0],HtmlCompat.FROM_HTML_MODE_COMPACT));
            extra.setText(array[1]);
            characterID = getResources().getIdentifier(array[2] , "drawable", getPackageName());
            charImage =getResources().getDrawable(characterID);
            character.setImageDrawable(charImage);
            backgroundID = getResources().getIdentifier(array[3] , "drawable", getPackageName());
            bgImage =getResources().getDrawable(backgroundID);
            background.setImageDrawable(bgImage);
            // Assigning array.length an integer
            scenarioVal = 4;
        }
        if (array.length == 4) { //no choices, no name, no character image
            logo.setVisibility(View.GONE);
            start.setVisibility(View.GONE);
            nameBG.setVisibility(View.INVISIBLE);
            button.setVisibility(View.INVISIBLE);
            button2.setVisibility(View.INVISIBLE);
            button3.setVisibility(View.INVISIBLE);
            button4.setVisibility(View.INVISIBLE);
            extra.setVisibility(View.VISIBLE);
            name.setVisibility(View.INVISIBLE);
            character.setVisibility(View.INVISIBLE);
            textBox.setVisibility(View.VISIBLE);
            start.setEnabled(false);
            button.setEnabled(false);
            button2.setEnabled(false);
            button3.setEnabled(false);
            button4.setEnabled(false);
            extra.setEnabled(true);
            textBox.setText(HtmlCompat.fromHtml(array[0],HtmlCompat.FROM_HTML_MODE_COMPACT));
            extra.setText(array[1]);
            backgroundID = getResources().getIdentifier(array[2] , "drawable", getPackageName());
            bgImage =getResources().getDrawable(backgroundID);
            background.setImageDrawable(bgImage);
            // Assigning array.length an integer
            scenarioVal = 3;
        }
        if (array.length == 3) { //END
            logo.setVisibility(View.GONE);
            start.setVisibility(View.GONE);
            nameBG.setVisibility(View.INVISIBLE);
            button.setVisibility(View.INVISIBLE);
            button2.setVisibility(View.INVISIBLE);
            button3.setVisibility(View.INVISIBLE);
            button4.setVisibility(View.VISIBLE);
            extra.setVisibility(View.INVISIBLE);
            name.setVisibility(View.INVISIBLE);
            character.setVisibility(View.INVISIBLE);
            textBox.setVisibility(View.INVISIBLE);
            start.setEnabled(false);
            button.setEnabled(false);
            button2.setEnabled(false);
            button3.setEnabled(false);
            button4.setEnabled(true);
            extra.setEnabled(false);
            button4.setText(array[0]);
            // Assigning array.length an integer
            scenarioVal = 1;
        }
    }
}