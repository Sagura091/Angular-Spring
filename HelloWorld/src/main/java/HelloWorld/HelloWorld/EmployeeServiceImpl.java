package HelloWorld.HelloWorld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Optional;
@Service
@Qualifier("Service")

public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    EmployeeRepository EmpRepository;
    @Override
    public void createEmployee(Employee _Employee) {
        
        EmpRepository.save(_Employee);
    }

    @Override
    public void deleteById(int id) {
        // TODO Auto-generated method stub
        EmpRepository.deleteById(id);
    }

    @Override
    public void deleteByemployeeId(int id) {
        EmpRepository.deleteById(id);
        
    }

    @Override
    public void updateEmployee(Employee _Employee) {
       
        Employee temp = new Employee();
        temp.setId(_Employee.getId());
        temp.setEmployeeId(_Employee.getEmployeeId());
        temp.setDesignation(_Employee.getDesignation());
        temp.setName(_Employee.getName());
        temp.setSalary(_Employee.getSalary());

        EmpRepository.save(_Employee);
        
    }

    @Override
    public Optional<Employee> findByName(String Name) {
        // TODO Auto-generated method stub
        return EmpRepository.findByName(Name);
    }

    @Override
    public List<Employee> findAll() {
        // TODO Auto-generated method stub
        return EmpRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        // TODO Auto-generated method stub
        return EmpRepository.findById(id);
    }
    
}
