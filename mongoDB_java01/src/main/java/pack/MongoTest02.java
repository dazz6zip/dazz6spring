package pack;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Updates;

import static com.mongodb.client.model.Filters.eq;

public class MongoTest02 {
	// Customer 콜렉터를 저장하는 별도의 클래스 사용
	
	static class Customer {
		private ObjectId id;
		private String name;
		private int age;
		private String gender;
		
		public Customer(ObjectId id, String name, int age, String gender ) {
			this.id = id;
			this.name = name;
			this.age = age;
			this.gender = gender;
		}
		
		@Override
		public String toString() {
			return id + "\t" + name + "\t" + age + "\t" + gender;
		}
	}
	

	public static void main(String[] args) {
		String uri = "mongodb://localhost:27017";
		
		try(MongoClient client = MongoClients.create(uri)) {
			MongoDatabase db = client.getDatabase("test");
			MongoCollection<Document> collection = db.getCollection("customer");
			
			/* 자료 추가 */
//			Document newData = new Document("name", "폼폼푸린").append("age", "26").append("gender", "남");
//			collection.insertOne(newData);
			
			
			/* 수정, 삭제를 위한 대상 자료 찾기 */
			
			// SELECT * FROM customer WHERE name = '관우' LIMIT 1;
//			Document fCustomer = collection.find(eq("name", "폼폼푸린")).first();
			Document fCustomer = collection.find(eq("name", "짱구")).first();
			
			if(fCustomer != null) {
				// 해당하는 정보를 찾은 경우
				ObjectId cusId = fCustomer.getObjectId("_id");
				
				/* 자료 수정 */
//				collection.updateOne(eq("_id", cusId), Updates.combine(Updates.set("name", "짱구"),Updates.set("age", "26"), Updates.set("gender", "여")));

				/* 자료 삭제 */
				collection.deleteOne(eq("_id", cusId));
				System.out.println("삭제 성공");
				
			} else {
				System.out.println("해당하는 자료가 없습니다.");
			}
			
			
			/* 출력 */
			List<Customer> customers = new ArrayList<MongoTest02.Customer>();
			for (Document doc : collection.find()) {
				
				// age 필드가 Integer 또는 String 일 수 있으므로 이에 대한 처리
				Object ageObj = doc.get("age");
				int age = 0;
				
				if(ageObj instanceof Integer) {
					// ageObj 가 Integer type 이면 true
					age = (Integer)ageObj;	
					
				} else if (ageObj instanceof String) {
					// ageObj 가 String type 이면 true
					
					try {
						// String 을 Integer 로 변환
						age = Integer.parseInt((String) ageObj);
						
					} catch (Exception e) {
						System.out.println("invalid age format : " + ageObj);
						System.out.println("ERROR : " + e.getMessage());
						
					}
				}
				
				Customer customer = new Customer(doc.getObjectId("_id"), doc.getString("name"), age, doc.getString("gender"));
				customers.add(customer);
			}
			
			System.out.println("id\t\t\t\tname\tage\tgender");
			for (Customer cus : customers) {
				
				// toString 을 @Override 했으므로 cus.toString 으로 명시해 주지 않아도 됨
				System.out.println(cus);
			}
			
			System.out.println("건수 : " + collection.countDocuments());
			
		} catch (Exception e) {
			System.out.println("ERROR : " + e.getMessage());
		}

	}

}
