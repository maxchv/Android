package ua.dp.itstep.audiodemo;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://dl.dropboxusercontent.com/u/10281242/sample_audio.mp3";
                final MediaPlayer mediaPlayer = new MediaPlayer();
                // Set type to streaming
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                // Listen for if the audio file can't be prepared
                mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                    @Override
                    public boolean onError(MediaPlayer mp, int what, int extra) {
                        // ... react appropriately ...
                        // The MediaPlayer has moved to the Error state, must be reset!
                        return false;
                    }
                });
                // Attach to when audio file is prepared for playing
                mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {
                        mediaPlayer.start();
                    }
                });
                // Set the data source to the remote URL
                try {
                    mediaPlayer.setDataSource(url);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                // Trigger an async preparation which will file listener when completed
                mediaPlayer.prepareAsync();
            }
        });
    }
}
