package com.example.anuvadak;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Translate extends AppCompatActivity {
    private static final int CAMERA_REQUEST = 1888;
    BottomNavigationView bottomNavigationView;
    Button btn_picture;
    ImageView camera_output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate);
        bottomNavigationView = findViewById(R.id.bottom_navigator);
        bottomNavigationView.setSelectedItemId(R.id.dashboard);
        btn_picture = findViewById(R.id.btn_camera);
        camera_output = findViewById(R.id.camera_output);

        //DETECT BUTTON CLICK
        btn_picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast toast=Toast.makeText(getApplicationContext(),"Camera Launched!",Toast.LENGTH_SHORT);
                toast.show();
                Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                Translate.this.startActivity(camera_intent);
//                startActivityForResult(camera_intent,CAMERA_REQUEST);
            }
        });

        //OPEN CAMERA
//        protected void onActivityResult(int requestCode, int resultCode,Intent data) {
//            super.onActivityResult(requestCode, resultCode, data);
//            if (requestCode == CAMERA_REQUEST) {
//                Bitmap photo = (Bitmap) data.getExtras().get("data");
//                camera_output.setImageBitmap(photo);
//            }
//        }


        //NAV BAR
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {

                    case R.id.dashboard:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.translate:
                        return true;
                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(),Profile.class));
                        overridePendingTransition(0,0);
                        return true;

                }
                return false;
            }
        });
    }
}