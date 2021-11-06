package AHNU.learning.data_structure;

/*
    给定一个经过编码的字符串，返回它解码后的字符串。
    编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。

    你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。

    此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/decode-string
*/

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.*;
import java.util.stream.Collectors;

public class Question_0394 {

    public static void main(String[] args) {
        Question_0394 q = new Question_0394();
        System.out.println(q.decodeString("3[a2[c]]"));

        ArrayList<String> list = new ArrayList<>();
    }


    public String decodeString(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                StringAndIndex stringAndIndex = decodeRc(s, i);
                result.append(stringAndIndex.getResult());
                i = stringAndIndex.getIndex();
            } else if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z' || s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }

    public StringAndIndex decodeRc(String s, int index) {
        StringBuilder result = new StringBuilder();
        StringBuilder timeString = new StringBuilder();
        int count = 0;
        for (int i = index; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9' && count == 0) { // 第一次遇见数字
                timeString.append(s.charAt(i));
            } else if (s.charAt(i) >= '0' && s.charAt(i) <= '9' && count > 0) { // 再次遇见则发生了嵌套
                StringAndIndex stringAndIndex = decodeRc(s, i);
                result.append(stringAndIndex.getResult());
                i = stringAndIndex.getIndex();
            } else if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z' || s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                result.append(s.charAt(i));
            } else if (s.charAt(i) == '[') {
                count++;
            } else if (s.charAt(i) == ']') {
                StringBuilder finalResult = new StringBuilder(); // 最终返回的结果
                for (int j = 0; j < Integer.parseInt(timeString.toString()); j++) {
                    finalResult.append(result);
                }
                return new StringAndIndex(finalResult, i);
            }
        }
        return null;
    }
}


class StringAndIndex {
    StringBuilder result;
    Integer index;

    public StringAndIndex() {
    }

    public StringAndIndex(StringBuilder result, Integer index) {
        this.result = result;
        this.index = index;
    }

    public StringBuilder getResult() {
        return result;
    }

    public Integer getIndex() {
        return index;
    }
}
