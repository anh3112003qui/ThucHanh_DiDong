package com.example.btth5_music;

import androidx.appcompat.app.AppCompatActivity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btnStream, btnStop;
    EditText etURL;
    Boolean isStreaming = false;
    MediaPlayer m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etURL = findViewById(R.id.etURL);
        btnStream = findViewById(R.id.btnStream);
        btnStop = findViewById(R.id.btnStop);
        btnStream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAudioStream(etURL.getText().toString());
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlaying();
            }
        });
    }
    public void startAudioStream(String url) {
        if (m == null)
            m = new MediaPlayer();
        try {
            m.setAudioStreamType(AudioManager.STREAM_MUSIC);
            m.setDataSource(url);
            m.prepare();
            m.setVolume(1f, 1f);
            m.setLooping(false);
            m.start();
        } catch (Exception e) {
            Log.d("mylog", "Error playing in SoundHandler: " + e.toString());
        }
    }

    private void stopPlaying() {
        if (m != null && m.isPlaying()) {
            m.stop();
            m.release();
            m = new MediaPlayer();
            m.reset();
        }
    }
}