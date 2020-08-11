package com.xiaodai.visual.map.util;

import java.io.*;

/**
 * 数据处理工具类
 *
 * @author qiaofengjun
 */
public class DataInitUtil {

    /**
     * 源文件
     */
    private static String filePath = "D:\\taxi_GPS.csv";

    /**
     * 目标SQL文件
     */
    private static String SQLFile = "D:\\mysql.sql";


    /**
     * 将csv文件里面的数据，用代码生成SQL
     * <p>
     * ============================
     * 文件格式如下
     * LICENSEPLATENO,IN_DATE,GPS_TIME,LONGITUDE,LATITUDE,HEIGHT,SPEED,DIRECTION,EFF,CAR_STAT1
     * ÉÂAU6694,2014/3/24 0:00,2014/3/24 0:00,108.929799,34.259464,655,55,268,1,5
     * ÉÂAT0390,2014/3/24 0:00,2014/3/24 0:00,108.983602,34.209152,655,57,88,1,5
     * <p>
     * ……
     * <p>
     * ============================
     * SQL 格式如下
     * <p>
     * INSERT INTO gps_demo.car_gps_data
     * (LICENSE_PLATE_NO, GPS_TIME_START, GPS_TIME_END, LONGITUDE, LATITUDE, HEIGHT, SPEED, DIRECTION, CAR_STATUS, DATA_STATUS)
     * VALUES
     * ('ÉÂAU6694', '2019-11-07 08:16:47', '2019-11-07 08:16:55', '108.929799', '34.259464', '655', 55, 268, 1, 5);
     */
    public static void initSqlData() throws IOException {
        // 1、先把你的数据放在txt里面

        // 2、c语言循环读取文件内容一行，按照数据列的分隔符(自己指定)，读取每一列
        File file = new File(filePath);
        InputStream inputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(inputStreamReader);

        // sql 模板
        String sqlTemplate = "INSERT INTO gps_demo.car_gps_data \n" +
                "  (LICENSE_PLATE_NO, GPS_TIME_START, GPS_TIME_END, LONGITUDE, LATITUDE, HEIGHT, SPEED, DIRECTION, CAR_STATUS, DATA_STATUS)\n" +
                "VALUES\n" +
                " ('%s', '%s', '%s', '%s', '%s', '%s', %s, %s, %s, %s);";


        // 目标SQL文件,创建输出流
        FileOutputStream outputStream = new FileOutputStream(SQLFile, false);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "utf-8");
        BufferedWriter writer = new BufferedWriter(outputStreamWriter);

        String line = null;
        int num = 1;
        while ((line = reader.readLine()) != null) {
            // 特殊字符替换
            line = "S" + line.substring(2);

            String[] dataItem = line.split(",");
            // 3、拼接一条完整的SQL(将SQL模板中的换行符号去掉)
            String sql = String.format(sqlTemplate, dataItem).replaceAll("\n", "");
            // 输出到控制台看下
            System.out.println(sql);

            // 4、输出到文件，注意使用追加的方式
            writer.write(sql);
            writer.newLine();
            num++;
        }
        writer.flush();

    }
}
