import java.util.LinkedList;

import org.json.JSONObject;

import kakaoConnection.kakaoConnection;
import vo.kakaoBlog;
import vo.kakaoBook;
import vo.kakaoCafe;
import vo.kakaoImage;
import vo.kakaoTip;
import vo.kakaoVclip;
import vo.kakaoWeb;

public class KakaoApi {
	public static void main(String[] args) {
		try {
			String apiKey = "발급 받은 키";
			String request = "web"; // web, vclip, image, blog, tip, book, cafe
			String query = "알고리즘";
			String sort = "accuracy";
			String page = "2";
			String size = "10";
			
			LinkedList<kakaoWeb> webList = new LinkedList<kakaoWeb>();
			LinkedList<kakaoVclip> vclipList = new LinkedList<kakaoVclip>();
			LinkedList<kakaoImage> imageList = new LinkedList<kakaoImage>();
			LinkedList<kakaoBlog> blogList = new LinkedList<kakaoBlog>();
			LinkedList<kakaoTip> tipList = new LinkedList<kakaoTip>();
			LinkedList<kakaoBook> bookList = new LinkedList<kakaoBook>();
			LinkedList<kakaoCafe> cafeList = new LinkedList<kakaoCafe>();
			
			kakaoConnection kc = new kakaoConnection();
			
			// 생성자 예제
			kc = new kakaoConnection(apiKey, request, query);
			//kc = new kakaoConnection(apiKey, request, query, sort, page, size);
			
			int responseCode = kc.getResponseCode();
			
			if(responseCode == 200) {
				JSONObject json = kc.getResponseData();
				
				// request에 입력된 값에 따라 어떤 검색 결과인지 알아내서
				// request에 맞게 파싱을 하고 리턴 받음.
				if("web".equals(request))
					webList = kc.webSearch(json);
				if("vclip".equals(request))
					vclipList = kc.vclipSearch(json);
				if("image".equals(request))
					imageList = kc.imageSearch(json);
				if("blog".equals(request))
					blogList = kc.blogSearch(json);
				if("tip".equals(request))
					tipList = kc.tipSearch(json);
				if("book".equals(request))
					bookList = kc.bookSearch(json);
				if("cafe".equals(request))
					cafeList = kc.cafeSearch(json);
			}
			
			// 위에서 파싱되어 반환된 객체만 정상적으로 출력되고 나머지는 null
			if(webList != null) {
				for(int i = 0; i < webList.size(); i++)
					System.out.println(webList.get(i).toString());
			}
			if(vclipList != null) {
				for(int i = 0; i < vclipList.size(); i++)
					System.out.println(vclipList.get(i).toString());
			}
			if(imageList != null) {
				for(int i = 0; i < imageList.size(); i++)
					System.out.println(imageList.get(i).toString());
			}
			if(blogList != null) {
				for(int i = 0; i < blogList.size(); i++)
					System.out.println(blogList.get(i).toString());
			}
			if(tipList != null) {
				for(int i = 0; i < tipList.size(); i++)
					System.out.println(tipList.get(i).toString());
			}
			if(bookList != null) {
				for(int i = 0; i < bookList.size(); i++)
					System.out.println(bookList.get(i).toString());
			}
			if(cafeList != null) {
				for(int i = 0; i < cafeList.size(); i++)
					System.out.println(cafeList.get(i).toString());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}