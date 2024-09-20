package pack;

import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import pack.MongoTest02.Customer;

public class MongoTest03 {
	
	public static void main(String[] args) {
		// 불특정 필드 처리 : 동적 처리
		String uri = "mongodb://localhost:27017";
		
		try(MongoClient client = MongoClients.create(uri)) {
			MongoDatabase db = client.getDatabase("test");
			MongoCollection<Document> collection = db.getCollection("customer");
			
			for(Document doc : collection.find()) {
				// 각 Document 내의 field (Key - Value)
				for(Entry<String, Object> entry : doc.entrySet()) {
					String fieldKey = entry.getKey();
					Object fieldValue = entry.getValue();
					
					System.out.print(fieldKey + " : " + fieldValue + "\t");
					
				}
				System.out.println();
			}
			
			System.out.println("건수 : " + collection.countDocuments());
		} catch (Exception e) {
			System.out.println("ERROR : " + e.getMessage());
		}
	}

}
