package com.tadinnovativeminds.aad.thelanguageapp;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class gnum extends AppCompatActivity {

    /**
     * Handles playback of all the sound files
     */
    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;


    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                // The AUDIOFOCUS_LOSS_TRANSIENT case means that we've lost audio focus for a
                // short amount of time. The AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK case means that
                // our app is allowed to continue playing sound but at a lower volume. We'll treat
                // both cases the same way because our app is playing short sound files.

                // Pause playback and reset player to the start of the file. That way, we can
                // play the word from the beginning when we resume playback.
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                // The AUDIOFOCUS_GAIN case means we have regained focus and can resume playback.
                mMediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                // The AUDIOFOCUS_LOSS case means we've lost audio focus and
                // Stop playback and clean up resources
                releaseMediaPlayer();
            }
        }
    };

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        //  setContentView(R.layout.word_list);
        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        // Create a list of words
        final ArrayList<word> words = new ArrayList<word>();
        words.add(new word("one", "eins", R.drawable.number_one, R.raw.gone));
        words.add(new word("two", "zwei", R.drawable.number_two, R.raw.gtwo));
        words.add(new word("three", "drei", R.drawable.number_three, R.raw.gthree));
        words.add(new word("four", "vier", R.drawable.number_four, R.raw.gfour));
        words.add(new word("five", "fünf", R.drawable.number_five, R.raw.gfive));
        words.add(new word("six", "sechs", R.drawable.number_six, R.raw.gsix));
        words.add(new word("seven", "sieben", R.drawable.number_seven, R.raw.gseven));
        words.add(new word("eight", "acht", R.drawable.number_eight, R.raw.geight));
        words.add(new word("nine", "neun", R.drawable.number_nine, R.raw.gnine));
        words.add(new word("ten", "zehn", R.drawable.number_ten, R.raw.gten));
        words.add(new word("eleven", "elf", R.drawable.eleven, R.raw.geleven));
        words.add(new word("twelve", " zwölf", R.drawable.tw, R.raw.gtwelve));
        words.add(new word("thirteen", "dreizehn", R.drawable.thr, R.raw.gthirteen));
        words.add(new word("fourteen", "vierzehn", R.drawable.ftr, R.raw.gfourteen));
        words.add(new word("fifteen", "fünfzehn", R.drawable.fif, R.raw.gfifteen));
        words.add(new word("sixteen", "sechzehn", R.drawable.sixteen, R.raw.gsixteen));
        words.add(new word("seventeen", "siebzehn", R.drawable.st, R.raw.gseventeen));
        words.add(new word("eighteen", "achtzehn", R.drawable.eth, R.raw.geighteen));
        words.add(new word("nineteen", "neunzehn", R.drawable.ny, R.raw.nineteen));
        words.add(new word("twenty", "zwanzig", R.drawable.twenty, R.raw.gtwenty));
        words.add(new word("thirty", "dreiβig", R.drawable.thirty, R.raw.gthirty));
        words.add(new word("forty", "vierzig", R.drawable.forty, R.raw.gfourty));
        words.add(new word("fifty", "fünfzig", R.drawable.fifty, R.raw.gfifty));
        words.add(new word("sixty", "sechzig", R.drawable.sixty, R.raw.gsixty));
        words.add(new word("seventy", "siebzig", R.drawable.seventy, R.raw.gseventy));
        words.add(new word("eighty", "achtzig", R.drawable.eighty, R.raw.geighty));
        words.add(new word("ninety", "neunzig", R.drawable.ninety, R.raw.gninety));
        words.add(new word("hundered", "(ein)hundert", R.drawable.hun, R.raw.ghun));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(this, words);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Get the {@link Word} object at the given position the user clicked on
                word Word = words.get(position);


                // Create and setup the {@link MediaPlayer} for the audio resource associated
                // with the current word
                mMediaPlayer = MediaPlayer.create(gnum.this, Word.getmAudioReourceID());
                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                // Start the audio file
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(mCompletionListener);

            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);

        }
    }
}
