package HelloWorld.HelloWorld;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int id;
    private String employeeeId;
    private String name;
    private String designation;
    private double salary;


    public Employee() {

    }
    public String getName() {
        return name;
    }
    public String getDesignation() {
        return designation;
    }

    public double getSalary()
    {
        return salary;
    }

    public String getEmployeeId()
    {
        return employeeeId;
    }
    public int getId()
    {
        return id;
    }


    public void setName(String _name)
    {
        name = _name; 
    }
    public void setDesignation(String _Designation)
    {
        designation = _Designation;
    }

    public void setEmployeeId(String _employeeid)
    {
        employeeeId = _employeeid;
    }

    public void setSalary(double _salary)
    {
        salary = _salary;
    }
    public void setId(int _id)
    {   
        id = _id;
    }



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((designation == null) ? 0 : designation.hashCode());
		result = prime * result + ((employeeeId == null) ? 0 : employeeeId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(salary);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (designation == null) {
			if (other.designation != null)
				return false;
		} else if (!designation.equals(other.designation))
			return false;
		if (employeeeId == null) {
			if (other.employeeeId != null)
				return false;
		} else if (!employeeeId.equals(other.employeeeId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(salary) != Double.doubleToLongBits(other.salary))
			return false;
		return true;
	}

}
