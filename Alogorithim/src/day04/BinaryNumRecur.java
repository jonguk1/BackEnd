package day04;
//����Լ��� �̿��Ͽ� 10���� ����(���)�� 2������ �ٲپ� ����ϱ�
public class BinaryNumRecur {
	
	public static void binary(int num) {
		//��������
		if(num<=0) return;
		//��� �ܰ�		
		binary(num/2);
		System.out.print(num%2);		
	}//-----------------
	public static void radixNum(int num, int radix) {
		if(num<=0) return;
		radixNum(num/radix, radix);
		String str="0123456789ABCDEF";
		System.out.print(str.charAt(num%radix));
	}//-----------------
	public static void main(String[] args) {
		//binary(5);
		//binary(8);
		radixNum(45, 8);//8������ ��ȯ
		System.out.println();
		radixNum(45,16);//16������ ��ȯ
	}//----------------------

}///////////////////////////////////////
