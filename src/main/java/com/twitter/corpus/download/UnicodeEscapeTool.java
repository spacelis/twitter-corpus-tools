package com.twitter.corpus.download;

public class UnicodeEscapeTool {
	static StringBuilder sb;

	public static String escape(String str){
		sb = new StringBuilder();
		for(int i=0;i<str.length();i++){
			int ch = str.charAt(i);
			if(ch<128)
				sb.append((char)ch);
			else
				sb.append(String.format("\\u%04x",ch));
		}
		return sb.toString();
	}
	
	public static void main(String[] args){
		String txt = "Englis这是中文h";
		System.out.println(escape(txt));
	}
}
