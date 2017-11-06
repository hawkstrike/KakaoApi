package vo;

public class kakaoVclip {
	private String title; // 동영상 제목
	private String url; // 동영상 링크
	private String datetime; // 동영상 등록일
	private int play_time; // 동영상 재생시간(단위: 초)
	private String thumbnail; // 동영상 썸네일 URL
	private String author; // 동영상 업로더
	
	public kakaoVclip() {
	}

	public kakaoVclip(String title, String url, String datetime, int play_time, String thumbnail, String author) {
		this.title = title;
		this.url = url;
		this.datetime = datetime;
		this.play_time = play_time;
		this.thumbnail = thumbnail;
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public int getPlay_time() {
		return play_time;
	}

	public void setPlay_time(int play_time) {
		this.play_time = play_time;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "kakaoVclip [title=" + title + ", url=" + url + ", datetime=" + datetime + ", play_time=" + play_time
				+ ", thumbnail=" + thumbnail + ", author=" + author + "]";
	}
	
}