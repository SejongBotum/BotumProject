package org.sejonghacker.botum.voiceTracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class VoiceFileRecoder {
	private String path;
	private String fileNo;
	private String owner;
	private String contextPath;
	private String regfix;
	
	public VoiceFileRecoder(String contextPath, String fileNo, String owner) {
		super();
		this.regfix = "\\";
//		this.regfix = "/";
		this.contextPath = contextPath;
		this.fileNo = fileNo;
		this.owner = owner;
		this.path = contextPath + regfix + owner;
	}
	
	public String recode(String sentence) {
		FileWriter fw = null;
		BufferedWriter bw = null;
		

		char[] cbuf = new String().toCharArray() ;
		try {
			File file = new File(path);
			if(file.exists()) {
				file = new File(path + regfix + fileNo);
				if(!file.exists()) {
					file.createNewFile();
				}
			}else {
				file.mkdirs();
				file = new File(path + regfix + fileNo);
				file.createNewFile();
			}
			
			fw = new FileWriter(file, true);
			bw = new BufferedWriter(fw);
			
			bw.write(sentence);
			bw.flush();
						
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		
		return cbuf.toString();
	}
	
	public String read(String name, String number) {
		FileReader fr = null;
		BufferedReader br = null;
		File file = new File(path + regfix + number);
		String data = "";
		String allString = "";
		
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			while((data = br.readLine()) != null) {
				allString += data;
			}
		} catch (IOException e) {
		}

		return allString;
	}
	
	@Override
	public String toString() {
		return "VoiceFileRecoder [path=" + path + ", fileNo=" + fileNo + ", owner=" + owner + ", contextPath="
				+ contextPath + "]";
	}
}
