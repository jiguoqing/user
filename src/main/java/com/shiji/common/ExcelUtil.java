package com.shiji.common;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.util.List;

public class ExcelUtil {

  private ExcelUtil() {
  }

  /**
   * Export Excel.
   *
   * @param sheetName sheet name
   * @param title     title
   * @param values    content
   * @return HSSFWorkbook
   */
  public static HSSFWorkbook getFWorkbook(String sheetName, List<String> title,
      List<List<String>> values) {
    HSSFWorkbook wb = new HSSFWorkbook();

    HSSFSheet sheet = wb.createSheet(sheetName);

    HSSFRow row = sheet.createRow(0);

    HSSFCellStyle style = wb.createCellStyle();
    HSSFCell cell = null;

    for (int i = 0; i < title.size(); i++) {
      cell = row.createCell(i);
      cell.setCellValue(title.get(i));
      cell.setCellStyle(style);
    }

    for (int i = 0; i < values.size(); i++) {
      row = sheet.createRow(i + 1);
      for (int j = 0; j < values.get(i).size(); j++) {
        row.createCell(j).setCellValue(values.get(i).get(j));
      }
    }
    return wb;
  }
}
