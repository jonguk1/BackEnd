package day02;

public class Point implements Comparable<Point>{

	private int x;
	private int y;
	
	public Point() {
		
	}
	
	public Point(int x,int y) {
		this.x=x; this.y=y;
	}

	public String toString() {
		return x+" "+y;
	}
	
	
	@Override
	public int compareTo(Point o) {
		if(this.x == o.x) {
			if(this.y ==o.y) {
				return 0;
			}else if(this.y<o.y) {
				return 1;
			}else {
				return -1;
			}
		}else if(this.x < o.x) {
			return 1;
		}else {
			return -1;
		}
	}
	
}
