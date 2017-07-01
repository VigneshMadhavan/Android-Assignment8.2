package com.example.vimadhavan.assignment82;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText nameTxt, ageTxt, phoneTxt, cityTxt;
    Button saveBtn, showBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameTxt = (EditText)findViewById(R.id.nameTxt);
        ageTxt = (EditText)findViewById(R.id.ageTxt);
        phoneTxt = (EditText)findViewById(R.id.phoneTxt);
        cityTxt = (EditText)findViewById(R.id.cityTxt);
        saveBtn = (Button)findViewById(R.id.saveBtn);
        showBtn = (Button)findViewById(R.id.showBtn);
        saveBtn.setOnClickListener(this);
        showBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        SharedPreferences sp = getSharedPreferences("myData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();

        switch (v.getId()){
            case R.id.saveBtn:
                editor.putString(Constants.NAME, nameTxt.getText().toString().trim());
                editor.putString(Constants.AGE, ageTxt.getText().toString().trim());
                editor.putString(Constants.PHONE, phoneTxt.getText().toString().trim());
                editor.putString(Constants.CITY, cityTxt.getText().toString().trim());
                editor.commit();

                break;
            case R.id.showBtn:
                String msg= "Name: "+ sp.getString(Constants.NAME,"")+ "\n"+
                        "Age: "+ sp.getString(Constants.AGE,"")+ "\n"+
                        "Phone: "+ sp.getString(Constants.PHONE,"")+ "\n"+
                        "City: "+sp.getString(Constants.CITY,"")+ "\n";
                Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
                break;
        }
    }
}
