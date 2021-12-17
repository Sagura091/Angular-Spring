package HelloWorld.HelloWorld;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

public abstract void createEmployee(Employee _Employee);
public abstract void deleteById(int id);
public abstract void deleteByemployeeId(int id);
public abstract void updateEmployee(Employee company);


public abstract Optional<Employee> findByName(String Name);
public abstract List<Employee> findAll();
public abstract Employee findById(int id);

    
}
