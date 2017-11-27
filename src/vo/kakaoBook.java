package vo;

import java.util.Arrays;

public class kakaoBook {
	private String title; // 도서 제목
	private String contents; // 도서 소개
	private String url; // 책 링크
	private String isbn; // 국제 표준 도서번호
	private String datetime; // 도서 출판 날짜
	private String[] authors; // 도서 저자 리스트
	private String publisher; // 출판사
	private String[] translators; // 변역자 리스트
	private int price; // 도서 정가
	private int sale_price; // 도서 판매가
	private String sale_yn; // 도서 판매 여부
	private String category; // 도서 카테고리 정보
	private String thumbnail; // 도서 표지 썸네일
	private String barcode; // 교보문고 바코드 정보
	private String ebook_barcode; // 교보문고 전자책 바코드 정보
	private String status; // 도서 상태 정보
	
	public kakaoBook() {
	}

	public kakaoBook(String title, String contents, String url, String isbn, String datetime, String[] authors,
			String publisher, String[] translators, int price, int sale_price, String sale_yn, String category,
			String thumbnail, String barcode, String ebook_barcode, String status) {
		this.title = title;
		this.contents = contents;
		this.url = url;
		this.isbn = isbn;
		this.datetime = datetime;
		this.authors = authors;
		this.publisher = publisher;
		this.translators = translators;
		this.price = price;
		this.sale_price = sale_price;
		this.sale_yn = sale_yn;
		this.category = category;
		this.thumbnail = thumbnail;
		this.barcode = barcode;
		this.ebook_barcode = ebook_barcode;
		this.status = status;
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

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public String[] getAuthors() {
		return authors;
	}

	public void setAuthors(String[] authors) {
		this.authors = authors;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String[] getTranslators() {
		return translators;
	}

	public void setTranslators(String[] translators) {
		this.translators = translators;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getSale_price() {
		return sale_price;
	}

	public void setSale_price(int sale_price) {
		this.sale_price = sale_price;
	}

	public String getSale_yn() {
		return sale_yn;
	}

	public void setSale_yn(String sale_yn) {
		this.sale_yn = sale_yn;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getEbook_barcode() {
		return ebook_barcode;
	}

	public void setEbook_barcode(String ebook_barcode) {
		this.ebook_barcode = ebook_barcode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "kakaoBook [title=" + title + ", contents=" + contents + ", url=" + url + ", isbn=" + isbn
				+ ", datetime=" + datetime + ", authors=" + Arrays.toString(authors) + ", publisher=" + publisher
				+ ", translators=" + Arrays.toString(translators) + ", price=" + price + ", sale_price=" + sale_price
				+ ", sale_yn=" + sale_yn + ", category=" + category + ", thumbnail=" + thumbnail + ", barcode="
				+ barcode + ", ebook_barcode=" + ebook_barcode + ", status=" + status + "]";
	}
	
}