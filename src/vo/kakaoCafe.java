package vo;

public class kakaoCafe {
	private String title; // 카페 글 제목
	private String contents; // 카페 글 내용 중 일부
	private String url; // 카페 글 URL
	private String cafename; // 카페 이름
	private String thumbnail; // 카페 글 대표 썸네일
	private String datetime; // 도서 출판날짜
	
	public kakaoCafe() {
	}

	public kakaoCafe(String title, String contents, String url, String cafename, String thumbnail, String datetime) {
		this.title = title;
		this.contents = contents;
		this.url = url;
		this.cafename = cafename;
		this.thumbnail = thumbnail;
		this.datetime = datetime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCafename() {
		return cafename;
	}

	public void setCafename(String cafename) {
		this.cafename = cafename;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	@Override
	public String toString() {
		return "kakaoCafe [title=" + title + ", contents=" + contents + ", url=" + url + ", cafename=" + cafename
				+ ", thumbnail=" + thumbnail + ", datetime=" + datetime + "]";
	}
	
}