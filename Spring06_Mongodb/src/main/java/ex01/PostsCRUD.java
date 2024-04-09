package ex01;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Updates;

//import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.*;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
public class PostsCRUD {

	private MongoClient mclient;
	private MongoDatabase mdb;
	private MongoCollection<Document> mcol;
	private Scanner sc = new Scanner(System.in);
	
	public PostsCRUD() {
		mclient=MongoClients.create("mongodb://localhost:27017");
		mdb=mclient.getDatabase("mydb");
		mcol=mdb.getCollection("posts");
		System.out.println("MongoDB connected...");
	}
	
	public void close() {
		if(mclient!=null) mclient.close();
	}
	
	public static void main(String[] args) {
		PostsCRUD app = new PostsCRUD();
		//app.insertPosts();//C
		//app.deletePosts();//D
		app.updatePosts();//U
		System.out.println("---POST ���-------------------");
		app.selectAllPosts();//R
		//app.findPosts();//R
		app.close();
	}

	public void updatePosts() {
		System.out.println("�˻��� �ۼ��ڸ�: ");
		String author=sc.nextLine();
		System.out.println("������ ����: ");
		String title=sc.nextLine();
		
		Bson query=eq("author", author);
		Bson edit=Updates.combine(Updates.set("title", title));
		
		UpdateResult res=mcol.updateMany(query, edit);
		long cnt=res.getModifiedCount();
		System.out.println(cnt+"���� ��ť��Ʈ ������");
	}

	public void deletePosts() {
		System.out.println("������ ���� �ۼ��ڸ� �Է�: ");
		String author=sc.nextLine();
		
		Bson query=eq("author", author);
		
		DeleteResult res=mcol.deleteOne(query);
		long cnt=res.getDeletedCount();
		System.out.println(cnt+"���� ��ť��Ʈ ���� �Ϸ�!!");
		
	}

	public void findPosts() {
		System.out.println("�˻��� author �Է�: ");
		String author=sc.nextLine();
		//Bson query=Filters.eq("author", author);//$eq
		
		Bson query=eq("author", author);
		
		//Filters.eq()... static�޼���. static import�� �̿��ϸ�
		//Ŭ�������� �����ϰ� ��밡���ϴ�
		
		
		FindIterable<Document> cr = mcol.find(query);
		for(Document doc:cr) {
			String title=doc.getString("title");
			String author2=doc.getString("author");
			String wdate=doc.getString("wdate");
			System.out.println(title+"\t"+author2+"\t"+wdate);
		}
		
	}

	public void selectAllPosts() {
		FindIterable<Document> it = mcol.find();
		MongoCursor<Document> mcr=it.iterator();
		
		while(mcr.hasNext()) {
			Document doc = mcr.next();
			String title=doc.getString("title");
			String author=doc.getString("author");
			String wdate=doc.getString("wdate");
			System.out.println(title+"\t"+author+"\t"+wdate);
		}
		if(mcr!=null) mcr.close();
	}

	public void insertPosts() {
		System.out.println("author:	");
		String author=sc.nextLine();
		System.out.println("title:	");
		String title=sc.nextLine();
		Date today=new Date();
		String wdate=new SimpleDateFormat("yyyy-MM-dd").format(today);
		
		Document doc=new Document()
					.append("author", author)
					.append("title", title)
					.append("wdate", wdate);
		InsertOneResult res= mcol.insertOne(doc);
		System.out.println(res.getInsertedId()+" ��ť��Ʈ�� �����Ǿ����");
	}

}
