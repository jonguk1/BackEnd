package com.board.domain;

import lombok.Data;
/*����¡ ó�� �� �˻� ����� ���ȭ�Ͽ�
 * ���� �����ϵ��� ó������
 * */

@Data
public class PagingVO {
	//����¡ ���� ������Ƽ
	private int pageNum;//���� ������
	private int oneRecordPage=5;//�� ������ �� ������ ��� ����
	private int totalCount;//�� �Խñ� ��
	private int pageCount;//������ ��
	
	//DB���� ���ڵ� ������� ���� ������Ƽ
	private int start;
	private int end;
	
	//����¡ ��ó�� ���� ������Ƽ
	private int pagingBlock=5;//�� �� �� ������ ��������
	private int prevBlock;//���� 5�� (���� ��)
	private int nextBlock;//���� 5�� (���� ��)
	
	//�˻� ���� ������Ƽ
	private String findType;//�˻�����
	private String findKeyword;//�˻���
	
	public void init() {
		if(findType==null) {
			findType="";
		}
		if(findKeyword==null) {
			findKeyword="";
		}
		//������ �� ���ϱ�
		pageCount=(totalCount-1)/oneRecordPage+1;
	
		if(pageNum<1) {
			pageNum=1;//1�������� ����Ʈ��
		}
		
		if(pageNum>pageCount) {
			pageNum=pageCount;//������ �������� ����
		}
		
		start=(pageNum-1)*oneRecordPage;
		end = start +(oneRecordPage+1);
		
		prevBlock=(pageNum-1)/pagingBlock*pagingBlock;
		nextBlock=prevBlock+(pagingBlock+1);
		
	}
	
	/**������ �׺���̼� ���ڿ��� ��ȯ�ϴ� �޼���
     * myctx: ���ؽ�Ʈ��(/campus)
     * loc : board/list
     * */
    public String getPageNavi(String myctx, String loc) {
        String link=myctx+"/"+loc; // /campus/board/list
        String qStr="?findType="+findType+"&findKeyword="+findKeyword;
        link+=qStr;
        
        StringBuilder buf=new StringBuilder();
        buf.append("<ul class='pagination justify-content-center'>");
        
        if(prevBlock>0) {
            buf.append("<li class='page-item'>")
                .append("<a class='page-link' href='"+link+"&pageNum="+prevBlock+"'>")
                .append("Prev")
                .append("</a>")
                .append("</li>");
        }
        for(int i=prevBlock+1;i<=nextBlock-1 && i<=pageCount  ;i++) {
            String css=(i==pageNum)?"active":"";
            buf.append("<li class='page-item "+css+"'>")
            .append("<a class='page-link' href='"+link+"&pageNum="+i+"'>")
            .append(i)
            .append("</a>")
            .append("</li>");
            
        }//for------
        if(nextBlock <= pageCount) {
            buf.append("<li class='page-item'>")
                .append("<a class='page-link' href='"+link+"&pageNum="+nextBlock+"'>")
                .append("Next")
                .append("</a>")
                .append("</li>");
        }
        buf.append("</ul>");
        return buf.toString();
    }//----------------------------------------------
	
	
}
