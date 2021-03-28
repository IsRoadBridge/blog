package com.zxq;

import com.zxq.dao.BlogMapper;
import com.zxq.pojo.Blog;
import org.assertj.core.util.Maps;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootTest
class BlogApplicationTests {

    @Autowired
    private BlogMapper blogMapper;

    @Test
    void contextLoads() {
        String vlanId = "vlan344";
        String[] vlan = vlanId.split("\\D+");
        int intVlanId = -1;
        if (vlan.length == 2) {
            intVlanId = Integer.parseInt(vlan[1]);
        }
        System.out.println(intVlanId);
        Integer a = 1000;
        int b = 100;
        int c = 1000;
        System.out.println(a.equals(c));
        Boolean cc = false;
        if(cc == false){
            System.out.println("sssssss");
        }
    }

    @Test
    void  stringTest(){
        String a = "DEV_ZJYW_APL1";
        if (a.indexOf('_') != -1){
            System.out.println(a.indexOf('_'));
        }
        String b = "DEV_ZJYW_APL1";
        String c = "DEV_ZJYW_APL";
        System.out.println(b.replaceAll(c,""));

        if(!c.matches("^[0-9].+")){
            System.out.println("DEV_ZJYW_APL1".matches("^[0-9].+"));
        }

    }

    @Test
    void objectTest(){
        Object object = null;
        if(null == object){
            System.out.println("null");
        }
    }

    @Test
    void  nameTest(){
        String name = null;
        String result = null;
        if((null != name) && name.matches("^[0-9].+")){
           result = (name.length() - name.replaceAll("_","").length()) >= 3 ? name.substring(name.indexOf("_") + 1,name.indexOf(("_"),name.indexOf(("_"),name.indexOf("_") + 1) + 1)) : name;
        } else {
            result = name == null ? "" : (name.length() - name.replaceAll("_","").length()) >= 2 ? name.substring(0,name.indexOf(("_"),name.indexOf("_") + 1)) : name;
        }
        System.out.println(result);
    }

    @Test
    void VMTest(){
        String hostName = "sitnpmsapl1";
        String regEx = "[`~!@#$%^&*()\\-+={}':;,\\[\\].<>/?￥%…（）_+|【】‘；：”“’。，、？\\s]";
        Pattern pattern = Pattern.compile(regEx);
        System.out.println(pattern);
        Matcher matcher = pattern.matcher(hostName);
        System.out.println(matcher);
        String name = matcher.replaceAll("-").trim();
        System.out.println(name);
    }

    @Test
    void classTest(){
        String level = "1";
        Map<String,String> levelMap = new HashMap<>();
        levelMap.put("一级","1");
        levelMap.put("二级","2");
        levelMap.put("三级","3");
        levelMap.put("四级","4");
        level = levelMap.get(level) == null ? level.substring(0,1) : levelMap.get(level);
        System.out.println(level);
    }


    @Test
    void StringTest(){
        String name = "vsanDatastore (1)";
        if("vsanDatastore(1)".equals(name.replace(" ",""))){
            System.out.println(name);
        }

    }


    @Test
    void  passwd(){
         String password = DESUtil.decrypt("0ceacc9fafb3a331");
        System.out.println(password);
    }

    @Test
    void  offer1(){
        int number = 11;
        for(int i = 1; i <= 4; i++){
            for( int j = 1; j <= 5-i ; j++){
                System.out.print(" ");
            }
            for( int k = 1; k <= 2*i-1 ; k++){
                System.out.print('*');
            }
            System.out.println();
        }
        for( int i = 1; i <= 3; i++){
            for( int j = 1;j <= i; j++){
                System.out.print(" ");
            }
            for( int k = 1; k <= 2*(4 - i + 1 )-1; k++){
                System.out.print('*');
            }
            System.out.println();
        }
    }





}
