package logAnalysis;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class getDate {
	
	public static void judeFileExists(String fileName) {
		
		File file = new File(fileName);
		
		if(!file.exists()) {
			//System.out.println(fileName);
			
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
	}
	
	public static void splitLog() {
		String reg = "\\d{4}-\\d{2}-\\d{2}";
		Pattern pattern = Pattern.compile(reg);
		try {
			FileReader fr = new FileReader("D:\\studying\\团队办公\\紫金山\\官网\\access.log");
			BufferedReader br = new BufferedReader(fr);
			String str;
			
			while(null != (str = br.readLine())) {
				
				Matcher matcher = pattern.matcher(str);
				if(matcher.find()) {
					
					String[] dates = matcher.group(0).split("-");
					
					String newFileName = "D:\\studying\\团队办公\\紫金山\\官网\\accessLog\\access.log_" + dates[0] + "_" + dates[1];
					//System.out.println(newFileName);
					
					//newFileName = newFileName.replace("/", "-");
					judeFileExists(newFileName);
					
					
					FileWriter fw = new FileWriter(new File(newFileName) , true);
					BufferedWriter  bw = new BufferedWriter(fw);
					
					bw.write(str + "\t\n");
					
					bw.close();
					fw.close();
					
				}
				
			}
			fr.close();
			br.close();
			
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void splitVotetLog() {
		
	}

	public static void main(String[] args) {
		
		splitLog();
		
	}

}
