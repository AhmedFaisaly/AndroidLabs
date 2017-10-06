package com.example.mypc.androidlabs;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class LoginActivity extends Activity {
    EditText edText;
    Button loginBtn ;
    TextView lastInput;
    protected static final String ACTIVITY_NAME = "StartActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.i(ACTIVITY_NAME, "In onCreate()");
        loginBtn =(Button) findViewById(R.id.button2);
        edText=(EditText) findViewById(R.id.editText2);
        lastInput = (TextView) findViewById(R.id.lastUserInput);
        String textFromShared;

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences sp = getSharedPreferences(getString(R.string.setting), Context.MODE_PRIVATE);
                Editor edit= sp.edit();
                edit.putString("userEmail",edText.getText().toString());
                edit.commit();

                edText.setText( sp.getString("userEmail", "Email address??")); //last input to be viewed on next start
                Intent intent = new Intent(LoginActivity.this,StartActivity.class);
                startActivity(intent);}
            });
        }//onCreate end


    @Override
    protected void onStart(){
        SharedPreferences sp = getSharedPreferences(getString(R.string.setting), Context.MODE_PRIVATE);
        super.onStart();
        Log.i(ACTIVITY_NAME, "In onStart()");
        edText.setText( sp.getString("userEmail", "Email address??"));

    };

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.i(ACTIVITY_NAME, "In onRestart()");
    };

    @Override
    protected void onResume(){
        super.onResume();
        Log.i(ACTIVITY_NAME, "In onResume()");
    };

    @Override
    protected void onPause(){
        super.onPause();
        Log.i(ACTIVITY_NAME, "In onPause()");
    };

    @Override
    protected void onStop(){
        super.onStop();
        Log.i(ACTIVITY_NAME, "In onStop()");
    };

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i(ACTIVITY_NAME, "In onDestroy()");
    };

}