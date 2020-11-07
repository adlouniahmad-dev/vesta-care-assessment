package service;

import model.Department;
import model.Employee;
import model.Location;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelFileReader {

    public final static Logger logger = LogManager.getLogger(ExcelFileReader.class);

    public static List<Employee> readEmployeeData(String fileName) throws Exception {
        List<Employee> employees = new ArrayList<>();

        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            Workbook workbook = null;

            if (fileName.toLowerCase().endsWith("xlsx"))
                workbook = new XSSFWorkbook(fileInputStream);
            else if (fileName.toLowerCase().endsWith("xls"))
                workbook = new HSSFWorkbook(fileInputStream);
            else
                throw new Exception("File not supported.");

            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();

            // Escape header values
            if (rowIterator.hasNext())
                rowIterator.next();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                Employee employee = new Employee();
                int employeeId = (int) cellIterator.next().getNumericCellValue();
                employee.setName(cellIterator.next().getStringCellValue());
                employee.setDateOfBirth(cellIterator.next().getDateCellValue());
                employee.setJobTitle(cellIterator.next().getStringCellValue());

                Department department = new Department();
                department.setId((int) cellIterator.next().getNumericCellValue());
                department.setDepartment(cellIterator.next().getStringCellValue());
                employee.setDepartment(department);

                Location location = new Location();
                location.setId((int) cellIterator.next().getNumericCellValue());
                location.setLocation(cellIterator.next().getStringCellValue());
                employee.setLocation(location);

                employee.setSalary((float) cellIterator.next().getNumericCellValue());

                employees.add(employee);

            }
            fileInputStream.close();

        } catch (IOException ioException) {
            logger.error("Error reading file.");
            ioException.printStackTrace();
            throw new Exception("Error reading file.");
        }

        return employees;
    }
}
