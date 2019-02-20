package au.com.automic;


public class Tour {
	private TourId id;
	
	public Tour(TourId id) {
		this.id = id;
	}
	
	public TourId getId() {
		return id;
	}
	public void setId(TourId id) {
		this.id = id;
	}
	
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!(obj instanceof Tour))
			return false;
		
		Tour that = (Tour)obj;
		
		if (this.getId().equals(that.getId())) {
			return true;
		}
		return false;
		
	}

}
