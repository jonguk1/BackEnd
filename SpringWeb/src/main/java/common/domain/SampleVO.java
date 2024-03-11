package common.domain;

public class SampleVO {

	private String tname;
	private String tabType;

	public SampleVO() {
		System.out.println("SampleVO생성자");
	}
	
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getTabType() {
		return tabType;
	}
	public void setTabType(String tabType) {
		this.tabType = tabType;
	}
	
	
}
