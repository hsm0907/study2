package com.study.util;

import java.text.DecimalFormat;

public class FileUtil {
	
	// 300 "300 bytes" 1024 bytes - 1kb , 1024kb - 1Mb  1048576
	public static String fancySize(long size) {
		DecimalFormat df = new DecimalFormat("###,###.0");
		
		if(size < 1024) {
			return size + " Bytes";
			
		}else if(size < (1024 * 1024)){
			return df.format(size/1024) + " kb";
			
		}else {
			return df.format(size/(1024 * 1024)) + " kb";
		}	
		
	}
	
	public static void main(String[] args) {
		System.out.println( FileUtil.fancySize(500));
		System.out.println( FileUtil.fancySize(2090));
		System.out.println( FileUtil.fancySize(1050000));
	}
}
