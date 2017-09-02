package com.example.mohammed.mohvideoplayer;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.afollestad.easyvideoplayer.EasyVideoCallback;
import com.afollestad.easyvideoplayer.EasyVideoPlayer;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity  implements EasyVideoCallback {

    private EasyVideoPlayer player;
    private Spinner spinner;
    private boolean isChanged = false;

    /**
     * This listener gets triggered when the {@link MediaPlayer} has completed
     * playing the audio file.
     */
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            // releaseMediaPlayer();
        }
    };
    private View.OnTouchListener mTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            isChanged = true;
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // find spinner
        spinner = (Spinner) findViewById(R.id.spinner_list);

        // list of web url video.
        final List<String> list_item = new ArrayList<String>();
        list_item.add("https://ia800404.us.archive.org/7/items/Bets10YeniSezonVideo/Bets10%20Yeni%20Sezon%20Video.mp4");
        list_item.add("https://youtu.be/cuEbh_TiTew");
        list_item.add("https://archive.org/download/ksnn_compilation_master_the_internet/ksnn_compilation_master_the_internet_512kb.mp4");
        list_item.add(" https://ia801600.us.archive.org/26/items/SKODAOCTAVIA336x280/SKODA-OCTAVIA-336x280.mp4");


        // array adapter setting
        ArrayAdapter listvideo = new ArrayAdapter(this, android.R.layout.simple_spinner_item, list_item);

        // Specify dropdown layout style - simple list view with 1 item per line
        listvideo.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        player = (EasyVideoPlayer) findViewById(R.id.player);


        // Apply the adapter to the spinner
        spinner.setAdapter(listvideo);
        player.setCallback(MainActivity.this);

        // Set String Selected to the constant values
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                // spinner.getEmptyView();
                switch (selection) {
                    case "https://ia800404.us.archive.org/7/items/Bets10YeniSezonVideo/Bets10%20Yeni%20Sezon%20Video.mp4":
                        Toast.makeText(MainActivity.this, "show playone",
                                Toast.LENGTH_SHORT).show();

                        player.setSource(Uri.parse("https://ia800404.us.archive.org/7/items/Bets10YeniSezonVideo/Bets10%20Yeni%20Sezon%20Video.mp4"));
                        break;
                    case "https://youtu.be/cuEbh_TiTew":
                        Toast.makeText(MainActivity.this, "show playone",
                                Toast.LENGTH_SHORT).show();

                        player.setSource(Uri.parse("https://youtu.be/cuEbh_TiTew"));


                        break;
                    case "https://archive.org/download/ksnn_compilation_master_the_internet/ksnn_compilation_master_the_internet_512kb.mp4":
                        Toast.makeText(MainActivity.this, "show play2",
                                Toast.LENGTH_SHORT).show();

                        player.setSource(Uri.parse("https://archive.org/download/ksnn_compilation_master_the_internet/ksnn_compilation_master_the_internet_512kb.mp4"));
                        break;
                    case " https://ia801600.us.archive.org/26/items/SKODAOCTAVIA336x280/SKODA-OCTAVIA-336x280.mp4":
                        Toast.makeText(MainActivity.this, "show play3",
                                Toast.LENGTH_SHORT).show();
                        player.setSource(Uri.parse("https://ia801600.us.archive.org/26/items/SKODAOCTAVIA336x280/SKODA-OCTAVIA-336x280.mp4"));

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                player.pause();
            }
        });

    }
    @Override
    public void onStop() {
        super.onStop();
        // When the activity is stopped, release the media player resources because we won't
        // be playing any more sounds.
        player.release();
        player = null;
    }

    @Override
    public void onPause() {
        super.onPause();
        // Make sure the player stops playing if the user presses the home button.
        player.pause();}

    //  below is method for more modification that i want

    @Override
    public void onStarted(EasyVideoPlayer player) {
        // player.start();
    }

    @Override
    public void onPaused(EasyVideoPlayer player) {
        player.pause();
    }

    @Override
    public void onPreparing(EasyVideoPlayer player) {
    }

    @Override
    public void onPrepared(EasyVideoPlayer player) {
    }

    @Override
    public void onBuffering(int percent) {
    }

    @Override
    public void onError(EasyVideoPlayer player, Exception e) {
    }

    @Override
    public void onCompletion(EasyVideoPlayer player) {
    }

    @Override
    public void onRetry(EasyVideoPlayer player, Uri source) {
    }

    @Override
    public void onSubmit(EasyVideoPlayer player, Uri source) {

    }
}
