package com.liuchang.backend.file;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public class DirFileter implements FilenameFilter {

    private Pattern pattern;

    public DirFileter(String regex) {
        this.pattern = Pattern.compile(regex);
    }

    @Override
    public boolean accept(File dir, String name) {
        System.out.println(name);
//        return pattern.matcher(".xml").matches();
        if(name != "" && name.toLowerCase().endsWith(".xml")){
            return true;
        }else {
            return false;
        }
    }


}
