package br.unb.mobileMedia.MMPlaylist_and_Share.core.domain;

import java.net.URI;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Represents an Audio Multimedia content.
 *
 * Note, its necessary to implement serializable, because it would 
 * be necessary to share audio between activities. Probably, we should 
 * turn MediaContent serializable either. 
 * 
 * @author rbonifacio
 */
public class Audio extends MultimediaContent implements Parcelable {

	public static final long serialVersionUID = 1L;

	/* the name of the album */
	private String album;
	
	/**
	 * Audio constructor. 
	 * @param id audio id
	 * @param title audio title 
	 * @param url audio url
	 * @param album the album which this audio was published
	 */
	public Audio(Integer id, String title, URI uri, String album) {
		super(id, title, uri);
		this.album = album;
	}
	
	public Audio(Integer pk, Integer id, String title, URI uri, String album) {
		this(id, title, uri,album);
		this.primaryKey = pk;
	}
	
	/**
	 * Audio constructor.
	 * @param id audio id
	 * @param title audio title 
	 * @param url audio url
	 */
	
	public Audio(Integer id, String title, URI uri) {
		super(id, title, uri);
	}
	
	/**
	 * Audio constructor. 
	 * @param title audio title 
	 * @param url audio url
	 */
	public Audio(String title, URI uri) {
		super(title, uri);
	}

	/* getters and setters. there is not much to explain. */
	
	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}
	
	public String toString() {
		return title;
	}

	public int describeContents() {
		return 0;
	}

	
	@Override
	public boolean equals(Object o) {
		return (o instanceof Audio) && ((Audio)o).getPrimaryKey().equals(primaryKey);
	}

	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(primaryKey);
		dest.writeInt(id);
		dest.writeString(title);
		dest.writeSerializable(uri);
		dest.writeString(album);	
	}
	
	 public static final Parcelable.Creator<Audio> CREATOR = new Parcelable.Creator<Audio>() {

		public Audio createFromParcel(Parcel source) {
			int pk = source.readInt();
			int id = source.readInt(); 
			String title = source.readString();
			URI uri = (URI)source.readSerializable();
			String album = source.readString();
			
			Audio audio = new Audio(pk, id, title, uri, album);
			
			return audio;
		}

		public Audio[] newArray(int size) {
			return new Audio[size];
		}
	
	 }; 
}
