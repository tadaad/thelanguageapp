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

public class numbers extends AppCompatActivity {

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
        words.add(new word("one", "uno", R.drawable.number_one, R.raw.uno1));
        words.add(new word("two", "dos", R.drawable.number_two, R.raw.two));
        words.add(new word("three", "tres", R.drawable.number_three, R.raw.three));
        words.add(new word("four", "cuatro", R.drawable.number_four, R.raw.four));
        words.add(new word("five", "cinco", R.drawable.number_five, R.raw.five));
        words.add(new word("six", "seis", R.drawable.number_six, R.raw.six));
        words.add(new word("seven", "siete", R.drawable.number_seven, R.raw.seven));
        words.add(new word("eight", "ocho", R.drawable.number_eight, R.raw.eight));
        words.add(new word("nine", "nueve", R.drawable.number_nine, R.raw.ninety));
        words.add(new word("ten", "diez", R.drawable.number_ten, R.raw.ten));
        words.add(new word("eleven", "once", R.drawable.eleven, R.raw.eleven));
        words.add(new word("twelve", "doce", R.drawable.tw, R.raw.twelve));
        words.add(new word("thirteen", "trese", R.drawable.thr, R.raw.thirteen));
        words.add(new word("fourteen", "catorce", R.drawable.ftr, R.raw.fourteen));
        words.add(new word("fifteen", "quince", R.drawable.fif, R.raw.fifteen));
        words.add(new word("sixteen", "dieciséis", R.drawable.sixteen, R.raw.sixteen));
        words.add(new word("seventeen", "diecisiete", R.drawable.st, R.raw.seventeen));
        words.add(new word("eighteen", "dieciocho", R.drawable.eth, R.raw.eighteen));
        words.add(new word("nineteen", "diecinueve", R.drawable.ny, R.raw.nineteen));
        words.add(new word("twenty", "viente", R.drawable.twenty, R.raw.twenty));
        words.add(new word("twenty one", "veintiuno", R.drawable.to, R.raw.tone));
        words.add(new word("twenty two", "veintidós", R.drawable.tt, R.raw.ttwo));
        words.add(new word("twenty three", "veintitrés", R.drawable.tre, R.raw.tthree));
        words.add(new word("twenty four", "veinticuatro", R.drawable.ty, R.raw.tfour));
        words.add(new word("twenty five", "veinticinco", R.drawable.tff, R.raw.tfive));
        words.add(new word("twenty six", "veintiséis", R.drawable.tx, R.raw.tsix));
        words.add(new word("twenty seven", "veintisiete", R.drawable.ts, R.raw.tseven));
        words.add(new word("twenty eight", "veintiocho", R.drawable.ne, R.raw.teight));
        words.add(new word("twenty nine", "veintinueve", R.drawable.nt, R.raw.tnine));
        words.add(new word("thirty", "treinta", R.drawable.thirty, R.raw.thirty));
        words.add(new word("forty", "cuarenta", R.drawable.forty, R.raw.fourty));
        words.add(new word("fifty", "cincuenta", R.drawable.fifty, R.raw.fifty));
        words.add(new word("sixty", "sesenta", R.drawable.sixty, R.raw.sixty));
        words.add(new word("seventy", "setenta", R.drawable.seventy, R.raw.seventy));
        words.add(new word("eighty", "ochenta", R.drawable.eighty, R.raw.eight));
        words.add(new word("ninety", "noventa", R.drawable.ninety, R.raw.ninety));
        words.add(new word("hundered", "cien", R.drawable.hun, R.raw.hundred));

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
                mMediaPlayer = MediaPlayer.create(numbers.this, Word.getmAudioReourceID());
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
