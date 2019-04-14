package cn.com.yang.crud.bean;

public class Employee {
	
    private Integer empId;

    private String empLastname;

    private String gender;

    private String email;

    private Integer depid;
    
    private Department department;

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpLastname() {
        return empLastname;
    }

    public void setEmpLastname(String empLastname) {
        this.empLastname = empLastname == null ? null : empLastname.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getDepid() {
        return depid;
    }

    public void setDepid(Integer depid) {
        this.depid = depid;
    }

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Employee(Integer empId, String empLastname, String gender, String email, Integer depid,
			Department department) {
		super();
		this.empId = empId;
		this.empLastname = empLastname;
		this.gender = gender;
		this.email = email;
		this.depid = depid;
		this.department = department;
	}

	public Employee(Integer empId) {
		super();
		this.empId = empId;
	}

	public Employee(Integer empId, String empLastname, String gender, String email, Integer depid) {
		super();
		this.empId = empId;
		this.empLastname = empLastname;
		this.gender = gender;
		this.email = email;
		this.depid = depid;
	}



	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empLastname=" + empLastname + ", gender=" + gender + ", email=" + email
				+ ", depid=" + depid + ", department=" + department + "]";
	}
	
    
}