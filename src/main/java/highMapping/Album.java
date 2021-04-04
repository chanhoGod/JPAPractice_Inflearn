package highMapping;

import javax.persistence.Entity;

//@Entity
public class Album extends Item{
	private String Artist;

	public String getArtist() {
		return Artist;
	}

	public void setArtist(String artist) {
		Artist = artist;
	}
	
	
}
