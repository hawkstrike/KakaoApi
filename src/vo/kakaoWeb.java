package vo;

public class kakaoWeb {
	private String title; // 문서 제목
	private String contents; // 문서 본문 중 일부
	private String url; // 문서 URL
	private String datetime; // 문서 글 작성시간
	
	public kakaoWeb() {
		
	}

	public kakaoWeb(String title, String contents, String url, String datetime) {
		this.title = title;
		this.contents = contents;
		this.url = url;
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

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	@Override
	public String toString() {
		return "kakaoWeb [title=" + title + ", contents=" + contents + ", url=" + url + ", datetime=" + datetime + "]";
	}
	
}