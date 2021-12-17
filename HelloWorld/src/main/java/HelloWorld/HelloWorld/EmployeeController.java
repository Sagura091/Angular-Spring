package HelloWorld.HelloWorld;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.node.DoubleNode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService EmpRepository; 
    //EmployeeRepository EmpRepository;



    @PostMapping(path= "/add")
public @ResponseBody String addNewEmployee (@RequestBody Employee Em) 
{
        EmpRepository.createEmployee(Em);
        return "Saved: " + Integer.toString(Em.getId()) + " " + Em.getDesignation() +  "   " + Em.getEmployeeId() + "    " + Em.getName() + "  " +  Double.toString(Em.getSalary());
        
        
        
      }
      
    @RequestMapping(produces = "application/json")
    public List<Employee> getAllEmployees() {

        return EmpRepository.findAll();

    }

    @DeleteMapping(path={"/delete/{id}"})
    public Employee deleteEmployee(@PathVariable("id") int id)
    {
        Employee temp = EmpRepository.findById(id);
        EmpRepository.deleteById(id);

        return temp;
    }

    @PutMapping(path="/update")
    public  @ResponseBody String updateEmployee(@RequestBody Employee Em)
    {
        EmpRepository.updateEmployee(Em);
        return "updated";
    }






}