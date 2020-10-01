import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 *  5. 读取文件下所有的文件包含目录 ok
 */
public class MarkingMachineTest {
    public static  void main(String[] args) throws Exception{
        Path path = Paths.get("E:\\mytask\\mes\\需求\\激光打标机\\激光打标机文件-整理后");
//        System.out.println(path.toFile().getAbsolutePath());
        File file1 = path.toFile();
        readFileByOldFile(file1);
    }

    private static void readFileByOldFile(File file){
//        System.out.println(file.getAbsolutePath().indexOf("E:\\mytask\\mes\\需求\\激光打标机\\激光打标机文件-整理后"));
        if(file.isDirectory()){
//            System.out.println(file.getName());
            System.out.println("update sys_file set fileName = '"
                    + file.getName() + "', "
                    + "fileType = 'FOLDER' "
                    + "where fileFullPath = '" + file.getAbsolutePath() + "';" );
//            System.out.println(file.getAbsolutePath());
            File[] files = file.listFiles();
            for(File f : files){
                readFileByOldFile(f);
            }
        }else {
//            System.out.println(file.getName());
//            System.out.println(file.getAbsolutePath());
            System.out.println("update sys_file set fileName = '"
                    + file.getName() + "', "
                    + "fileType = 'FILE' "
                    + "where fileFullPath = '" + file.getAbsolutePath() + "';" );
        }

    }


}
