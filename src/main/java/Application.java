import model.Department;
import model.Employee;
import model.Location;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.*;

import java.util.List;

public class Application {

    static EmployeeService employeeService = new EmployeeService();
    static DepartmentService departmentService = new DepartmentService();
    static LocationService locationService = new LocationService();

    public final static Logger logger = LogManager.getLogger(Application.class);

    public static void main(String[] args) throws Exception {

        logger.info("Creating Department Seeding...");
        departmentSeeding();
        logger.info("Departments created successfully.");

        logger.info(("Creating Location Seeding"));
        locationSeeding();
        logger.info("Locations created successfully.");

        List<Employee> employees = ExcelFileReader.readEmployeeData("C:\\Users\\Ahmad\\Desktop\\EmployeesList.xlsx");
        for (Employee employee : employees)
            employeeService.save(employee);

        List<Employee> employeeList = employeeService.findAll();
        CsvFileWriter.writeCountryListToFile("Employees.xlsx", employeeList);
    }

    static void departmentSeeding() {
        Department management = new Department();
        management.setDepartment("Management");
        departmentService.save(management);

        Department it = new Department();
        it.setDepartment("IT");
        departmentService.save(it);

        Department hr = new Department();
        hr.setDepartment("HR");
        departmentService.save(hr);

        Department qualityControl = new Department();
        qualityControl.setDepartment("Quality Control");
        departmentService.save(qualityControl);
    }

    static void locationSeeding() {
        Location south = new Location();
        south.setLocation("South");
        locationService.save(south);

        Location north = new Location();
        north.setLocation("North");
        locationService.save(north);

        Location east = new Location();
        east.setLocation("East");
        locationService.save(east);

        Location west = new Location();
        west.setLocation("West");
        locationService.save(west);
    }
}
