package utils;

import java.math.BigDecimal;
import java.text.NumberFormat;

/**
 * 数字格式话工具类，主要适配国际本地化格式，使用BigDecimal和NumberFormat做格式化的处理
 */
public class XNumberUtils {

    /**
     * 默认小数的格式化方式，保留最多两位小数点之后的数字
     *
     * @param s 需要格式话的字符串
     * @return 格式化之后的值
     */
    public static String StrFormat(String s) {
        NumberFormat numberInstance = NumberFormat.getNumberInstance();
        numberInstance.setMinimumFractionDigits(0);//小数点后最小的位数
        numberInstance.setMaximumFractionDigits(2);//小数点后最多的位数
        return numberInstance.format(new BigDecimal(s));
    }


    /**
     * @param s           格式化的值
     * @param minFraction 小数位最小位数
     * @param maxFraction 小数位最大位数
     * @param minInteger  整数位最小位数
     * @param maxInteger  整数位最大位数
     * @return 格式化之后的值
     */
    public static String StrFormat(String s, int minFraction, int maxFraction, int minInteger, int maxInteger) {
        NumberFormat numberInstance = NumberFormat.getNumberInstance();
        numberInstance.setMinimumFractionDigits(minFraction);
        numberInstance.setMaximumFractionDigits(maxFraction);
        numberInstance.setMinimumIntegerDigits(minInteger);
        numberInstance.setMaximumIntegerDigits(maxInteger);
        return numberInstance.format(new BigDecimal(s));
    }

    /**
     * 默认处理百分数（保留两位小数然后转换成百分数）
     *
     * @param s 格式化的值
     * @return 格式化之后的值
     */
    public static String PercentFormat(String s) {
        NumberFormat percentInstance = NumberFormat.getPercentInstance();
        percentInstance.setMinimumFractionDigits(0);//zuida
        percentInstance.setMaximumFractionDigits(2);//0.3333这样写就会转换为33%（对应地区样式的33%,比如法国支持的百分数就是%33）,设置3就转换成33.3%
        return percentInstance.format(new BigDecimal(s));
    }

    /**
     * @param s           格式化的值
     * @param minFraction 百分数转换前的小数点后位数最小值
     * @param maxFraction 百分数转换前的小数点后位数最大值
     * @return 格式化之后的值
     */
    public static String PercentFormat(String s, int minFraction, int maxFraction) {
        NumberFormat percentInstance = NumberFormat.getPercentInstance();
        percentInstance.setMinimumFractionDigits(minFraction);//zuida
        percentInstance.setMaximumFractionDigits(maxFraction);//0.3333这样写就会转换为33%（对应地区样式的33%,比如法国支持的百分数就是%33）,设置3就转换成33.3%
        return percentInstance.format(new BigDecimal(s));
    }


    /**
     * 字符串的+
     * @param s1 "1"
     * @param s2 "2"
     * @return "3"
     */
    public static String StrAdd(String s1, String s2) {
        BigDecimal bigDecimal1 = new BigDecimal(s1);
        BigDecimal bigDecimal2 = new BigDecimal(s2);

        return String.valueOf(bigDecimal1.add(bigDecimal2).doubleValue());
    }


    public static Double StrAddtoDouble(String s1, String s2) {
        BigDecimal bigDecimal1 = new BigDecimal(s1);
        BigDecimal bigDecimal2 = new BigDecimal(s2);

        return bigDecimal1.add(bigDecimal2).doubleValue();
    }

    /**
     * 字符串的-
     * @param s1 "3"
     * @param s2 "2"
     * @return "1"
     */
    public static String Strsubtract(String s1, String s2) {
        BigDecimal bigDecimal1 = new BigDecimal(s1);
        BigDecimal bigDecimal2 = new BigDecimal(s2);

        return String.valueOf(bigDecimal1.subtract(bigDecimal2).doubleValue());
    }

    public static Double StrsubtractToDouble(String s1, String s2) {
        BigDecimal bigDecimal1 = new BigDecimal(s1);
        BigDecimal bigDecimal2 = new BigDecimal(s2);

        return bigDecimal1.subtract(bigDecimal2).doubleValue();
    }

    /**
     * 字符串的*
     * @param s1 "1"
     * @param s2 "2"
     * @return "2"
     */
    public static String Strmultiply(String s1, String s2) {
        BigDecimal bigDecimal1 = new BigDecimal(s1);
        BigDecimal bigDecimal2 = new BigDecimal(s2);

        return String.valueOf(bigDecimal1.multiply(bigDecimal2).doubleValue());
    }
    /**
     * 字符串的/
     * @param s1 "1"
     * @param s2 "2" 非零
     * @return "0.5"
     */
    public static String Strdivide(String s1, String s2) {
        BigDecimal bigDecimal1 = new BigDecimal(s1);
        BigDecimal bigDecimal2 = new BigDecimal(s2);
        return String.valueOf(bigDecimal1.divide(bigDecimal2,2, BigDecimal.ROUND_HALF_UP).doubleValue());
    }
}
