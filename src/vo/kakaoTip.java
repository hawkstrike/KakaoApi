package vo;

import java.util.Arrays;

public class kakaoTip {
	private String title; // 글 제목
	private String contents; // 팀 본문 일부(스니핏 추출)
	private String q_url; // 팁 질문 글 URL
	private String a_url; // 팁 답변 글 URL
	private String[] thumbnails; // 팁 글에 대한 이미지 썸네일들
	private String type; // 검색된 글이 답변인지 질문인지 여부
	private String datetime; // 팁 질문 글 작성시간
	
	public kakaoTip() {
	}

	public kakaoTip(String title, String contents, String q_url, String a_url, String[] thumbnails, String type,
			String datetime) {
		this.title = title;
		this.contents = contents;
		this.q_url = q_url;
		this.a_url = a_url;
		this.thumbnails = thumbnails;
		this.type = type;
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

	public String getQ_url() {
		return q_url;
	}

	public void setQ_url(String q_url) {
		this.q_url = q_url;
	}

	public String getA_url() {
		return a_url;
	}

	public void setA_url(String a_url) {
		this.a_url = a_url;
	}

	public String[] getThumbnails() {
		return thumbnails;
	}

	public void setThumbnails(String[] thumbnails) {
		this.thumbnails = thumbnails;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	@Override
	public String toString() {
		return "kakaoTip [title=" + title + ", contents=" + contents + ", q_url=" + q_url + ", a_url=" + a_url
				+ ", thumbnails=" + Arrays.toString(thumbnails) + ", type=" + type + ", datetime=" + datetime + "]";
	}
	
}