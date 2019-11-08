package com.example.diceroller;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.lang.String;

public class MainActivity extends AppCompatActivity {
    int count = 0;
    static ArrayList <String> questions = new ArrayList();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        questions.add("If you could go anywhere in the world, where would you go?");
        questions.add("If you were stranded on a desert island, what three things would you want to take with you?");
        questions.add("If you could eat only one food for the rest of your life, what would that be?");
        questions.add("If you won a million dollars, what is the first thing you would buy?");
        questions.add("If you could spaned the day with one fictional character, who would it be?");
        questions.add("If you found a magic lantern and a genie gave you three wishes, what would you wish?");


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void on_button_click(View view) {

        TextView tv = this.findViewById(R.id.NumbertextView);
        Random r = new Random();
        int number = r.nextInt(6);
        tv.setText(Integer.toString(number));

        EditText editor = this.findViewById(R.id.editText);

        TextView Congrats = this.findViewById(R.id.textView);

        TextView counting = this.findViewById(R.id.textView4);


        Integer get_number = Integer.valueOf(editor.getText().toString());

        if (get_number == number) {
            Congrats.setVisibility(View.VISIBLE);
            count++;
            counting.setText(Integer.toString(count));
        } else {
            Congrats.setVisibility(View.INVISIBLE);
        }


    }

    public void d_icebreakers(View view){
        roll_the_dice(questions.size());
        TextView display_questions = this.findViewById(R.id.textView2);
        int array_size=roll_the_dice(questions.size());
        display_questions.setText(questions.get(array_size));


    }



    public int roll_the_dice(int n){
        TextView tv = this.findViewById(R.id.NumbertextView);

        Random random=new Random();
        int rand=random.nextInt(6);
        tv.setText(Integer.toString(rand));
        return rand;

    }













}


