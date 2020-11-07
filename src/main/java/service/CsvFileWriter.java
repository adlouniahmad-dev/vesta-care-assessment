package service;

import model.Employee;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

public class CsvFileWriter {

    public static void writeCountryListToFile(String fileName, List<Employee> employees) throws Exception {

        Workbook workbook = null;

        if (fileName.endsWith("xlsx"))
            workbook = new XSSFWorkbook();
        else if (fileName.endsWith("xls"))
            workbook = new HSSFWorkbook();
        else
            throw new Exception("invalid file name, should be xls or xlsx");

        Sheet sheet = workbook.createSheet("Employees");
        Iterator<Employee> iterator = employees.iterator();

        int rowIndex = 0;
        createHeader(sheet.createRow(rowIndex++));

        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            Row row = sheet.createRow(rowIndex++);

            Cell employeeIdCell = row.createCell(0);
            employeeIdCell.setCellValue(employee.getId());

            Cell employeeNameCell = row.createCell(1);
            employeeNameCell.setCellValue(employee.getName());

            Cell dobCell = row.createCell(2);
            dobCell.setCellValue(new SimpleDateFormat("MM/dd/yyyy").format(employee.getDateOfBirth()));

            Cell jobTitleCell = row.createCell(3);
            jobTitleCell.setCellValue(employee.getJobTitle());

            Cell departmentIdCell = row.createCell(4);
            departmentIdCell.setCellValue(employee.getDepartment().getId());

            Cell departmentNameCell = row.createCell(5);
            departmentNameCell.setCellValue(employee.getDepartment().getDepartment());

            Cell locationIdCell = row.createCell(6);
            locationIdCell.setCellValue(employee.getLocation().getId());

            Cell locationNameCell = row.createCell(7);
            locationNameCell.setCellValue(employee.getLocation().getLocation());

            Cell salaryCell = row.createCell(8);
            salaryCell.setCellValue("$" + employee.getSalary());
        }

        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        System.out.println(fileName + " written successfully");
    }

    static void createHeader(Row row) {
        Cell employeeIdCell = row.createCell(0);
        employeeIdCell.setCellValue("Employee Id");

        Cell employeeNameCell = row.createCell(1);
        employeeNameCell.setCellValue("Employee Name");

        Cell dobCell = row.createCell(2);
        dobCell.setCellValue("Date of Birth");

        Cell jobTitleCell = row.createCell(3);
        jobTitleCell.setCellValue("Job Title");

        Cell departmentIdCell = row.createCell(4);
        departmentIdCell.setCellValue("Department Id");

        Cell departmentNameCell = row.createCell(5);
        departmentNameCell.setCellValue("Department");

        Cell locationIdCell = row.createCell(6);
        locationIdCell.setCellValue("Location Id");

        Cell locationNameCell = row.createCell(7);
        locationNameCell.setCellValue("Location");

        Cell salaryCell = row.createCell(8);
        salaryCell.setCellValue("Salary");
    }

}
