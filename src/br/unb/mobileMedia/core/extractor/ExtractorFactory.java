package br.unb.mobileMedia.core.extractor;

import java.util.ArrayList;
import java.util.List;

import br.unb.mobileMedia.R;


import android.content.Context;

public class ExtractorFactory {

	private Context context;
	
	public ExtractorFactory(Context context){
		this.context = context;
	}
	
	public List<MediaExtractor> createExtractor(){
		
		List<MediaExtractor> extrs = new ArrayList<MediaExtractor>();
		
		//TODO: Need(?) a refactor to discover this classes in runtime
		
		MediaExtractor extr = null;
		
		if (context.getApplicationContext().getResources().getBoolean(R.bool.feature_video)){
			extr = new DefaultVideoExtractor(context);
			extrs.add(extr);
		}
		
		if (context.getApplicationContext().getResources().getBoolean(R.bool.feature_audio)){
			extr = new DefaultAudioExtractor(context);
			extrs.add(extr);
		}
				
		return extrs;
	} 
	
}
