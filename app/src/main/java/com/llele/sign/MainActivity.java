package com.llele.sign;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    SignView mSignView;
    SignLinesView mSignLinesView;
    EditText edt_signDays,edt_signScore;
    Button btn_changeSignDays,btn_changeSignScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSignView = (SignView) findViewById(R.id.signView);
        mSignLinesView = (SignLinesView) findViewById(R.id.signLineView);
        edt_signDays = (EditText) findViewById(R.id.edt_signDays);
        edt_signScore = (EditText)findViewById(R.id.edt_signScore);
        btn_changeSignDays = (Button)findViewById(R.id.btn_changeSignDays);
        btn_changeSignScore = (Button)findViewById(R.id.btn_changeSignScore);
        btn_changeSignDays.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(edt_signDays.getText().toString())){
                    mSignView.setSignDay(Integer.valueOf(edt_signDays.getText().toString()));
                    mSignLinesView.setSignDays(Integer.valueOf(edt_signDays.getText().toString()));
                }
            }
        });
        btn_changeSignScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(edt_signScore.getText().toString())) {
                    mSignView.setSignScore(Integer.valueOf(edt_signScore.getText().toString()));
                }
            }
        });
    }

}
