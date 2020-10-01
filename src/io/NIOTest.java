package io;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 *  采用新的IO类，Path, Paths, Files来处理文件
 *  1. 创建文件 ok
 *  2. 创建目录 ok
 *  3. 读文件
 *  4. 写文件
 *  5. 读取文件下所有的文件包含目录 ok
 *  6. 存文件
 *  7. copy文件 ok
 *  8. 删除文件，目录 ok，
 *  8.1 删除包含子文件的文件夹，子文件一并删除
 *  9. 查找文件
 *  10.文件,文件夹重命名
 */
public class NIOTest {
    public static  void main(String[] args) throws Exception{
//        createFolder();
//        createFile();

   /*     Path path = Paths.get("D:\\test\\filetest\\20190828_2");
        System.out.println(path.toFile().getAbsolutePath());*/
//        File file1 = path.toFile();
//        readFileByOldFile(file1);
      /*  readFile(path);
        Byte b = -128;*/
        copy();
//        delete();
    }

    private static void copy()throws Exception{
        //copy文件
        Path source = Paths.get("D:\\test\\filetest\\20190828_2\\test.txt");
        Path target = Paths.get("D:\\test\\filetest\\20190828_2\\copy\\test4.txt");
        Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);

        //copy目录（不会copy子目录和子文件） -- 未完成copy目录及下的子目录
        Path source1 = Paths.get("D:\\test\\filetest\\20190828_2\\folder1");
        Path target1 = Paths.get("D:\\test\\filetest\\20190828_2\\copy\\folder3");
        Files.copy(source1, target1,StandardCopyOption.REPLACE_EXISTING );
    }

    private static void delete()throws Exception{
        //删除文件
      /*  Path file = Paths.get("D:\\test\\filetest\\20190828_2\\copy\\test4.txt");
        Files.delete(file);*/

        // delete folder, 如果文件夹下有文件，会抛ava.nio.file.DirectoryNotEmptyException
        Path folder = Paths.get("D:\\test\\filetest\\20190828_2\\copy\\folder1");
        Files.deleteIfExists(folder);
        //删除包含子文件的目录 todo
    }

    private static void readFile(Path path) throws Exception{
        Files.walkFileTree(path, new SimpleFileVisitor<Path>(){
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                System.out.println("目录：" + dir.getFileName());
                return super.preVisitDirectory(dir, attrs);
            }

            @Override
            public FileVisitResult visitFile(Path dir, BasicFileAttributes attrs) throws IOException {
                System.out.println(dir.getFileName());
                return super.visitFile(dir, attrs);
            }
        });
    }

    private static void readFileByOldFile(File file){
        if(file.isDirectory()){
            System.out.println("目录名 *** ： " + file.getName());
            File[] files = file.listFiles();
            for(File f : files){
                readFileByOldFile(f);
            }
        }else {
            System.out.println(file.getName());
        }

    }

    private static void createFile() throws IOException {
        Path filePath = Paths.get("D:\\test\\filetest\\20190828_2/test.txt");
        if(Files.exists(filePath)){
            Files.delete(filePath);
        }
        Files.createFile(filePath);
    }

    private static void createFolder() throws Exception{
        Path folder = Paths.get("D:\\test\\filetest\\20190828_2");
        System.out.println(Files.createDirectory(folder));
    }
}
