package classes;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		String test = "";
		
		try {
			test = readFile("RaceTMP.csv", StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String lines[] = test.split("\n");
		List<Community> list = new ArrayList<Community>();
		StringBuilder s = new StringBuilder();
		
		for(int i=0; i<lines.length; i++){
			Community c;
			String str;
			
			if(i==0){
				str = lines[i].trim();
				str = str.replaceAll("\t", ",");
				s.append(str + "\n");
			} else {
				str = lines[i].trim();
				String vals[] = str.split("\t");
				vals[0] = vals[0].toLowerCase().replaceAll(" ", "_").replaceAll("\'", ""); 
				vals[1] = vals[1].replaceAll("\"|\'|,", "");
				c = new Community(vals[0], vals[1]);
				list.add(c);
			}
		}
		
		Collections.sort(list);
		
		for(Community c : list){
			s.append(c.getLine());
		}
		
		writeFile("Race.csv", s.toString());
	}
	
	public static String readFile(String path, Charset encoding) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, encoding);
	}
	
	public static void writeFile(String filename, String contents){
		File newcsv = new File(filename);
		
		try {
			if(!newcsv.exists()) {
			    newcsv.createNewFile();
			} else {
				newcsv.delete();
				newcsv.createNewFile();
			}
			Files.write(Paths.get(filename), contents.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
