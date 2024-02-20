package quiz04;

public class Company {
	
	String industry;
	int employee;
	String companyType;
	String url;
	String name;
	
	public void companyInfo() {
		System.out.println("-----기업정보----");
		System.out.println("산업(업종): " + industry );
		System.out.println("사원수: " + employee + "명" );
		System.out.println("기업형태: " + companyType);
		System.out.println("홈페이지: " + url);
	}
	
	public String position(String type,int salary,String location) {
		String str = "";
		
		str = "----" + name + "의 근무조건 ----\n";
		str +="고용형태: " + type + "\n";
		str +="급여: " + salary + "만원" + "\n";
		str +="지역: " + location;
		
		return str;
	}
	

}
