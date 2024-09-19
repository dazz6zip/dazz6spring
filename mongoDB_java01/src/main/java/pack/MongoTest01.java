package pack;

import java.util.function.Consumer;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class MongoTest01 {

	public static void main(String[] args) {
		// Application project : Java + MongoDB
		try {
			MongoClient client = MongoClients.create("mongodb://localhost:27017");
			MongoDatabase db = client.getDatabase("test");
			MongoCollection<Document> collection = db.getCollection("customer");
			System.out.println("자료 건수 : " + collection.countDocuments());
			
			// 한 개의 Document(Record) 읽기 
			Document document = collection.find().first();
			System.out.println("첫 번째 자료 : " + document.toJson());
			
			System.out.println("\n\n전체 자료");
//			FindIterable<Document> iter = collection.find();
//			MongoCursor<Document> cursor = iter.iterator();
			
			MongoCursor<Document> cursor = collection.find().iterator();
//			MongoCursor<Document> cursor = collection.find().limit(2).iterator();
			
			while(cursor.hasNext()) {
				String jsonResult = cursor.next().toJson();
				System.out.println(jsonResult);
			}
			
			System.out.println("\n\n전체 자료 : 필드(컬럼) 자료만 출력");
			cursor = collection.find().iterator();
			
			while(cursor.hasNext()) {
				Document doc = cursor.next();
				System.out.println("이름 : " + doc.get("name") + ", 나이 : " + doc.get("age") + ", 성별 : " + doc.get("gender"));
			}
			
			System.out.println("\n");
			collection.find().forEach(printData);

		} catch (Exception e) {
			System.out.println("ERROR : " + e.getMessage());
		}

	}
	
	// Block<Document> 대신 Consumer<Document>
	static Consumer<Document> printData = new Consumer<Document>() {
		
		@Override
		public void accept(Document d) {
			System.out.println(d.toJson());
			
		}
	};
	

}
