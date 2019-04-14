package cn.com.yang.crud.bean;

public class Department {
    private Integer depId;

    private String depName;

    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName == null ? null : depName.trim();
    }

	public Department(Integer depId, String depName) {
		super();
		this.depId = depId;
		this.depName = depName;
	}

	public Department(String depName) {
		super();
		this.depName = depName;
	}

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Department [depId=" + depId + ", depName=" + depName + "]";
	}
	
}