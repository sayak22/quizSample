package com.example.quizsample;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button prev,nxt;
    TextView qno,ques;
    ImageView img;
    Button opt1 ,opt2, opt3, opt4;
    String[] question = {"What is the name of the fruit","What is the name of the animal","What is the name of this device"};
//    String[] image = {"banana","dog","laptop"};
    String[] option1 = {"MANGO","CAT","MOUSE"};
    String[] option2 = {"APPLE","DOG","MONITOR"};
    String[] option3 = {"BANANA","COW","SPEAKER"};
    String[] option4 = {"GUAVA","LION","LAPTOP"};
    int[] answer = {3,2,4};
    int cur=0, maxi=2; boolean isActive=true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // android components
         prev= findViewById(R.id.previous);
         nxt= findViewById(R.id.next);
         qno= findViewById(R.id.qnumber);
         ques = findViewById(R.id.question);
         img = findViewById(R.id.image);
         opt1 = findViewById(R.id.opt1);
         opt2 = findViewById(R.id.opt2);
         opt3 = findViewById(R.id.opt3);
         opt4 = findViewById(R.id.opt4);

        nxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isActive=true;
                    // updating the current question value
                    cur++;
                    qno.setText((cur+1)+" out of "+ (maxi+1));
                    // visibility of previous and next button at the left and right extremities are taken care of
                    if(cur==0){
                        nxt.setVisibility(view.VISIBLE);
                        prev.setVisibility(view.INVISIBLE);
                    }
                    else if(cur==maxi) {
                        prev.setVisibility(view.VISIBLE);
                        nxt.setVisibility(view.INVISIBLE);
                    }
                    else{
                        prev.setVisibility(view.VISIBLE);
                        nxt.setVisibility(view.VISIBLE);
                    }

                    // question updated
                    ques.setText("Q. "+question[cur]+"?");
                    //image updated
                    switch (cur){
                        case 0: img.setImageResource(R.drawable.banana); break;
                        case 1: img.setImageResource(R.drawable.dog); break;
                        case 2: img.setImageResource(R.drawable.laptop); break;
                        default: break;
                    }
                    //options updated
                    opt1.setText(option1[cur]);
                    opt2.setText(option2[cur]);
                    opt3.setText(option3[cur]);
                    opt4.setText(option4[cur]);

                opt1.setBackgroundColor(Color.parseColor("#93BFB7"));
                opt2.setBackgroundColor(Color.parseColor("#93BFB7"));
                opt3.setBackgroundColor(Color.parseColor("#93BFB7"));
                opt4.setBackgroundColor(Color.parseColor("#93BFB7"));
            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isActive=true;
                    // updating the current question value
                    cur--;
                    qno.setText((cur+1)+" out of "+ (maxi+1));
                    // visibility of previous and next button at the left and right extremities are taken care of
                    if(cur==0){
                        nxt.setVisibility(view.VISIBLE);
                        prev.setVisibility(view.INVISIBLE);
                    }
                    else if(cur==maxi) {
                        prev.setVisibility(view.VISIBLE);
                        nxt.setVisibility(view.INVISIBLE);
                    }
                    else{
                        prev.setVisibility(view.VISIBLE);
                        nxt.setVisibility(view.VISIBLE);
                    }

                    // question updated
                    ques.setText("Q. "+question[cur]+"?");
                    //image updated
                    switch (cur){
                        case 0: img.setImageResource(R.drawable.banana); break;
                        case 1: img.setImageResource(R.drawable.dog); break;
                        case 2: img.setImageResource(R.drawable.laptop); break;
                        default: break;
                    }
                    //options updated
                    opt1.setText(option1[cur]);
                    opt2.setText(option2[cur]);
                    opt3.setText(option3[cur]);
                    opt4.setText(option4[cur]);

                opt1.setBackgroundColor(Color.parseColor("#93BFB7"));
                opt2.setBackgroundColor(Color.parseColor("#93BFB7"));
                opt3.setBackgroundColor(Color.parseColor("#93BFB7"));
                opt4.setBackgroundColor(Color.parseColor("#93BFB7"));

            }
        });


    }

    public void lock(View view) {
        TextView tv= (TextView) view;
        int selected = 0;
        switch (view.getId()){
            case R.id.opt1: selected=1; break;
            case R.id.opt2: selected=2; break;
            case R.id.opt3: selected=3; break;
            case R.id.opt4: selected=4; break;
            default:break;
        }
        if(isActive) {
            if (answer[cur] == selected)
                view.setBackgroundColor(Color.parseColor("#008000"));
            else
                view.setBackgroundColor(Color.parseColor("#ff0000"));
        }
        isActive=false;
    }

    public void resetClick(View view) {
        isActive=true;
        opt1.setBackgroundColor(Color.parseColor("#93BFB7"));
        opt2.setBackgroundColor(Color.parseColor("#93BFB7"));
        opt3.setBackgroundColor(Color.parseColor("#93BFB7"));
        opt4.setBackgroundColor(Color.parseColor("#93BFB7"));

    }
}