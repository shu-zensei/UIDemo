package com.example.uidemo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView display;
    Button button1;
    Button button2;
    Button button3;
    Switch aSwitch;
    ProgressBar progressBar;
    ProgressBar progressBar2;
    ProgressBar progressBar3;
    EditText editText;
    RadioGroup radioGroup;
    RadioButton radioButton1;
    RadioButton radioButton2;
    ImageView imageView;
    SeekBar seekBar;
    CheckBox checkBox1;
    CheckBox checkBox2;
    CheckBox checkBox3;
    RatingBar ratingBar;
    String english="";
    String math = "";
    String japanese = "";

    String TAG = "custom_tag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.textView1);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        aSwitch = findViewById(R.id.switch1);
        progressBar = findViewById(R.id.progressBar);
        progressBar2 = findViewById(R.id.progressBar2);
        progressBar3 = findViewById(R.id.progressBar3);
        editText = findViewById(R.id.editTextNumber);
        radioGroup = findViewById(R.id.radioGroup1);
        radioButton1 = findViewById(R.id.radioButton1);
        radioButton2 = findViewById(R.id.radioButton2);
        imageView = findViewById(R.id.imageView);
        seekBar = findViewById(R.id.seekBar);
        checkBox1 = findViewById(R.id.checkBox);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        ratingBar = findViewById(R.id.ratingBar);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.setText("左へ");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.setText("右へ");
            }
        });

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    display.setText("オン");
                }else {
                    display.setText("オフ");
                }
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {

                String numStr = editText.getText().toString();
                if (TextUtils.isEmpty(numStr)) {
                    numStr = "0";
                }

                progressBar3.setProgress(Integer.valueOf(numStr), true);
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                Log.d(TAG, "radio i = " + checkedId);
                Log.d(TAG, "radioButton1 id = " + radioButton1.getId());
                Log.d(TAG, "radioButton2 id = " + radioButton2.getId());

//                if (radioButton1.isChecked()) {
//                    imageView.setImageResource(R.drawable.wolf);
//                } else {
//                    imageView.setImageResource(R.drawable.lion);
//                }

                if (checkedId == R.id.radioButton1) {
                    imageView.setImageResource(R.drawable.wolf);
                } else {
                    imageView.setImageResource(R.drawable.lion);
                }
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                display.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    japanese = "国語";
                } else {
                    japanese = "";
                }
                display.setText(japanese + math + english);
            }
        });

        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    math = "数学";
                } else {
                    math = "";
                }
                display.setText(japanese + math + english);
            }
        });

        checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    english = "英語";
                } else {
                    english = "";
                }
                display.setText(japanese + math + english);
            }
        });

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                Toast.makeText(getApplicationContext(), String.valueOf(v)+ "★評価！", Toast.LENGTH_SHORT).show();
            }
        });
    }
}