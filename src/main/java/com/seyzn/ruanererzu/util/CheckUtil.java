package com.seyzn.ruanererzu.util;

public class CheckUtil {

    /**
     * 检测空字符串
     * @param strs
     * @return
     */
    public static boolean checkStringsEmpty(String ... strs){
        if(strs == null){
            return true;
        }
        for (String item : strs){
            if(item == null || item.trim().isEmpty()){
                return true;
            }
        }
        return false;
    }

    /**
     * 检测String是否在指定范围
     * @param strs
     * @return
     */
    public static boolean checkStringOutRange(int loVal, int hiVal, String ... strs){
        if(strs == null){
            return true;
        }
        for (String str : strs){
            if(str == null){
                return true;
            }
            if(str.length() <  loVal || str.length() > hiVal){
                return true;
            }
        }
        return false;
    }

    /**
     * 检测Integer是否为null
     * @param integers
     * @return
     */
    public static boolean checkIntegerEmpty(Integer ... integers){
        if(integers == null){
            return true;
        }
        for (Integer item : integers){
            if(item == null ){
                return true;
            }
        }
        return false;
    }

    /**
     * 检测Integer是否在指定范围
     * @param integers
     * @return
     */
    public static boolean checkIntegerOutRange(int loVal, int hiVal, Integer ... integers){
        if(integers == null){
            return true;
        }
        for (Integer item : integers){
            if(item == null || item <  loVal || item > hiVal){
                return true;
            }
        }
        return false;
    }

    /**
     * 检测Double是否为null
     * @return
     */
    public static boolean checkDoubleEmpty(Double ... doubles){
        if(doubles == null){
            return true;
        }
        for (Double item : doubles){
            if(item == null ){
                return true;
            }
        }
        return false;
    }

    /**
     * 检测double是否在指定范围
     */
    public static boolean checkDoubleOutRange(double loVal, int hiVal, Double ... doubles){
        if(doubles == null){
            return true;
        }
        for (Double item : doubles){
            if(item == null || item <  loVal || item > hiVal){
                return true;
            }
        }
        return false;
    }
}
