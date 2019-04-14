package cn.com.yang.crud.dao;



import java.util.List;

import cn.com.yang.crud.bean.Employee;

public interface EmployeeMapper {
	/**
	 * 批量新增员工
	 * @param employee
	 */
	public void BatchAddEmployee(Employee employee);
	
	//查询所有的员工和所在的部门
	public List<Employee> employeeall();
	
	//根据员工的id更新员工的信息
	public void updateEmpById(Employee employee);
	//根据员工的id查找用户的信息
	public Employee getEmpInfoById(Integer empid);
	
	//根据员工的id 删除员工的信息
	
	public void deleteEmpById(Integer empid);
	
	//测试后台新增用户
	public void addEmployee(Employee employee);
	
	//查找用户名是否重复
	public int userNameCheck(String empname);
	
}