package com.example.snakbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    private final int PICK_AUDIO = 1;
    Uri AudioUri;
    TextView select_Audio;
    String audioPath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        select_Audio = findViewById(R.id.select_Audio);

        // SETTING ONCLICK LISTENER ------ ON TEXT VIEW CLICK TO TAKE AUDIO INPUT
        select_Audio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.INTENT_ACTION_MUSIC_PLAYER);
                startActivity(intent);
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_AUDIO && resultCode == RESULT_OK) {
            // Audio is Picked in format of URI
            AudioUri = data.getData();
            select_Audio.setText("Audio Selected");
        }
    }
}