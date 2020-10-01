package io;

import java.io.*;
import java.nio.charset.Charset;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 *  1. 创建文件 ok
 *  2. 创建目录 ok
 *  3. 读文件（非文件里的内容）ok
 *  4. 写文件 见10
 *  5. 读取文件下所有的文件包含目录 ok 见3
 *  6. 存文件
 *  7. copy文件
 *      7.1 copy文件内容 ok
 *      7.2 copy文件本身
 *  8. 删除文件 ok
 *  9. 查找文件
 *  10.把基本数据类型写到文件中 ok
 *  11.Zip文件 ok
 *  12.控制台输入 20200228 见ScannerTest
 */

/**
 * 问题： 中文字符的处理  https://segmentfault.com/q/1010000019283825?utm_source=tag-newest
 * system.in的使用
 */
public class FileTest {
    public static  void main(String[] args) throws Exception{
     /*   createFolder();
        createFile();*/

    /*    File file = new File("D:\\test\\filetest\\20190828");
        readFile(file);*/
//        getInputMessage();
        copyFile();
//        writeFile`ByData();
//        writeZip();
    }

    /**
     * 创建压缩文件时，如果带目录，则会把这整个路径上的文件夹一起打包
     * @throws Exception
     */
    static void writeZip() throws Exception{
        FileOutputStream fos = new FileOutputStream("D:\\test\\filetest\\20190828_2\\testZip222.zip");
        ZipOutputStream zop = new ZipOutputStream(fos);
        ZipEntry zipEntry = new ZipEntry("test3444.txt");
        zop.putNextEntry(zipEntry);
        zop.close();
        fos.close();

        //解压文件 --- 解压出来的文件是空的，需要手动把zip文件中的内容写到解压后的空白文件中
        FileInputStream fis = new FileInputStream("D:\\test\\filetest\\20190828\\testZip.zip");
        ZipInputStream zip = new ZipInputStream(fis);
        ZipEntry zipEntry1 = zip.getNextEntry();
        System.out.println(zipEntry1.getName());
        FileOutputStream fis2 = new FileOutputStream("D:\\" + zipEntry1.getName());
        int i = 0;
        byte[] bytes = new byte[1024];
        while ((i = zip.read(bytes)) != -1){
            fis2.write(bytes);
        }
        fis2.close();
        zip.close();
        fis.close();
    }

    /**
     *  PrintWriter的应用场景
     * @throws Exception
     */
    static void writeFileByData() throws Exception{
        double b = 3.141592614334134;
  /*      //不加true会直接覆盖原来的文件
        PrintWriter pw = new PrintWriter(new FileWriter("D:\\test\\filetest\\20190828_2\\source.txt",true));
        pw.write("龙珠武");
        //必须close或flush，否则写的内容不会刷新到文件中
        pw.flush();
        pw.close();*/

      /*  DataOutputStream dos = new DataOutputStream(new FileOutputStream("D:\\test\\filetest\\20190828_2\\source.txt"));
        dos.writeChar('a');
        dos.writeChars("中国");
//        dos.writeChars(String.valueOf(b));
//        dos.writeChars("111111");
        dos.close();*/

     /*   FileInputStream fis = new FileInputStream(("D:\\test\\filetest\\20190828_2\\source.txt"));
        int bb = 0;
        while( (bb = fis.read()) != -1 ){
            System.out.println(bb);
        }*/

        /*DataInputStream dis = new DataInputStream(new FileInputStream(("D:\\test\\filetest\\20190828_2\\source.txt")));
        System.out.println(dis.readDouble());*/
    /*    byte[] b = ;
        dis.read(b);*/
    }

    /**
     *  复制文件不存在时，
     *  方式1： copy 文件 把一个文件copy到另外一个地方 (输入输出流的方式)
     *  方式2： 把一个文件的内容copy到另外一个文件中 -- 待处理
     */
    static void copyFile() throws Exception{
//       copy文件文件
        FileInputStream fis = new FileInputStream("D:\\test\\filetest\\20190828_2\\source.txt");
        FileOutputStream fos = new FileOutputStream("D:\\test\\filetest\\20190828_2\\copy\\target222.txt");
        int i = 0;
        while((i = fis.read()) != -1){
            fos.write(i);
        }
        fos.close();
        fis.close();
//        copyImageByStream();
//        copyImageByReaderWriter();
    }

    /**
     * 会导致复制格式不正确，不能正确显示图片
     */
    private static void copyImageByReaderWriter() throws IOException {
        // copy 图片文件
        FileReader fis = new FileReader("D:\\test\\filetest\\20190828_2\\2.png");
        FileWriter fos = new FileWriter("D:\\test\\filetest\\20190828_2\\copy\\5.png");
        int i = 0;
        while((i = fis.read()) != -1){
            fos.write(i);
        }

        fos.close();
        fis.close();
    }
    private static void copyImageByStream() throws IOException {
        // copy 图片文件
        FileInputStream fis = new FileInputStream("D:\\test\\filetest\\20190828_2\\2.png");
        FileOutputStream fos = new FileOutputStream("D:\\test\\filetest\\20190828_2\\copy\\1.png");
        int i = 0;
        while((i = fis.read()) != -1){
            fos.write(i);
        }

        fos.close();
        fis.close();
    }

    static String getInputMessage() throws IOException{
        String defaultCharsetName= Charset.defaultCharset().displayName();
        System.out.println(defaultCharsetName);
        System.out.println("请输入您的命令∶");
        byte buffer[]=new byte[1024];
        int count= System.in.read(buffer);
        System.out.print(new String(buffer) + "**");
        char[] ch=new char[count-2];//最后两位为结束符，删去不要
        System.out.println(count);
        for(int i=0;i<count-2;i++)
            ch[i]=(char)buffer[i];
        String str=new String(ch);
        return str;
    }

    private static void readFile(File file){
        if(file.isDirectory()){
            System.out.println("目录名： " + file.getName());
            File[] files = file.listFiles();
            for(File f : files){
                readFile(f);
            }
        }else {
            System.out.println(file.getName());
        }
    }

    private static void createFile() throws IOException {
        File file = new File("D:\\test\\filetest\\20190828/test.txt");
        file.createNewFile();
    }

    private static void deleteFile() throws IOException {
        File file = new File("D:\\test\\filetest\\20190828/test.txt");
        file.delete();
    }

    private static void createFolder() {
        File folder = new File("D:\\test\\filetest\\20190828");
        System.out.println(folder.mkdir());
    }
}
