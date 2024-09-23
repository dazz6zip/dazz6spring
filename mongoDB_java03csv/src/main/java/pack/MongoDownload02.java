package pack;

import java.io.ByteArrayOutputStream;

import org.bson.types.ObjectId;
import org.json.JSONArray;
import org.json.JSONObject;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import com.mongodb.client.gridfs.model.GridFSFile;

public class MongoDownload02 {

	public static void main(String[] args) {
		String connString = "mongodb://localhost:27017";

		try (MongoClient mc = MongoClients.create(connString)) {
			MongoDatabase database = mc.getDatabase("katalkDB");
			
			GridFSBucket gfb = GridFSBuckets.create(database, "katalkFiled");
			
			// 모든 파일의 ObjectId 얻기
			MongoCursor<GridFSFile> cursor = gfb.find().iterator();
			
			while(cursor.hasNext()) {
				GridFSFile gff = cursor.next();
				ObjectId field = gff.getObjectId();
				
				ByteArrayOutputStream ops = new ByteArrayOutputStream();
				
				try {
					gfb.downloadToStream(field, ops);
					String fc = new String(ops.toByteArray());
//					System.out.println("ObjectId " + field.toHexString() + " : " + fc);

					// JSON 데이터 파싱
					if(fc.trim().startsWith("[")) {
						// 파일 내용이 JSON 배열이면 '['로 시작 -> 배열로 처리함
						JSONArray ja = new JSONArray(fc);
						for (int i = 0; i < ja.length(); i++) {
							JSONObject jo = ja.getJSONObject(i);
							String req = jo.getString("req");
							String res = jo.getString("res");
							
							System.out.println("Q. " + req + " -> A. : " + res );
						}
					} else {
						// JSON 객체가 한 개인 경우
						JSONObject jo = new JSONObject(fc);
						String req = jo.getString("req");
						String res = jo.getString("res");
						
						System.out.println("Q. " + req + " -> A. : " + res );
					}
				} catch (Exception e) {
					System.out.println("ObjectId NOT FOUND : " + field.toHexString());
				}
			}
			
		} catch (Exception e) {
			System.out.println("ERROR : " + e.getMessage());
		}

	}
}
