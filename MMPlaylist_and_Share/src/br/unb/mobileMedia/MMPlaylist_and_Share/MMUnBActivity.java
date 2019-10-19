package br.unb.mobileMedia.MMPlaylist_and_Share;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;




//FEATURE BEGIN SHARE
import br.unb.mobileMedia.MMPlaylist_and_Share.core.view.ShareListActivity;
//FEATURE END SHARE

//FEATURE BEGIN PLAYLIST
import br.unb.mobileMedia.MMPlaylist_and_Share.playlist.MainPlaylistListActivity;
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
    	
    	
    	
    	
    	//FEATURE BEGIN PLAYLIST
    	((Button)findViewById(R.id.btn_play_list)).setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent startActivtyIntent = new Intent(getApplicationContext(), MainPlaylistListActivity.class);
				startActivity(startActivtyIntent);
			}
		});
    	//FEATURE END PLAYLIST
    	
    	
    	
    	
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