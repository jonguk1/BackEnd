package day02;

import java.util.Arrays;
import java.util.Scanner;

/*�����˻�
 * - ����Ʈ, �迭�� �̿�
 * - ���ĵǾ� �ִ� �ڷᱸ���� �ؾ� ��
 * - O(log n)
 * - 100���� �����Ͱ� �ִٸ� O(log 100) ==>�־��� ��� 7������ �˻��� ��ĥ �� ����
 * */
public class BinarySearch {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("�迭 ũ�� �Է�: ");
		int n =sc.nextInt();
		
		int[] arr=new int[n];
		System.out.println("������ ������ �Է�: ");
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		System.out.println("�˻��� ������ �Է�: ");
		int key=sc.nextInt();
		int idx=binarySearch(arr,n,key);
		System.out.println("idx: " + idx);
	}
	
	public static int binarySearch(int[] arr, int n, int key) {
		Arrays.sort(arr);
		System.out.println("---�������� ���� ��----------------");
		System.out.println(Arrays.toString(arr));
		System.out.println("------------------------------");
		int left=0;
		int right=n-1;
		int center=0;//�߾� ��ġ�� �ε��� ����
		
		//�ݺ��� ���鼭 �迭�� �߾� ��ġ�� ����� ���� key���� ��
		int cnt=0;
		while(left<=right) {
			cnt++;
			center=(left+right)/2;
			if(key==arr[center]) {
				System.out.println(cnt+ "�� ���� ã�ҳ׿�");
				return center;
			}else if(key>arr[center]) {
				left=center+1;
			}else {
				right=center-1;
			}
		}
		
		return -1;
		
	}

}
