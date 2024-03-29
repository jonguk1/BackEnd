package day01;
import java.util.*;

public class Q4_MinMaxHeight {

	public static int[] min_max(int[] heights) {
		
		Arrays.sort(heights);

		int min= heights[0];
		int max= heights[heights.length-1];
		
		int[] arr = new int[2];
		
	    arr[0] = min;
	    arr[1] = max;
		
		return arr;//�ִ�,�ּҰ��� ���� �迭 ��ȯ
	}
	
	public static void main(String[] args) {
		System.out.println("��� ���� �Է��ϼ���: ");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		//�迭 ������
		int[] arr = new int[num];
		//Random Ŭ���� �̿�. �迭�� Ű���� �����ϼ��� (100 ~ 190)
		Random rd = new Random();
		for(int i =0;i<arr.length;i++) {
			arr[i] = rd.nextInt(91) + 100;
		}
		//min_max()ȣ���ؼ� ���� ū Ű, ���� ���� Ű �� ����ϱ�
		System.out.println("ū Ű: "  + min_max(arr)[1]);
		System.out.println("���� Ű: "  + min_max(arr)[0]);
	}

}
