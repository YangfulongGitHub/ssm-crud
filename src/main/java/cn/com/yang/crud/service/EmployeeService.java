package cn.com.yang.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.yang.crud.bean.Employee;
import cn.com.yang.crud.dao.EmployeeMapper;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeMapper employeeMapper;
	
	public List<Employee> employeeall(){
		return employeeMapper.employeeall();
	}
	
	//新增员工
	public void addEmployee(Employee employee) {
		employeeMapper.addEmployee(employee);
	}

	public int userNameCheck(String empname) {
		return employeeMapper.userNameCheck(empname);
	}
	//根据用户id查找用户的信息
	public Employee getEmpInfoById(Integer empid) {
		return employeeMapper.getEmpInfoById(empid);
	}
	
	//根据员工的id更新员工的信息
	public void updateEmpById(Employee employee) {
		employeeMapper.updateEmpById(employee);
	}
	//根据员工的id删除这条员工
	public void deleteEmpById(Integer empid) {
		employeeMapper.deleteEmpById(empid);
	}
	//批量删除
	public void batchDeleteEmpById(List<Integer> empid) {
		employeeMapper.batchDeleteEmpById(empid);
	}
}
