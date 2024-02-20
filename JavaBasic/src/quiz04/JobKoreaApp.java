package quiz04;
//구직자 or 구인회사 클래스를 별도 작성
public class JobKoreaApp {

	public static void main(String[] args) {
		Company com1 = new Company();
		Company com2 = new Company();
		
		com1.industry="호텔";
		com1.employee=200;
		com1.companyType="중소기업(비상장)";
		com1.url="https://www.koreanfolk.co.kr/";
		
		com2.industry="건물 건설업";
		com2.employee=1220;
		com2.companyType="대기업(코스피)";
		com2.url="https://www.kumhoenc.com/main/index.asp";
		
	    com1.companyInfo();
	    com2.companyInfo();
	    
	    com1.name = "카카오";
	    System.out.println(com1.position("정규직", 4000, "경기도 성남시 분당구"));
	    
	    com2.name = "우아한형제들";
	    System.out.println(com2.position("계약직", 3000, "서울시 송파구"));
		
	}

}
