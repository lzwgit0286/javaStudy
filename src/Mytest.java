import jdk.nashorn.internal.parser.JSONParser;

import java.util.Calendar;
import java.util.List;

public class Mytest {

    public static  void main(String[] args){
//        byte[] sendInfo = new byte[] {0x01, 0x03, 0x00, 0x00, 0x00, 0x0a, (byte) 0xc5, (byte) 0xcd};
      /*  String fullName = "D:\\MarkingMachineFileUpload\\激光机打标模板文件\\项目管理表单 -金立实施项目.xlsx";
        String fileName = "项目管理表单 -金立实施项目.xlsx";
        String newFileName = "新文件";
        String fileFolder = fullName.substring(0, fullName.indexOf(fileName));
        //获取文件扩展名
        String fileExtension = fileName.substring(fileName.indexOf("."));
        System.out.println(fileFolder);
        System.out.println(fileFolder + newFileName + fileExtension);*/

//        testChangeFolder();
     /*   String capacity = "20.10";
        String i = capacity.substring(0, capacity.indexOf("."));
        System.out.println(i + " **"+ i.length());
        int capacityLength = i.length();
        int j = 0;
        StringBuffer queryPath = new StringBuffer();
        for(j = 65; j < 65 + capacityLength; j++){
            queryPath.append((char)j);
        }*/
//        String s = "5-8π";
//        System.out.println(isIntervals(s));
        /*String s1 = "4.07";
        int capacityLength = s1.substring(0, s1.indexOf(".")).length();
        Integer decimalInt =  Integer.valueOf(s1.substring(s1.indexOf(".") + 1));
        if(capacityLength == 1 && decimalInt != 0){
            System.out.println(decimalInt);
        }*/

//        String sss = "E:\\mytask\\mes\\需求\\激光打标机\\激光打标机文件-整理后\\普通\\普通\\8π\\85℃\\ab^ABC\\8兀棕.LMF";
     /*   String sss = "D:\\MarkingMachineFileUpload\\激光机打标模板文件\\SURGE\\S对策\\10π\\105℃";
        System.out.println(sss.substring(0, sss.lastIndexOf("\\")));

        String temperature = "abc";
        temperature.substring(0, temperature.indexOf("."));*/

//        System.out.println( System.getProperty("os.name"));

  /*      StringBuffer sb = new StringBuffer();
        sb.append("xxxx");
        sb.append("\n");
        sb.append("test");

        System.out.println( sb);*/

        Calendar date = Calendar.getInstance();
        String year = String.valueOf(date.get(Calendar.YEAR)).substring(2,4);
        date.setFirstDayOfWeek(Calendar.MONDAY);
        String week = String.valueOf(date.get(Calendar.WEEK_OF_YEAR));
        System.out.println(week);

        String orderNo = " 310-886666";

        week = "53";
        if(Integer.valueOf(week) % 2 == 0){
            week = String.valueOf(Integer.valueOf(week) - 1);
        }
        System.out.println(week + 88);

        String year2 = String.valueOf(date.get(Calendar.YEAR)).substring(3,4);
        System.out.println(year2);

        int month = date.get(Calendar.MONTH);
        System.out.println(date.get(Calendar.WEEK_OF_MONTH));

        String orderNo2 = "310-abcdefg";
        System.out.println(orderNo2.substring(orderNo2.indexOf("-") + 1));
        System.out.println(orderNo2.substring(1));

    /*    List<String> ss = null;
        String s1 = "afadsfadfdasf12345";
        System.out.println(s1.substring(-3,0));*/

        Calendar currentDate = Calendar.getInstance();
        String year3 = String.valueOf(currentDate.get(Calendar.YEAR)).substring(3,4);
        System.out.println(currentDate.get(Calendar.YEAR));
        System.out.println(year3);
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
