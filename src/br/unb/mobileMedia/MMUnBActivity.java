package br.unb.mobileMedia;

import br.unb.mobileMedia.core.db.DBException;
import br.unb.mobileMedia.core.manager.Manager;
import br.unb.mobileMedia.core.view.AudioPlayerFragment;
import br.unb.mobileMedia.core.view.AuthorListFragment;
import br.unb.mobileMedia.core.view.ShareListFragment;
import br.unb.mobileMedia.playlist.MainPlaylistListFragment;

import android.app.Activity;
import android.os.Bundle;
import android.os.PowerManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import android.support.v7.app.ActionBarActivity;
import android.view.MotionEvent;
import android.widget.Toast;

public class MMUnBActivity extends Activity implements OnItemClickedCallBack{

    private void configLayout(){
        MenuFragment menuFrag = new MenuFragment();

/*
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if (findViewById(R.id.main)!=null){
            transaction.add(R.id.main, menuFrag);
        }else{
            transaction.add(R.id.menu, menuFrag);
            transaction.add(R.id.content, new ContentFragment());
        }

        transaction.commit();
*/
    }

	@Override
	protected void onCreate(final Bundle savedInstanceStace){
		super.onCreate(savedInstanceStace);
		setContentView(R.layout.main);

        configLayout();


        //FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
	}
	
	public void onItemClicked(int menuItem){
		Fragment newFragment = null;
		switch(menuItem){
			case R.id.btn_list_authors:
				newFragment = new AuthorListFragment();
				break;
			case R.id.btn_play_list:
				newFragment = new MainPlaylistListFragment(); 
				break;
			case R.id.btn_open_music_player:
				newFragment = new AudioPlayerFragment(); 
				break;
			case R.id.btn_share:
				newFragment = new ShareListFragment(); 
				break;
			case R.id.btn_synchronize:
				try {
					Manager.instance().synchronizeMedia(getApplicationContext());
					Toast.makeText(getApplicationContext(), R.string.message_synchronization_finished, Toast.LENGTH_LONG).show();
				}
				catch(DBException e) {
					Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
				} 
				break;
			case R.id.btn_exit:
				MMUnBActivity.this.finish();
				break;
			default:
				Toast.makeText(getApplicationContext(), R.string.need_to_be_implemented, Toast.LENGTH_LONG).show();
		}

		// TODO Extract this to a method (repeated in AuthorListFragment too)

		if (newFragment !=null){
            /*
			FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

			
			if(findViewById(R.id.main) != null){
				transaction.replace(R.id.main, newFragment);
				transaction.addToBackStack(null);
			}else{
				transaction.replace(R.id.content, newFragment);
			}
			transaction.commit();
			*/
		}
	}

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Toast.makeText(getApplicationContext(), R.string.need_to_be_implemented, Toast.LENGTH_LONG).show();
        return super.onTouchEvent(event);
    }


}

