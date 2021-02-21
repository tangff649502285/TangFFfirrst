package logAnalysis;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class count {
	
	public static void splitLog() {
		//String reg = "\\d{4}-\\d{2}-\\d{2}";
		String reg = "\\d{4}-\\d{2}-\\d{2}";
		Pattern pattern = Pattern.compile(reg);
		try {
			FileReader fr = new FileReader("C:\\Users\\TangFF\\Documents\\NetSarang Computer\\6\\Xshell\\Sessions\\error_local.txt");
			BufferedReader br = new BufferedReader(fr);
			String str;
			
			String date = "";
			int count = 0;
			
			while(null != (str = br.readLine())) {
				
				Matcher matcher = pattern.matcher(str);
				if(matcher.find()) {
					String newFileName = matcher.group(0);
					newFileName = newFileName.replace("/", "-");
					
					if(date.length() == 0) {
						date = newFileName;
						count = 1;
					}else {
						if(date.equals(newFileName) ) {
							count++;
						}else {
							System.out.println(date + ":" + count);
							date = newFileName;
							count = 1;
						}
						
					}
					
				}
				
			}
			fr.close();
			br.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public static void splitLog2() {
		//String reg = "\\d{2}/\\S+/\\d{4}";
		String reg = "\\d{4}-\\d{2}-\\d{2}";
		Pattern pattern = Pattern.compile(reg);
		try {
			FileReader fr = new FileReader("C:\\Users\\TangFF\\Documents\\NetSarang Computer\\6\\Xshell\\Sessions\\access.log");
			BufferedReader br = new BufferedReader(fr);
			String str;
			
			String date = "";
			int count = 0;
			
			while(null != (str = br.readLine())) {
				
				Matcher matcher = pattern.matcher(str);
				if(matcher.find()) {
					String newFileName = matcher.group(0);
					newFileName = newFileName.replace("/", "-");
					
					if(date.length() == 0) {
						date = newFileName;
						count = 1;
					}else {
						if(date.equals(newFileName) ) {
							count++;
						}else {
							System.out.println(date + ":" + count);
							date = newFileName;
							count = 1;
						}
						
					}
					
				}
				
			}
			if(count >= 1) {
				System.out.println(date + ":" + count);
			}
			fr.close();
			br.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
		splitLog2();
	}

}
