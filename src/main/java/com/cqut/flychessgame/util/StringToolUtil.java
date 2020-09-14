package com.cqut.flychessgame.util;

/**
 * Create with IntelliJ IDEA.
 * 字符串识别工具类
 * @author
 */
public class StringToolUtil {
	
    /**
     * 判断是否有中文文字
     * @return boolean
     */
    private static final boolean isChinese(char c) {  
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);  
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS  
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS  
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A) {  
            return true;  
        }  
        return false;  
    }
    
    /**
     * 判断字符串中是否有中文文字
     * @param text
     * @return boolean
     */
    public static final boolean isChinese(String text) {  
        char[] ch = text.toCharArray();  
        for (int i = 0; i < ch.length; i++) {  
            char c = ch[i];  
            if (isChinese(c)) {  
                return true;  
            }  
        }  
        return false;  
    }
    
    /**
	 * 判断字符串是否是空
	 * @param str
	 * @return boolean
	 */
	public static boolean isEmpty(String str) {
		if(str == null || "".equals(str.trim())) {
			return true;
		} else {
			return false;
		}
	}
}
