package br.unb.mobileMedia.core.extractor;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import br.unb.mobileMedia.core.domain.Audio;
import br.unb.mobileMedia.core.domain.AudioFormats;
import br.unb.mobileMedia.core.domain.Author;
import br.unb.mobileMedia.util.FileUtility;

/**
 * A defaul implementation of an audio extractor.
 * 
 * @author rbonifacio
 */
public class DefaultAudioExtractor implements MediaExtractor {
	
	private static final String UNKNOWN = "Unknown";

	private File mp3File;
	private MediaScannerConnection msc;
	private Context context;

	/**
	 * Constructs a DefaultAudioExtractor with the specified context. The
	 * context is necessary because it provides a useful way to obtain a manager
	 * query.
	 * 
	 * @param context
	 *            the current context of the application.
	 */
	public DefaultAudioExtractor(Context context) {
		this.context = context;
	}

	/**
	 * @see MediaExtractor#processFile(File[])
	 */
	public List<Author> processFiles() {
		
		final List<File> allMusics = new ArrayList<File>();

		for(AudioFormats format : AudioFormats.values()) {
			allMusics.addAll(FileUtility.listFiles(new File(Environment
					.getExternalStorageDirectory().getPath() + "/Music/"),
					format.getFormatAsString()));
		}

		List<File> audioFiles = allMusics;
		
		Map<Integer, Author> authors = new HashMap<Integer, Author>();

		MediaMetadataRetriever mmr = new MediaMetadataRetriever();

		Log.i("Audio files to process: ", String.valueOf(audioFiles.size()));
		for(File file: audioFiles){

	       URI u =  file.getAbsoluteFile().toURI();
	       
	       Log.i("URI: ", u.getPath());
	       
	       mmr.setDataSource(u.getPath());
	       
	       String authorName = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST); 
	       authorName = authorName == null || authorName.equals("") ? UNKNOWN : authorName;
	       
	       Integer authorId = authorName.hashCode();
	       
	       String title = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE);
	       title = title == null || title.equals("") ? UNKNOWN : title;
	       
	       String titleKey = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE);
	       titleKey = titleKey == null || titleKey.equals("") ? UNKNOWN : titleKey;
	       
	       String album = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ALBUM); //cursor.
	       album = album == null || album.equals("") ? UNKNOWN : album;
	       
	       Log.i("authorId: ", String.valueOf(authorId));
		   Log.i("authorName: ", authorName);
		   Log.i("title: ", title);
		   Log.i("titleKey: ", titleKey);
		   Log.i("album: ", album);

		   Author author = authors.get(authorId);
		   
		   if(author == null) {
			   author = new  Author(authorId.hashCode(), authorName);
		   }
		   
		   author.addProduction(new Audio(titleKey.hashCode(), title, u, album));
		   
		   authors.put(author.getId(), author);
		}
		return new ArrayList<Author>(authors.values());
	}

	private MediaScannerConnection createMediaScanner(final List<File> audioFiles) {
		return new MediaScannerConnection(context,
				new MediaScannerConnection.MediaScannerConnectionClient() {
					public void onScanCompleted(String path, Uri uri) {
						msc.disconnect();
					}

					public void onMediaScannerConnected() {
						for (final File file : audioFiles) {
							mp3File = file;
							msc.scanFile(mp3File.getAbsolutePath(), null);

						}
					}
				});
	}
	
	public Context getContext() {
		return this.context;
	}

	public void setContext(Context context) {
		this.context = context;
	}

}
