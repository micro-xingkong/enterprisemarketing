package com.seyzn.ruanererzu.util;

import java.text.SimpleDateFormat;
import java.util.Date;


public class AttFileUtil {
	//文件序号
	private static int count = 0;
	
	/**
	 * 生成文件名
	 */
	public static String createNewFileId() {
		String formatStr = "yyyyMMddHHmmssSSS";
		SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
		
		count ++;
		if(count>=100) {
			count = 1;
		}
		String result = sdf.format(new Date()) + String.format("%02d", count);
		return result;
	}

	/**
	 * 根据后缀名，返回MIME类型
	 * .avi        video/x-msvideo
	 * .dv        video/x-dv
	 * .mp4        video/mp4
	 * .mpeg        video/mpeg
	 * .mpg        video/mpeg
	 * .mov        video/quicktime
	 * .wm        video/x-ms-wmv
	 * .flv        video/x-flv
	 * .mkv        video/x-matroska
	 */
	public static String getMimeType(String fileName) {
		if(CheckUtil.checkStringsEmpty(fileName)) {
			return null;
		}
		
		if(fileName.endsWith(".png")) {
			return "image/png";
		}else if(fileName.endsWith(".jpg") ||
				fileName.endsWith(".jpeg") ||
				fileName.endsWith(".jpe")) {
			return "image/jpeg";
		}else if(fileName.endsWith(".doc")) {
			return "application/msword";
		}else if(fileName.endsWith(".docx")) {
			return "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
		}else if(fileName.endsWith(".xls")) {
			return "application/vnd.ms-excel";
		}else if(fileName.endsWith(".xlsx")) {
			return "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
		}else if(fileName.endsWith(".mp4")){
			return "video/mp4";
		}else if(fileName.endsWith(".mpeg")){
			return "video/mpeg";
		}else if(fileName.endsWith(".mpg")){
			return "video/mpeg";
		}else if(fileName.endsWith(".mov")){
			return "video/quicktime";
		}else if(fileName.endsWith(".dv")){
			return "video/x-dv";
		}else if(fileName.endsWith(".avi")){
			return "video/x-msvideo";
		}else if(fileName.endsWith(".wm")){
			return "video/x-ms-wmv";
		}else if(fileName.endsWith(".flv")){
			return "video/x-flv";
		}else if(fileName.endsWith(".mkv")){
			return "video/x-matroska";
		}
		
		return null;
	}

}
