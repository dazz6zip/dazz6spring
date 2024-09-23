package pack;

import java.io.ByteArrayOutputStream;

import org.bson.types.ObjectId;
import org.json.JSONObject;

import com.mongodb.MongoGridFSException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;

public class MongoDownload01 {

	public static void main(String[] args) {
		// 분산 저장된 MongoDB 자료 부분 읽기
		
		String connString = "mongodb://localhost:27017";
		
		try(MongoClient mc = MongoClients.create(connString)) {
			GridFSBucket gfb = GridFSBuckets.create(mc.getDatabase("katalkDB"), "katalkFiled");
			ObjectId[] fields = {
				// 여기서 id는 _id 가 아닌 files_id 임
				new ObjectId("66ecf485f5ecb7414cc32bc7"),
				new ObjectId("66ecf485f5ecb7414cc32bc9"),
				new ObjectId("66ecf485f5ecb7414cc32bcb")	
			};
			
			for (ObjectId oi : fields) {
				downloadAndPrint(gfb, oi);
			}
			
		} catch (Exception e) {
			System.out.println("ERROR : " + e.getMessage());
		}

	}
	
	// 파일 읽기 (다운로드) + 출력
	public static void downloadAndPrint(GridFSBucket gfb, ObjectId oi) {
		try {
			
			ByteArrayOutputStream aps = new ByteArrayOutputStream();
			gfb.downloadToStream(oi, aps);
			
			// outputStream의 자료를 문자열로 변환
			String fc = new String(aps.toByteArray());
//			System.out.println("fileContent for objectId : " + oi + " -> " + fc);
			
			// JSON parsing
			JSONObject jo = new JSONObject(fc);
			String req = jo.getString("req");
			String res = jo.getString("res");
			
			System.out.println("Q. " + req + " -> A. : " + res );

		} catch (MongoGridFSException e) {
			System.out.println("FILE NOT FOUND ERROR : " + e.getMessage());
		} catch (Exception e) {
			System.out.println("downloadAndPrint ERROR : " + e.getMessage());
		}
	}

}
