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
			String apiKey = "34ffe4125b376ddf83937fbc9d557331";
			String request = "web"; // web, vclip, image, blog, tip, book, cafe
			String query = "알고리즘";
			String sort = "accuracy";
			String page = "2";
			String size = "10";
			kakaoWeb kakaoweb = new kakaoWeb();
			kakaoVclip kakaovclip = new kakaoVclip();
			kakaoImage kakaoimage = new kakaoImage();
			kakaoBlog kakaoblog = new kakaoBlog();
			kakaoTip kakaotip = new kakaoTip();
			kakaoBook kakaobook = new kakaoBook();
			kakaoCafe kakaocafe = new kakaoCafe();
			kakaoConnection kc = new kakaoConnection();
			
			// 생성자 예제
			kc = new kakaoConnection(apiKey, request, query);
			kc = new kakaoConnection(apiKey, request, query, sort, page, size);
			
			int responseCode = kc.getResponseCode();
			
			if(responseCode == 200) {
				JSONObject json = kc.getResponseData();
				
				// request에 입력된 값에 따라 어떤 검색 결과인지 알아내서
				// request에 맞게 파싱을 하고 리턴 받음.
				if("web".equals(request))
					kakaoweb = kc.webSearch(json);
				if("vclip".equals(request))
					kakaovclip = kc.vclipSearch(json);
				if("image".equals(request))
					kakaoimage = kc.imageSearch(json);
				if("blog".equals(request))
					kakaoblog = kc.blogSearch(json);
				if("tip".equals(request))
					kakaotip = kc.tipSearch(json);
				if("book".equals(request))
					kakaobook = kc.bookSearch(json);
				if("cafe".equals(request))
					kakaocafe = kc.cafeSearch(json);
			}
			
			// 위에서 파싱되어 반환된 객체만 정상적으로 출력되고 나머지는 null
			System.out.println(kakaoweb.toString());
			System.out.println(kakaovclip.toString());
			System.out.println(kakaoimage.toString());
			System.out.println(kakaoblog.toString());
			System.out.println(kakaotip.toString());
			System.out.println(kakaobook.toString());
			System.out.println(kakaocafe.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}