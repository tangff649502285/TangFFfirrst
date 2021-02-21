package logAnalysis;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class logAnalysis {
	
	public static void splitLog(String fileName) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "GB2312"));
			String b = "";
			StringBuffer sb = new StringBuffer();
			try {
				
				while ( ((b = br.readLine())!=null) ) {
					
					String[] strArr = b.split(" ");
					
					for(int i = 0; i < strArr.length ; i++) {
						System.out.print( i + ": " + strArr[i] + "; ");
					}
					System.out.println();
					
				}
				
				
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		splitLog("D:\\studying\\团队办公\\紫金山\\官网\\access.txt");

	}

}
