package br.unb.mobileMedia.MMPlaylist_and_Share.core.view;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import br.unb.mobileMedia.MMPlaylist_and_Share.R;
import br.unb.mobileMedia.MMPlaylist_and_Share.core.domain.Audio;

public class AudioPlayerArrayAdapter extends ArrayAdapter<Audio> {

	private Context context;
	
	public AudioPlayerArrayAdapter(Context context, Audio[] objects) {
		super(context, R.layout.video_row_layout);
		this.context = context;
		List<Audio> objectsVector = Arrays.asList(objects);
		Iterator<Audio> iterator = objectsVector.iterator(); 
		while (iterator.hasNext()) {
			add(iterator.next());
		}
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.video_row_layout, parent,false);
		TextView textView = (TextView) rowView.findViewById(R.id.txt_name);
		
		textView.setText(getItem(position).getTitle());
		
		return rowView;
	}

	
}
