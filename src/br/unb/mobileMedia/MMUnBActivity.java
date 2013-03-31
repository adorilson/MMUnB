package br.unb.mobileMedia;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

//FEATURE BEGIN SYNC
import android.widget.Toast;
import br.unb.mobileMedia.core.db.DBException;
import br.unb.mobileMedia.core.manager.Manager;
//FEATURE END SYNC

//FEATURE BEGIN PLAYER_MUSIC
import br.unb.mobileMedia.core.view.AudioPlayerActivity;
//FEATURE END PLAYER_MUSIC

//FEATURE BEGIN ARTISTS
import br.unb.mobileMedia.core.view.AuthorListActivity;
//FEATURE END ARTISTS

//FEATURE BEGIN SHARE
import br.unb.mobileMedia.core.view.ShareListActivity;
//FEATURE END SHARE

//FEATURE BEGIN PLAYLIST
import br.unb.mobileMedia.playlist.MainPlaylistListActivity;
//FEATURE END PLAYLIST


/**
 * The main activity of the MMUnB project.
 * 
 * @author Paula Fernandes
 */
public class MMUnBActivity extends Activity {
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.main);
        this.configureUI();
    }
    
    /*
     * Configure the UI action listeners. One action listener is 
     * defined to each button.
     */
    private void configureUI(){
    	//FEATURE BEGIN ARTISTS
    	//configures the btn_list_authors action listener 
    	((Button)findViewById(R.id.btn_list_authors)).setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent startActivtyIntent = new Intent(getApplicationContext(), AuthorListActivity.class);
				startActivity(startActivtyIntent);
			}
		});
    	//FEATURE END ARTISTS
    	
    	
    	//FEATURE BEGIN PLAYER_MUSIC
    	((Button)findViewById(R.id.btn_media_list)).setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent startActivtyIntent = new Intent(getApplicationContext(), AudioPlayerActivity.class);
				startActivity(startActivtyIntent);
			}
		});
    	//FEATURE END PLAYER_MUSIC
    	
    	
    	//FEATURE BEGIN PLAYLIST
    	((Button)findViewById(R.id.btn_play_list)).setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent startActivtyIntent = new Intent(getApplicationContext(), MainPlaylistListActivity.class);
				startActivity(startActivtyIntent);
			}
		});
    	//FEATURE END PLAYLIST
    	
    	
    	//FEATURE BEGIN SYNC
    	((Button)findViewById(R.id.btn_synchronize)).setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				try {
					Manager.instance().synchronizeMedia(getApplicationContext());
					Toast.makeText(getApplicationContext(), R.string.message_synchronization_finished, Toast.LENGTH_LONG).show();
				}
				catch(DBException e) {
					Toast.makeText(getApplicationContext(),  e.getMessage(), Toast.LENGTH_LONG).show();
				}
			}
		});
    	//FEATURE END SYNC
    	
    	
    	//FEATURE BEGIN SHARE
    	//social network button
    	((Button)findViewById(R.id.btn_share)).setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent startActivtyIntent = new Intent(getApplicationContext(), ShareListActivity.class);
				startActivity(startActivtyIntent);
			}
		});
    	//FEATURE END SHARE
    	 
    	
    	((Button)findViewById(R.id.btn_exit)).setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				MMUnBActivity.this.finish();
			}
		});
    }
    
}