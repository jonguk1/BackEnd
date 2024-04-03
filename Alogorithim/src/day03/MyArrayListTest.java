package day03;

public class MyArrayListTest {

	public static void main(String[] args) {
		// MyArrayList생성해서 Integer유형의 객체를 3개 저장한 후 반복문 이용해서 출력하세요
		MyArrayList<Integer> arr = new MyArrayList<>();
		arr.add(100);
		arr.add(200);
		arr.add(300);
		for(int i=0;i<arr.size();i++) {
			Integer val=arr.get(i);
			System.out.println(val);
		}
		int idx=arr.indexOf(300);
		System.out.println("idx: " + idx);
		
		System.out.println(arr.indexOf(780));
		System.out.println("---300 삭제----------------------");
		if(arr.indexOf(300)!=-1) {
			arr.remove(arr.indexOf(300));
		}
		System.out.println("---삭제후------------------");
		for(int i=0;i<arr.size();i++) {
			Integer val=arr.get(i);
			System.out.println(val);
		}
		
		MyArrayList<Member> arr2=new MyArrayList<>();
		arr2.add(new Member("이선화",22,170));
		arr2.add(new Member("최철수",25,160));
		
		System.out.println(arr2.get(0));

	}

}
