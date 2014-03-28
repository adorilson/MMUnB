package br.unb.mobileMedia.core.view;

import java.util.List;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import br.unb.mobileMedia.R;
import br.unb.mobileMedia.core.db.DBException;
import br.unb.mobileMedia.core.domain.Author;
import br.unb.mobileMedia.core.manager.Manager;

/**
 * The fragment that displays the list of authors.
 * @author rbonifacio
 */
public class AuthorListFragment extends ListFragment {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getActivity().setTitle("All artists");
		try {
			List<Author> authors = Manager.instance().listAuthors(getActivity().getApplicationContext());

			if (authors == null || authors.size() == 0) {
				String[] values = new String[] { "No author found." };
				
				// This code is verbose, because it is a didatic example.
				// In others cases, you can just use the SIMPLE_LIST_ITEM_LAYOUT constant
				int layout = 0;
				if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB){
					layout = android.R.layout.simple_list_item_activated_1;
				}else{
					layout = android.R.layout.simple_list_item_1;
				}
				ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), layout, values);
				setListAdapter(adapter);
			} else {
				AuthorArrayAdapter adapter = new AuthorArrayAdapter(getActivity(), authors);
				setListAdapter(adapter);
			}
		} catch (DBException e) {
			Toast.makeText(getActivity(), "DBException: " + e.getLocalizedMessage(), Toast.LENGTH_LONG)
					.show();
		}
	}

	/*
	 * This method is called whenever the user selects 
	 * one of the items of a list. In this case, whenever 
	 * the user selects on artist. 
	 * @see android.app.ListFragment#onListItemClick(android.widget.ListView, android.view.View, int, long)
	 */
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		try{
			Author item = (Author) getListAdapter().getItem(position);

			Bundle args = new Bundle();
			args.putInt(AudioExpandableListFragment.SELECTED_ARTIST_ID, item.getId());
			args.putString(AudioExpandableListFragment.SELECTED_ARTIST_NAME, item.getName());

			// TODO Extract this to a method (repeated in MMUnBActivity too)
			Fragment newFragment = new AudioExpandableListFragment();
			newFragment.setArguments(args);
			FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
			if(getActivity().findViewById(R.id.main) != null){
				transaction.replace(R.id.main, newFragment);
				transaction.addToBackStack(null);
			}else{
				transaction.replace(R.id.content, newFragment);
			}
			transaction.commit();
		}catch(ClassCastException e){
			Log.i("MM", e.getMessage());
		}catch(RuntimeException e){
			throw e; 
		}
	}
}
