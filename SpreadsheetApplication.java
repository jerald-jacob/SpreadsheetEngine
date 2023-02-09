public class SpreadsheetApplication {
    public static void main(String[] arg){
        SpreadSheet sheet = new SpreadSheet();
        sheet.setCellValue("A1", 13);
        sheet.setCellValue("A2", 14);
        sheet.setCellValue("A3", "=A1+A2");
        sheet.setCellValue("A4", "=A1+A2+A3");
        System.out.println(sheet.getCellValue("A4"));
    }
}
