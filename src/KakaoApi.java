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
			String apiKey = "�߱޹��� ApiKey���� �Է�";
			String request = "web"; // web, vclip, image, blog, tip, book, cafe
			String query = "�˰���";
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
			
			// ������ ����
			kc = new kakaoConnection(apiKey, request, query);
			kc = new kakaoConnection(apiKey, request, query, sort, page, size);
			
			int responseCode = kc.getResponseCode();
			
			if(responseCode == 200) {
				JSONObject json = kc.getResponseData();
				
				// request�� �Էµ� ���� ���� � �˻� ������� �˾Ƴ���
				// request�� �°� �Ľ��� �ϰ� ���� ����.
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
			
			// ������ �Ľ̵Ǿ� ��ȯ�� ��ü�� ���������� ��µǰ� �������� null
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