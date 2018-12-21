package com.liuchang.backend.file;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Produce a sequence of File objects that match a regular expression in
 * either a local directory ,or by walking a directory tree.
 */
public final class Directory {

    public static File[] local(File dir,final String regex){
        return dir.listFiles(
                //new FilenameFilter
                new FilenameFilter() {
                    private Pattern pattern = Pattern.compile(regex);
                    @Override
                    public boolean accept(File dir, String name) {
                        return pattern.matcher(new File(name).getName()).matches();
                    }
                }
        );
    }

    public static File[] local(String path,String regex){//overloaded
        return local(new File(path),regex);
    }

    /**
     * 静态内部类
     */
    public static class TreeInfo implements Iterable<File>{
        public List<File> files = new ArrayList<File>();
        public List<File> dirs = new ArrayList<File>();

        @Override
        public Iterator<File> iterator(){
            return files.iterator();
        }

        void addAll(TreeInfo other){
            files.addAll(other.files);
            dirs.addAll(other.dirs);
        }

        public static TreeInfo walk(String start,String regex){
            return recurseDirs(new File(start),regex);
        }

        public static TreeInfo walk(File start,String regex){//overloaded
            return recurseDirs(start,regex);
        }

        static TreeInfo recurseDirs(File startDir,String regex){
            TreeInfo result = new TreeInfo();
            for(File item:startDir.listFiles()){
                if(item.isDirectory()){
                    result.dirs.add(item);
                }else{
                    result.files.add(item);
                }
            }
            return result;
        }

    }
}
