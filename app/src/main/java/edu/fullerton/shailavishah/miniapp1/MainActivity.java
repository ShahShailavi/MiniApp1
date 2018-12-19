package edu.fullerton.shailavishah.miniapp1;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText networkSpeed, fileSize;
    TextView textView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        networkSpeed = (EditText) findViewById(R.id.networkSpeed);
        fileSize = (EditText) findViewById(R.id.fileSize);
        textView4 = (TextView) findViewById(R.id.textView4);

        fileSize.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(networkSpeed.getText().toString().length() > 0 && fileSize.getText().toString().length() > 0  ){
                        Double dblNetworkSpeed = Double.parseDouble(networkSpeed.getText().toString());
                        Double dblFileSize = Double.parseDouble(fileSize.getText().toString());
                        textView4.setTextColor(Color.BLACK);
                        textView4.setText("Computed transfer time in seconds: " + new DecimalFormat("##.#").format((dblFileSize * 1024 * 1024 * 8) / (dblNetworkSpeed * 1000000)));
                }else{
                    textView4.setTextColor(Color.RED);
                    textView4.setText("Please enter above mentioned value");
                    }
                }
        });
        networkSpeed.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(networkSpeed.getText().toString().length() > 0 && fileSize.getText().toString().length() > 0 ){
                    Double dblNetworkSpeed = Double.parseDouble(networkSpeed.getText().toString());
                    Double dblFileSize = Double.parseDouble(fileSize.getText().toString());
                    textView4.setTextColor(Color.BLACK);
                    textView4.setText("Computed transfer time in seconds: " + new DecimalFormat("##.#").format((dblFileSize * 1024 * 1024 *8) / (dblNetworkSpeed * 1000000)));
                }else{
                    textView4.setTextColor(Color.RED);
                    textView4.setText("Please enter above mentioned value");
                }
            }
        });
        }
    }
