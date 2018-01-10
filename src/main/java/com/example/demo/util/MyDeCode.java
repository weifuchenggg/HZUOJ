package com.example.demo.util;

import com.example.demo.entity.Dictionary;
import com.example.demo.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class MyDeCode {

    public static Map<String,String> dictionary;

    @Autowired
    DictionaryService dictionaryService;

    private static MyDeCode myDeCode;

    @PostConstruct
    public void init() {
        myDeCode= this;
        dictionary=new HashMap<String, String>();
        List<Dictionary> lists1=myDeCode.dictionaryService.selectAll();
        for (Dictionary list :lists1){
            long hash=(list.getKind().hashCode()*1000+list.getCode().hashCode());
            Long k=hash;
            dictionary.put(k.toString(),list.getDetail());
        }
    }

    public static void deCode(List<Map<String,Object>> lists,String zd,String kind){
        System.out.println(myDeCode);
        for (Map<String,Object> map:lists){
            long hash=(kind.hashCode()*1000+map.get(zd).hashCode());
            Long k=hash;
            map.put(zd,dictionary.get(k.toString()));
        }
    }

}
