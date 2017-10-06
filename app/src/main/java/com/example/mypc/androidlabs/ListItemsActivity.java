package com.example.mypc.androidlabs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;


public class ListItemsActivity extends Activity {

    ImageButton imgBtn;
    Switch sw;
    CharSequence text;
    int duration;
    CheckBox chbx;

    static final int REQUEST_IMAGE_CAPTURE = 1;
    protected static final String ACTIVITY_NAME = "ListItemsActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_items);
        Log.i(ACTIVITY_NAME, "In onCreate()");
        imgBtn = (ImageButton) findViewById(R.id.imageButton2);
        sw = (Switch) findViewById(R.id.switch3);
        chbx = (CheckBox) findViewById(R.id.checkBox4);

        imgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dispatchTakePictureIntent();
            }
        });

        sw.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(sw.isChecked()) {
                     text = "Switch is On";// "Switch is Off"
                     duration = Toast.LENGTH_SHORT; //= Toast.LENGTH_LONG if Off
                }
                else {
                     text = "Switch is Off";// "Switch is Off"
                     duration = Toast.LENGTH_LONG; //= Toast.LENGTH_LONG if Off

            }
                Toast toast = Toast.makeText(getApplicationContext() , text, duration); //this is the ListActivity
                toast.show(); //display your message box

            }
        });




        chbx.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ListItemsActivity.this);
                // 2. Chain together various setter methods to set the dialog characteristics
                builder.setMessage(R.string.dialog_message);
                builder.setTitle(R.string.dialog_title);
                builder.setPositiveButton(R.string.ok,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                              //  Intent intent = new Intent(ListItemsActivity.this, StartActivity.class);
                                finish();
                            }
                        });
                builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                       chbx.toggle(); // User cancelled the dialog
                    }
                });
                builder.show();
            }
        });


    }

    private void dispatchTakePictureIntent(){
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imgBtn.setImageBitmap(imageBitmap);
            }
    }



    @Override
    protected void onStart() {
        super.onStart();
        Log.i(ACTIVITY_NAME, "In onStart()");
    }


    @Override
    protected void onRestart() {
        super.onRestart();

        Log.i(ACTIVITY_NAME, "In onRestart()");

    }


    @Override
    protected void onResume() {
        super.onResume();

        Log.i(ACTIVITY_NAME, "In onResume()");
    }



    @Override
    protected void onPause() {
        super.onPause();

        Log.i(ACTIVITY_NAME, "In onPause()");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.i(ACTIVITY_NAME, "In onStop()");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(ACTIVITY_NAME, "In onDestroy()");
    }

}
