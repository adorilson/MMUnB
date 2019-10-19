package br.unb.mobileMedia.MMPlaylist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;





//FEATURE BEGIN PLAYLIST
import br.unb.mobileMedia.MMPlaylist.playlist.MainPlaylistListActivity;
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
    	
    	
    	
    	
    	 
    	
    	((Button)findViewById(R.id.btn_exit)).setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				MMUnBActivity.this.finish();
			}
		});
    }
    
}