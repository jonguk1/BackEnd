package board.model;

import java.sql.Date;

public class BoardVO {

	//property
	private int num;
	private String name;
	private String passwd;
	private String title;
	private String content;
	private java.sql.Date wdate;
	
	private int readnum;//조회수
	private String fileName;//첨부파일명
	private long fileSize;//첨부파일크기
	
	public BoardVO() {//기본생성자
		
	}
	//인자 생성자
	public BoardVO(int num, String name, String passwd, String title, String content, Date wdate, int readnum,
			String fileName, long fileSize) {
		super();
		this.num = num;
		this.name = name;
		this.passwd = passwd;
		this.title = title;
		this.content = content;
		this.wdate = wdate;
		this.readnum = readnum;
		this.fileName = fileName;
		this.fileSize = fileSize;
	}
	
	//setter,getter
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public java.sql.Date getWdate() {
		return wdate;
	}
	public void setWdate(java.sql.Date wdate) {
		this.wdate = wdate;
	}
	public int getReadnum() {
		return readnum;
	}
	public void setReadnum(int readnum) {
		this.readnum = readnum;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public long getFileSize() {
		return fileSize;
	}
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
	//toString()
	@Override
	public String toString() {
		return "BoardVO [num=" + num + ", name=" + name + ", title=" + title + ", content=" + content + ", wdate="
				+ wdate + ", readnum=" + readnum + ", fileName=" + fileName + ", fileSize=" + fileSize + "]";
	}
}
