package com.example.demo.util;

import java.io.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.StringUtils;


public class ReadExcelUtils {
    private static DecimalFormat df = new DecimalFormat("0");
    private Workbook wb;
    private Sheet sheet;
    private Row row;
    public ReadExcelUtils(String filepath) {
        if (filepath == null) {
            return;
        }
        String ext = filepath.substring(filepath.lastIndexOf("."));
        try {
            InputStream is = new FileInputStream(filepath);
            if (".xls".equals(ext)) {
                wb = new HSSFWorkbook(is);
            } else if (".xlsx".equals(ext)) {
                wb = new XSSFWorkbook(is);
            } else {
                wb = null;
            }
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException");
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }
    public ReadExcelUtils(InputStream in, String fileName) throws IllegalArgumentException {
        if (in == null || StringUtils.isEmpty(fileName)) {
            throw new IllegalArgumentException();
        }
        String ext = fileName.substring(fileName.lastIndexOf("."));
        try {
            if (".xls".equals(ext)) {
                wb = new HSSFWorkbook(in);
            } else if (".xlsx".equals(ext)) {
                wb = new XSSFWorkbook(in);
            } else {
                wb = null;
            }
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException");
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }
    /**
     * 读取Excel表格表头的内容
     *
     * @return String 表头内容的数组
     * @author zengwendong
     */
    public String[] readExcelTitle() throws Exception {
        if (wb == null) {
            throw new Exception("Workbook对象为空！");
        }
        sheet = wb.getSheetAt(0);
        row = sheet.getRow(0);
        // 标题总列数
        int colNum = row.getPhysicalNumberOfCells();
        String[] title = new String[colNum];
        for (int i = 0; i < colNum; i++) {
            title[i] = row.getCell(i).getStringCellValue();
        }
        return title;
    }
    /**
     * 读取Excel表格表头的内容
     *
     * @return String 表头内容的数组
     * startHeader 表头开始行数
     * @author zengwendong
     */
    public String[] readExcelTitleHeader(Integer startHeader) throws Exception {
        if (wb == null) {
            throw new Exception("Workbook对象为空！");
        }
        sheet = wb.getSheetAt(0);
        row = sheet.getRow(startHeader);
        // 标题总列数
        int colNum = row.getPhysicalNumberOfCells();
        String[] title = new String[colNum];
        for (int i = 0; i < colNum; i++) {
            title[i] = row.getCell(i).getStringCellValue();
        }
        return title;
    }
    /**
     * 读取Excel数据内容
     *
     * @return Map 包含单元格数据内容的Map对象
     * @author zengwendong
     */
    public Map<Integer, Map<Integer, Object>> readExcelContent() throws Exception {
        if (wb == null) {
            throw new Exception("Workbook对象为空！");
        }
        Map<Integer, Map<Integer, Object>> content = new HashMap<Integer, Map<Integer, Object>>();
        sheet = wb.getSheetAt(0);
        // 得到总行数
        int rowNum = sheet.getLastRowNum();
        row = sheet.getRow(0);
        int colNum = row.getPhysicalNumberOfCells();
        // 正文内容应该从第二行开始,第一行为表头的标题
        for (int i = 1; i <= rowNum; i++) {
            row = sheet.getRow(i);
            int j = 0;
            Map<Integer, Object> cellValue = new HashMap<Integer, Object>();
            while (j < colNum) {
                String obj = getCellFormatValue(row.getCell(j));
                cellValue.put(j, obj);
                j++;
            }
            content.put(i, cellValue);
        }
        return content;
    }
    /**
     * 读取Excel数据内容
     *
     * @return Map 包含单元格数据内容的Map对象
     * @author zengwendong
     */
    public List<Map<Integer, Object>> readExcelList() throws Exception {
        if (wb == null) {
            throw new Exception("Workbook对象为空！");
        }
        List<Map<Integer, Object>> content = new ArrayList<>();
        sheet = wb.getSheetAt(0);
        // 得到总行数
        int rowNum = sheet.getLastRowNum();
        row = sheet.getRow(0);
        int colNum = row.getPhysicalNumberOfCells();
        // 正文内容应该从第二行开始,第一行为表头的标题
        for (int i = 1; i <= rowNum; i++) {
            row = sheet.getRow(i);
            int j = 0;
            Map<Integer, Object> cellValue = new HashMap<Integer, Object>();
            while (j < colNum) {
                String obj = getCellFormatValue(row.getCell(j));
                cellValue.put(j, obj);
                j++;
            }
            content.add(cellValue);
        }
        return content;
    }
    /**
     * 读取Excel数据内容
     *
     * @return Map 包含单元格数据内容的Map对象
     * @author zengwendong
     */
    public List<Map<Integer, Object>> readExcelListHeader(Integer header) throws Exception {
        if (wb == null) {
            throw new Exception("Workbook对象为空！");
        }
        List<Map<Integer, Object>> content = new ArrayList<>();
        sheet = wb.getSheetAt(0);
        // 得到总行数
        int rowNum = sheet.getLastRowNum();
        row = sheet.getRow(0);
        int colNum = row.getPhysicalNumberOfCells();
        // 正文内容应该从第二行开始,第一行为表头的标题
        for (int i = header; i <= rowNum; i++) {
            row = sheet.getRow(i);
            int j = 0;
            Map<Integer, Object> cellValue = new HashMap<Integer, Object>();
            while (j < colNum) {
                String obj = getCellFormatValue(row.getCell(j));
                cellValue.put(j, obj);
                j++;
            }
            content.add(cellValue);
        }
        return content;
    }
    /**
     *  工具类 Map<String,Object> 为表头对应的数据 String 表头 Object 对应的数据
     *  [{社区（行政村）名称=330327888121}, {社区（行政村）名称=83303888882121}]
     * @return
     * @throws Exception
     */
    public List<Map<String, Object>> readExcelList1() throws Exception {
        if (wb == null) {
            throw new Exception("Workbook对象为空！");
        }
        List<Map<String, Object>> content = new ArrayList<>();
        sheet = wb.getSheetAt(0);
        // 得到总行数
        int rowNum = sheet.getLastRowNum();
        row = sheet.getRow(0);
        int colNum = row.getPhysicalNumberOfCells();
        // 正文内容应该从第二行开始,第一行为表头的标题
        String[] titles = this.readExcelTitle();
        for (int i = 1; i <= rowNum; i++) {
            row = sheet.getRow(i);
            int j = 0;
            Map<String, Object> cellValue = new HashMap<String, Object>();
            while (j < colNum) {
                String obj = getCellFormatValue(row.getCell(j));
                System.out.println(obj);
                cellValue.put(titles[j], obj);
                j++;
            }
            content.add(cellValue);
        }
        return content;
    }
    public List<String> readExcelColContext(int colNum) throws Exception {
        if (wb == null) {
            throw new Exception("Workbook对象为空！");
        }
        List<String> columnList = new ArrayList<String>();
        sheet = wb.getSheetAt(0);
        // 得到总行数
        int rowNum = sheet.getLastRowNum();
        row = sheet.getRow(0);
        // int colNum = row.getPhysicalNumberOfCells();
        // 正文内容应该从第二行开始,第一行为表头的标题
        for (int i = 1; i <= rowNum; i++) {
            row = sheet.getRow(i);
            Object obj = getCellFormatValue(row.getCell(colNum));
            columnList.add(obj.toString());
        }
        return columnList;
    }
    /**
     * 根据Cell类型设置数据
     *
     * @param cell
     * @return
     * @author zengwendong
     */
    private String getCellFormatValue(Cell cell) {
        String cellvalue = "";
        if (cell != null) {
            // 判断当前Cell的Type
            switch (cell.getCellType()) {
                case Cell.CELL_TYPE_NUMERIC:{// 如果当前Cell的Type为NUMERIC
                    //如果为时间格式的内容
                    if (HSSFDateUtil.isCellDateFormatted(cell)) {
                        //注：format格式 yyyy-MM-dd hh:mm:ss 中小时为12小时制，若要24小时制，则把小h变为H即可，yyyy-MM-dd HH:mm:ss
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                        cellvalue=sdf.format(HSSFDateUtil.getJavaDate(cell.
                                getNumericCellValue())).toString();
                        break;
                    } else {
                        cellvalue = df.format(cell.getNumericCellValue());
                        //   cellvalue = new DecimalFormat("0").format(cell.getNumericCellValue());
                    }
                    break;
                }
                case Cell.CELL_TYPE_STRING:// 如果当前Cell的Type为STRING
                    // 取得当前的Cell字符串
                    cellvalue = cell.getStringCellValue().toString();
                    break;
                default:// 默认的Cell值
                    cellvalue = "";
            }
        } else {
            cellvalue = "";
        }
        return cellvalue;
    }
    /**
     * 添加单元格值
     *
     * @param cellValue1
     * @param cellValue2
     * @param colNum1
     * @param colNum2
     * @throws Exception
     */
    public void addCellValue(String cellValue1, String cellValue2, int colNum1, int colNum2, int rowNum) throws Exception {
        if (wb == null) {
            throw new Exception("Workbook对象为空！");
        }
        sheet = wb.getSheetAt(0);
        row = sheet.getRow(rowNum);
        row.getCell(colNum1).setCellValue(cellValue1);
        row.getCell(colNum2).setCellValue(cellValue2);
    }
    /**
     * 保存工作薄
     *
     * @param excelPath
     */
    public void saveExcel(String excelPath) throws Exception{
        if (wb == null) {
            throw new Exception("Workbook对象为空！");
        }
        FileOutputStream fileOut;
        fileOut = new FileOutputStream(excelPath);
        wb.write(fileOut);
        fileOut.close();
    }
}