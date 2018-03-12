package fr.AnimaFightSimulator.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonParser;


public class LoadingContent {
	
	public String readFile() throws IOException {	
		String currentLine=null;
		StringBuilder sb = new StringBuilder();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("C:\\Users\\ROG\\workspace\\AnimaFightSimulator\\AnimaFightSimulator\\src\\main\\webapp\\WEB-INF\\data.json"));
			while ((currentLine = br.readLine()) != null) {
				sb.append(currentLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	
	public List<JSONObject> getJsonFromString() throws IOException {
		String toConvert = this.readFile();
		List<JSONObject> list = new ArrayList<JSONObject>();
		JSONObject jsonObj = new JSONObject(toConvert);
		JSONArray tab = jsonObj.getJSONArray("results");
		for(int i=0; i<tab.length(); i++) {
			list.add((JSONObject) tab.get(i));
		}
		return list;		
	}


}
