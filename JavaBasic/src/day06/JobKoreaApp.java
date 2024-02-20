package day06;

public class JobKoreaApp {

	public static void main(String[] args) {
		//JobSeeker객체 1개 생성해서 속성값을 각각 부여한 뒤
		//profile()메서드를 호출해 정보를 출력하세요
		JobSeeker seeker = new JobSeeker();
		seeker.setName("홍길동");
		seeker.setBirth(1992);
		seeker.setGender('M');
		seeker.setPhone("010-1234-5678");
		
		String str = seeker.profile();
		System.out.println(str);
		
		//[1]구직자 객체를 1개 더 생성하고 속성값 부여 프로필 출력
		JobSeeker seeker2 = new JobSeeker();
		
		seeker2.setName("이영자");
		seeker2.setBirth(1998);
		seeker2.setGender('F');
		seeker2.setPhone("010-5678-1234");
		
		String str2 = seeker2.profile();
		System.out.println(str2);

		//[2] 위에서 생성한 구직자 객체 2개를 배열에 저장한 뒤
		//   반복문 이용해서 구직자 정보를 모두 출력하세요
		JobSeeker[] profileList = {seeker,seeker2};
		
		for(int i =0;i<profileList.length;i++) {
			System.out.println(profileList[i].profile());
		}
		
		System.out.println("#####################");
		//for-each 루프로 출력
		for(JobSeeker seeker3: profileList ) {
			System.out.println(seeker3.getName());
		}
		
		
		
	}

}
