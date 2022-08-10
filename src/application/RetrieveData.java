package application;

public class RetrieveData {
	
		private String ID;
		private String type;
		private String title;
		private String year;
		private String rating;
		private String genre;
		private String service;

		public RetrieveData(String ID, 
					String type, 
					String title, 
					String year, 
					String rating,
					String genre,
					String service) {
			this.setID(ID);
			this.setType(type);
			this.setTitle(title);
			this.setYear(year);
			this.setRating(rating);
			this.setGenre(genre);
			this.setService(service);
			
			
			
			}

		public String getID() {
			return ID;
		}

		public void setID(String iD) {
			ID = iD;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getYear() {
			return year;
		}

		public void setYear(String year) {
			this.year = year;
		}

		public String getRating() {
			return rating;
		}

		public void setRating(String rating) {
			this.rating = rating;
		}
		
		public String getGenre() {
			return genre;
		}

		public void setGenre(String genre) {
			this.genre = genre;
		}

		public String getService() {
			return service;
		}

		public void setService(String service) {
			this.service = service;
		}
		
		@Override 
		public String toString() {
			return "["+ ID + " ," + type + " ," + title + " ," + year + " ," + rating + " ," + genre + " ," + service +"]"; 

		}

}
