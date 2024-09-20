package pack;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import com.mongodb.client.gridfs.model.GridFSUploadOptions;
import com.opencsv.CSVReader;

public class MongoUpload {

	public static void main(String[] args) {
		// SNS(카카오톡) 데이터를 MongoDB 에 저장

		String uri = "mongodb://localhost:27017";

		try (MongoClient client = MongoClients.create(uri)) {
			MongoDatabase database = client.getDatabase("katalkDB");

			GridFSBucket gfb = GridFSBuckets.create(database, "katalkFiled");

			// csv 파일을 읽어 분산 저장
			ClassLoader clr = MongoUpload.class.getClassLoader();
			InputStream ips = clr.getResourceAsStream("katalkdata.csv");

			if (ips != null) {
//				System.out.println("자료 읽기 성공");
				uploadCSV2Mongo(ips, gfb);
			} else {
				System.out.println("해당하는 자료가 없습니다.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void uploadCSV2Mongo(InputStream ips, GridFSBucket gfb) {
		try(
			BufferedReader rd = new BufferedReader(new InputStreamReader(ips));
			CSVReader crd = new CSVReader(rd);
			) {
			
			// csv 파일의 모든 자료를 읽어 리스트로 저장
			List<String[]> records = crd.readAll();
			
			for(String[] record : records) {
				// 각 행을 BSON Document 로 변환
				// 첫 번째 필드 : req
				// 두 번째 필드 : res
				Document doc = new Document("req", record[0]).append("res", record[1]);
				
				// 저장 옵션 설정 : 1MB 크기의 묶음 (chunk) 으로 나누어 저장 -> 대용량 자료 저장시 효과적
				GridFSUploadOptions options = new GridFSUploadOptions().chunkSizeBytes(1024 * 1024);
				
				// BSON Document 를 JSON 형식의 Byte 배열로 변환
				ByteArrayInputStream bais = new ByteArrayInputStream(doc.toJson().getBytes());
				
				ObjectId field = gfb.uploadFromStream("katalkdata", bais, options);
				
				// 저장된 파일의 ObjectId 확인
				System.out.println("ObjectId : " + field.toHexString());
			}
			
		} catch (Exception e) {
			System.out.println("uploadCSV2Mongo ERROR : " + e.getMessage());
		}
	}
}
