package vo;

public class kakaoImage {
	private String collection; // 컬렉션 명
	private String thumbnail_url; // 이미지 썸네일 URL
	private String image_url; // 이미지 URL
	private int width; // 이미지의 가로 크기
	private int height; // 이미지의 세로 크기
	private String display_sitename; // 출처명
	private String doc_url; // 문서 URL
	private String datetime; // 문서 작성시간
	
	public kakaoImage() {
	}

	public kakaoImage(String collection, String thumbnail_url, String image_url, int width, int height,
			String display_sitename, String doc_url, String datetime) {
		this.collection = collection;
		this.thumbnail_url = thumbnail_url;
		this.image_url = image_url;
		this.width = width;
		this.height = height;
		this.display_sitename = display_sitename;
		this.doc_url = doc_url;
		this.datetime = datetime;
	}

	public String getCollection() {
		return collection;
	}

	public void setCollection(String collection) {
		this.collection = collection;
	}

	public String getThumbnail_url() {
		return thumbnail_url;
	}

	public void setThumbnail_url(String thumbnail_url) {
		this.thumbnail_url = thumbnail_url;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getDisplay_sitename() {
		return display_sitename;
	}

	public void setDisplay_sitename(String display_sitename) {
		this.display_sitename = display_sitename;
	}

	public String getDoc_url() {
		return doc_url;
	}

	public void setDoc_url(String doc_url) {
		this.doc_url = doc_url;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	@Override
	public String toString() {
		return "kakaoImage [collection=" + collection + ", thumbnail_url=" + thumbnail_url + ", image_url=" + image_url
				+ ", width=" + width + ", height=" + height + ", display_sitename=" + display_sitename + ", doc_url="
				+ doc_url + ", datetime=" + datetime + "]";
	}
	
}