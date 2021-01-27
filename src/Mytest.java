import java.time.LocalDateTime;

public class Mytest {

    public static  void main(String[] args){
//        System.out.println(LocalDateTime.now());
        Integer i1 = new Integer(1);
        Integer i2 = new Integer(1);
        System.out.println(i1.equals(i2));
    }


    /**
     * 判断是否区间的π别, 如5-6π，规则为：
     * 1.含有"-"
     * 2.含有π
     * @param value
     * @return true：值为π别的区间 否则false
     */
    private static boolean isIntervals(String value){
        int separationCharacterIndex = value.indexOf("-");
        if(separationCharacterIndex == -1){
            return false;
        }

        int unitIndex = value.indexOf("π");
        if(unitIndex == -1){
            return false;
        }

        GenerateIntervalsString(value, separationCharacterIndex, unitIndex);
        return true;
    }

    private static void GenerateIntervalsString(String value, int separationCharacterIndex, int unitIndex) {
        Integer startNumber = Integer.valueOf(value.substring(0, separationCharacterIndex));
        Integer endNumber = Integer.valueOf(value.substring(separationCharacterIndex + 1, unitIndex));
        StringBuffer sb = new StringBuffer();
        for(int i = startNumber; i <= endNumber; i++){
            sb.append(i);
            if(i != endNumber) {
                sb.append(",");
            }
        }
        System.out.println(sb);
    }

    private static void testChangeFolder() {
        String fullName = "D:\\MarkingMachineFileUpload\\激光机打标模板文件";
        String fileName = "激光机打标模板文件";
        String newFileName = "激光机打标模板文件XXXX";
        String fileFolder = fullName.substring(0, fullName.indexOf(fileName));
        String fileExtension = "";
        //获取文件扩展名
        if(fileName.indexOf(".") != -1){
            fileExtension = fileName.substring(fileName.indexOf("."));
        }
        System.out.println(fileFolder);
        System.out.println(fileFolder + newFileName + fileExtension);
    }
}
