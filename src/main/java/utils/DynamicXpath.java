package utils;

public class DynamicXpath {

    public static String constructXpath(String xpath,String dynamicData){
        return String.format(xpath,dynamicData);
    }
}
