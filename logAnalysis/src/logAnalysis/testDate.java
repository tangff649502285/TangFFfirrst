package logAnalysis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class testDate {

	public static void date() {
		String regex = "\\d{4}-\\d{2}-\\d{2}";
		Pattern p = Pattern.compile(regex);
		
		try {
			FileReader fr = new FileReader(new File("D:\\Code\\log.txt"));
			BufferedReader br = new BufferedReader(fr);
			String str;
			
			while(null != (str = br.readLine())) {
				System.out.println(str);
				Matcher matcher = p.matcher(str);
				if(matcher.find()) {
					String t = "D\\Code\\log" + matcher.group(0) + ".txt";
					System.out.println(t);
				}
				
			}
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void testReplace() {
		
		String reg = "\\d{4}\\/\\d{2}\\/\\d{2}";
		Pattern pattern = Pattern.compile(reg);
		
		String str = "2020-06-23 14:23:05 [notice] 92202#0: signal process started";
		Matcher matcher = pattern.matcher(str);
		
		if(matcher.find()) {
			System.out.println(matcher.group(0));
		}
		//String result = "";
		System.out.println(str.replace("/", "-"));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//date();
		
		testReplace();
		
	}

}

