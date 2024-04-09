package ex01;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class TestMongodb {

	public static void main(String[] args) {
		String db="mydb";
		String table="posts";//�÷��Ǹ�
		
		MongoClient mongo_client=null;
		MongoDatabase mongodb=null;
		MongoCollection<Document> collection=null; 
		
		//������ ����
		mongo_client=MongoClients.create("mongodb://localhost:27017");
		System.out.println("mongo_client" + mongo_client);
	
		mongodb=mongo_client.getDatabase(db);//use mydb�� ����
		
		collection=mongodb.getCollection(table);
		System.out.println(table + "�÷��� ���� ����!!");
		
		Document doc = new Document();
		doc.append("author", "ȫ�浿");
		doc.append("title", "���� ������ �׽�Ʈ��")
			.append("wdate", "2024-04-09");
		
		collection.insertOne(doc);
		System.out.println("post�÷��ǿ� ��ť��Ʈ ���� ����!!");
		
		mongo_client.close();	
	}

}
