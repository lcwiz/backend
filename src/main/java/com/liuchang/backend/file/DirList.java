package com.liuchang.backend.file;


import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * 指定目录，显示目录与文件明细
 */
public class DirList {
    /** 第二次迭代 begin**/
    public static FilenameFilter filter(final String regex){
        //creation of anonymous inner class:
        return new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);//匿名内部类
            @Override
            public boolean accept(File dir, String name) {
                if(name != "" && name.toLowerCase().endsWith(".xml")){
                    return true;
                }else {
                    return false;
                }
            }
        };
    }
    /** 第二次迭代 end **/

    public static void main(String[] args){
        File path = new File(".");
        String[] list;
        if(args.length == 0){
            list = path.list();
        }else{
            list = path.list(filter(args[0]));//list方法为目录对象下的每个文件名调用accept()
        }
        Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);//大小写敏感，且相同单词大写在前
        for(String dirItem:list){
            System.out.println(dirItem);
        }
    }
}
