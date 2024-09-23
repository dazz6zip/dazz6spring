package pack.controller;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mongodb.client.MongoClient;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import com.mongodb.client.gridfs.model.GridFSFile;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;
import pack.model.KatalkData;

@Controller
public class KatalkDataController {
	
	@Autowired
	private MongoClient mc;

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/show")
	public String process(Model model) {
		
		List<KatalkData> kdl = new ArrayList<KatalkData>();
		GridFSBucket gfbs = GridFSBuckets.create(mc.getDatabase("katalkDB"), "katalkFiled");
		
		try {
			// GridFS에서 저장된 파일을 하나씩 읽기
			for(GridFSFile gfb : gfbs.find()) {
				ObjectId field = gfb.getObjectId();
				
				ByteArrayOutputStream ops = new ByteArrayOutputStream();
				gfbs.downloadToStream(field, ops);

				String fc = new String(ops.toByteArray());
				
				if(fc.trim().startsWith("[")) {
					JSONArray ja = new JSONArray(fc);
					for (int i = 0; i < ja.length(); i++) {
						JSONObject jo = ja.getJSONObject(i);
						KatalkData kd = new KatalkData();
						kd.setReq(jo.getString("req"));
						kd.setRes(jo.getString("res"));
						kdl.add(kd);
					}
					
				}else {
					JSONObject jo = new JSONObject(fc);
					KatalkData kd = new KatalkData();
					kd.setReq(jo.getString("req"));
					kd.setRes(jo.getString("res"));
					kdl.add(kd);
				}
			}
			
			model.addAttribute("datalist", kdl);
		} catch (Exception e) {
			System.out.println("process ERROR : " + e.getMessage());
		}
		
		return "show";
	}
	
}
