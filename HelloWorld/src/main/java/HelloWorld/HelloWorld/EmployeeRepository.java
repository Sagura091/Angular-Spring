package HelloWorld.HelloWorld;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

//import com.Companies.Companies_and_Users.*;
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Employee findById(int id);
    Optional<Employee> findByName(String name);



} 