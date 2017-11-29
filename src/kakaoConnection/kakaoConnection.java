package kakaoConnection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import vo.kakaoBlog;
import vo.kakaoBook;
import vo.kakaoCafe;
import vo.kakaoImage;
import vo.kakaoTip;
import vo.kakaoVclip;
import vo.kakaoWeb;

public class kakaoConnection {
	private URL url;
	private HttpURLConnection conn;
	// 발급받은 ApiKey 값
	private String apiKey;
	// header내 Authorization 설정을 위한 변수
	private String authorization = "KakaoAK ";
	// Api에 접근할 때 공통적으로 등러가는 주소를 위한 변수
	private String host = "https://dapi.kakao.com/v2/search/";
	// 접속 방식을 설정하는 변수
	private String method = "GET";
	private String contentType = "application/json;charset=UTF-8";
	// blog, book, cafe, image, tip, vclip, web 중 어떤 검색을 할지 고르는 변수
	private String request;
	// 실제로 Api에 접근할 주소를 위한 변수
	private String address;
	// 검색할 쿼리를 지정하는 변수 - 필수
	private String query;
	// 정렬 방법을 선택하는 변수 | accuracy, recency | 기본값 : accuracy
	private String sort;
	// 몇 번째 페이지의 결과물을 가지고 올지 정하는 변수
	// 1 ~ 50 사이 | 기본값 : 1
	private String page;
	// 검색된 결과물들을 몇개 가지고 올지 정하는 변수
	// 1 ~ 50 사이 | 기본값 : 10
	private String size;
	
	public kakaoConnection() {
	}
	
	/*
	 * sort, page, size를 kakao에서 제공하는 기본값으로 사용하는 경우의 생성자
	 */
	public kakaoConnection(String apiKey, String request, String query) throws UnsupportedEncodingException {
		this.apiKey = apiKey;
		this.authorization += this.apiKey;
		this.request = request;
		this.address = this.host + this.request;
		this.query = URLEncoder.encode(query, "UTF-8");
		
		if(!"".equals(this.query))
			this.address += "?query=" + this.query;
	}
	/*
	 * sort, page, size를 직접 설정하는 생성자
	 */
	public kakaoConnection(String apiKey, String request, String query, String sort, String page, String size) throws UnsupportedEncodingException {
		this.apiKey = apiKey;
		this.authorization += this.apiKey;
		this.request = request;
		this.address = this.host + this.request;
		this.query = URLEncoder.encode(query, "UTF-8");
		this.sort = sort;
		this.page = page;
		this.size = size;
		
		if(!"".equals(this.query))
			this.address += "?query=" + this.query;
		if(!"".equals(this.query))
			this.address += "&sort=" + this.sort;
		if(!"".equals(this.query))
			this.address += "&page=" + this.page;
		if(!"".equals(this.query))
			this.address += "&size=" + this.size;
	}
	
	/*
	 * 접속을 시도하는 메소드
	 * 접속에 성공여부에 상관없이 kakao로부터 받은 값을 리턴하며
	 * 200이면 접속에 성공한 것임.
	 */
	public int getResponseCode() {
		int getResponseCode = 0;
		try {
			url = new URL(address);
			conn = (HttpURLConnection)url.openConnection();
			
			conn.setRequestMethod(method);
			conn.setRequestProperty("Authorization", authorization);
			conn.setRequestProperty("Content-Type", contentType);
			conn.connect();
			
			getResponseCode = conn.getResponseCode();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return getResponseCode;
	}
	
	/*
	 * getResponseCode()를 통해 200을 반환 받았다면
	 * 정상접속이므로 이 메소드를 통해 결과 값들을 받아올 수 있음.
	 */
	public JSONObject getResponseData() {
		JSONObject json = new JSONObject();
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			StringBuffer sb = new StringBuffer();
			String inputLine;
			
			while((inputLine = br.readLine()) != null) {
				sb.append(inputLine);
			}
			
			json = new JSONObject(sb.toString());
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return json;
	}
	
	/*
	 * 접속을 해제하는 메소드
	 */
	public void disConnection() {
		conn.disconnect();
	}
	
	/*
	 * 웹(web) 검색 결과를 파싱하는 메소드
	 */
	public LinkedList<kakaoWeb> webSearch(JSONObject json) {
		LinkedList<kakaoWeb> list = new LinkedList<kakaoWeb>();
		
		if(!json.isNull("documents")) {
			JSONArray ja = json.getJSONArray("documents");
			
			for(int i = 0; i < ja.length(); i++) {
				kakaoWeb web = new kakaoWeb();
				String title = ja.getJSONObject(i).getString("title");
				String contents = ja.getJSONObject(i).getString("contents");
				String url = ja.getJSONObject(i).getString("url");
				String datetime = ja.getJSONObject(i).getString("datetime");
				
				web.setTitle(title);
				web.setContents(contents);
				web.setUrl(url);
				web.setDatetime(datetime);
				list.add(web);
			}
		}
		else
			System.out.println("검색된 결과가 없습니다.");
		
		return list;
	}
	
	/*
	 * 동영상(vclip) 검색 결과를 파싱하는 메소드
	 */
	public LinkedList<kakaoVclip> vclipSearch(JSONObject json) {
		LinkedList<kakaoVclip> list = new LinkedList<kakaoVclip>();
		
		if(!json.isNull("documents")) {
			JSONArray ja = json.getJSONArray("documents");
			
			for(int i = 0; i < ja.length(); i++) {
				kakaoVclip vclip = new kakaoVclip();
				String title = ja.getJSONObject(i).getString("title");
				String url = ja.getJSONObject(i).getString("url");
				String datetime = ja.getJSONObject(i).getString("datetime");
				int play_time = 0;
				if(!ja.getJSONObject(i).getString("price").equals(""))
					play_time = ja.getJSONObject(i).getInt("play_time");
				String thumbnail = ja.getJSONObject(i).getString("thumbnail");
				String author = ja.getJSONObject(i).getString("author");
				
				vclip.setTitle(title);
				vclip.setUrl(url);
				vclip.setDatetime(datetime);
				vclip.setPlay_time(play_time);
				vclip.setThumbnail(thumbnail);
				vclip.setAuthor(author);
				list.add(vclip);
			}
		}
		else
			System.out.println("검색된 결과가 없습니다.");
		
		return list;
	}
	
	/*
	 * 이미지(image) 검색 결과를 파싱하는 메소드
	 */
	public LinkedList<kakaoImage> imageSearch(JSONObject json) {
		LinkedList<kakaoImage> list = new LinkedList<kakaoImage>();
		
		if(!json.isNull("documents")) {
			JSONArray ja = json.getJSONArray("documents");
			
			for(int i = 0; i < ja.length(); i++) {
				kakaoImage image = new kakaoImage();
				String collection = ja.getJSONObject(i).getString("collection");
				String thumbnail_url = ja.getJSONObject(i).getString("thumbnail_url");
				String image_url = ja.getJSONObject(i).getString("image_url");
				int width = 0;
				if(!ja.getJSONObject(i).getString("width").equals(""))
					width = ja.getJSONObject(i).getInt("width");
				int height = 0;
				if(!ja.getJSONObject(i).getString("height").equals(""))
					height = ja.getJSONObject(i).getInt("heigth");
				String display_sitename = ja.getJSONObject(i).getString("display_sitename");
				String doc_url = ja.getJSONObject(i).getString("doc_url");
				String datetime = ja.getJSONObject(i).getString("datetime");
				
				image.setCollection(collection);
				image.setThumbnail_url(thumbnail_url);
				image.setImage_url(image_url);
				image.setWidth(width);
				image.setHeight(height);
				image.setDisplay_sitename(display_sitename);
				image.setDoc_url(doc_url);
				image.setDatetime(datetime);
				list.add(image);
			}
		}
		else
			System.out.println("검색된 결과가 없습니다.");
		
		return list;
	}
	
	/*
	 * 블로그(blog) 검색 결과를 파싱하는 메소드
	 */
	public LinkedList<kakaoBlog> blogSearch(JSONObject json) {
		LinkedList<kakaoBlog> list = new LinkedList<kakaoBlog>();
		
		if(!json.isNull("documents")) {
			JSONArray ja = json.getJSONArray("documents");
			
			for(int i = 0; i < ja.length(); i++) {
				kakaoBlog blog = new kakaoBlog();
				String title = ja.getJSONObject(i).getString("title");
				String contents = ja.getJSONObject(i).getString("contents");
				String url = ja.getJSONObject(i).getString("url");
				String blogname = ja.getJSONObject(i).getString("blogname");
				String thumbnail = ja.getJSONObject(i).getString("thumbnail");
				String datetime = ja.getJSONObject(i).getString("datetime");
				
				blog.setTitle(title);
				blog.setContents(contents);
				blog.setUrl(url);
				blog.setBlogname(blogname);
				blog.setThumbnail(thumbnail);
				blog.setDatetime(datetime);
				list.add(blog);
			}
		}
		else
			System.out.println("검색된 결과가 없습니다.");
		
		return list;
	}
	
	/*
	 * 팁(tip) 검색 결과를 반환하는 메소드
	 */
	public LinkedList<kakaoTip> tipSearch(JSONObject json) {
		LinkedList<kakaoTip> list = new LinkedList<kakaoTip>();
		
		if(!json.isNull("documents")) {
			JSONArray ja = json.getJSONArray("documents");
			
			for(int i = 0; i < ja.length(); i++) {
				kakaoTip tip = new kakaoTip();
				String title = ja.getJSONObject(i).getString("title");
				String contents = ja.getJSONObject(i).getString("contents");
				String q_url = ja.getJSONObject(i).getString("q_url");
				String a_url = ja.getJSONObject(i).getString("a_url");
				JSONArray thumbs = ja.getJSONObject(i).getJSONArray("thumbnails");
				String[] thumbnails = new String[thumbs.length()];
				for(int j = 0; j < thumbs.length(); j++) {
					thumbnails[j] = thumbs.get(j).toString();
				}
				String type = ja.getJSONObject(i).getString("type");
				String datetime = ja.getJSONObject(i).getString("datetime");
				
				tip.setTitle(title);
				tip.setContents(contents);
				tip.setQ_url(q_url);
				tip.setA_url(a_url);
				tip.setThumbnails(thumbnails);
				tip.setType(type);
				tip.setDatetime(datetime);
				list.add(tip);
			}
		}
		else
			System.out.println("검색된 결과가 없습니다.");
		
		return list;
	}
	
	/*
	 * 책(book) 검색 결과를 파싱하는 메소드
	 */
	public LinkedList<kakaoBook> bookSearch(JSONObject json) {
		LinkedList<kakaoBook> list = new LinkedList<kakaoBook>();
		
		if(!json.isNull("documents")) {
			JSONArray ja = json.getJSONArray("documents");
			
			for(int i = 0; i < ja.length(); i++) {
				kakaoBook book = new kakaoBook();
				String title = ja.getJSONObject(i).getString("title");
				String contents = ja.getJSONObject(i).getString("contents");
				String url = ja.getJSONObject(i).getString("url");
				String isbn = ja.getJSONObject(i).getString("isbn");
				String datetime = ja.getJSONObject(i).getString("datetime");
				JSONArray author = ja.getJSONObject(i).getJSONArray("authors");
				String[] authors = new String[author.length()];
				for(int j = 0; j < author.length(); j++) {
					authors[j] = author.get(j).toString();
				}
				String publisher = ja.getJSONObject(i).getString("publisher");
				JSONArray translator = ja.getJSONObject(i).getJSONArray("translators");
				String[] translators = new String[translator.length()];
				for(int j = 0; j < translator.length(); j++) {
					translators[j] = translator.get(j).toString();
				}
				int price = 0;
				if(!ja.getJSONObject(i).getString("price").equals(""))
					price = ja.getJSONObject(i).getInt("price");
				int sale_price = 0;
				if(!ja.getJSONObject(i).getString("sale_price").equals(""))
					sale_price = ja.getJSONObject(i).getInt("sale_price");
				String sale_yn = ja.getJSONObject(i).getString("sale_yn");
				String category = ja.getJSONObject(i).getString("category");
				String thumbnail = ja.getJSONObject(i).getString("thumbnail");
				String barcode = ja.getJSONObject(i).getString("barcode");
				String ebook_barcode = ja.getJSONObject(i).getString("ebook_barcode");
				String status = ja.getJSONObject(i).getString("status");
				
				book.setTitle(title);
				book.setContents(contents);
				book.setUrl(url);
				book.setIsbn(isbn);
				book.setDatetime(datetime);
				book.setAuthors(authors);
				book.setPublisher(publisher);
				book.setTranslators(translators);
				book.setPrice(price);
				book.setSale_price(sale_price);
				book.setSale_yn(sale_yn);
				book.setCategory(category);
				book.setThumbnail(thumbnail);
				book.setBarcode(barcode);
				book.setEbook_barcode(ebook_barcode);
				book.setStatus(status);
				list.add(book);
			}
		}
		else
			System.out.println("검색된 결과가 없습니다.");
		
		return list;
	}
	
	/*
	 * 카페(cafe) 검색 결과를 파싱하는 메소드
	 */
	public LinkedList<kakaoCafe> cafeSearch(JSONObject json) {
		LinkedList<kakaoCafe> list = new LinkedList<kakaoCafe>();
		
		if(!json.isNull("documents")) {
			JSONArray ja = json.getJSONArray("documents");
			
			for(int i = 0; i < ja.length(); i++) {
				kakaoCafe cafe = new kakaoCafe();
				String title = ja.getJSONObject(i).getString("title");
				String contents = ja.getJSONObject(i).getString("contents");
				String url = ja.getJSONObject(i).getString("url");
				String cafename = ja.getJSONObject(i).getString("cafename");
				String thumbnail = ja.getJSONObject(i).getString("thumbnail");
				String datetime = ja.getJSONObject(i).getString("datetime");
				
				cafe.setTitle(title);
				cafe.setContents(contents);
				cafe.setUrl(url);
				cafe.setCafename(cafename);
				cafe.setThumbnail(thumbnail);
				cafe.setDatetime(datetime);
				list.add(cafe);
			}
		}
		else
			System.out.println("검색된 결과가 없습니다.");
		
		return list;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getHost() {
		return host;
	}

	public String getMethod() {
		return method;
	}

	public String getContentType() {
		return contentType;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
		
		this.address = this.host + this.request;
		if(!"".equals(getQuery()))
			this.address += "?query=" + getQuery();
		if(!"".equals(getSort()) && !"".equals(getQuery()))
			this.address += "&sort=" + getSort();
		if(!"".equals(getPage()) && !"".equals(getQuery()))
			this.address += "&page=" + getPage();
		if(!"".equals(getSize()) && !"".equals(getQuery()))
			this.address += "&size=" + getSize();
	}

	public String getAddress() {
		return address;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) throws UnsupportedEncodingException {
		this.query = URLEncoder.encode(query, "UTF-8");
		
		if(!"".equals(this.request))
			this.address = this.host + this.request;
		if(!"".equals(this.query) && !"".equals(this.request))
			this.address += "?query=" + this.query;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
		
		if(!"".equals(getQuery()))
			this.address += "&sort=" + this.sort;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
		
		if(!"".equals(getQuery()))
			this.address += "&page=" + this.page;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
		
		if(!"".equals(getQuery()))
			this.address += "&size=" + this.size;
	}
	
}