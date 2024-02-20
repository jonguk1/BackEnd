package day05;

public class ArrayTest5 {

	public static void main(String[] args) {
		String[] name = {"아버지","어머니","형","나","동생"};
		int[] age = {100,88,33,24,10};
		float[] height={177.5f,152.2f,190.3f,167.7f,155.3f};
		
		System.out.println("우리집 식구 정리");
		System.out.println("--------------------");
	    System.out.println("이름\t나이\t키");
	    System.out.println("--------------------");
	    for(int i =0;i<name.length;i++) {
	    	System.out.println(name[i] + "\t" + age[i] + "\t" + height[i]);
	    }

	}

}
