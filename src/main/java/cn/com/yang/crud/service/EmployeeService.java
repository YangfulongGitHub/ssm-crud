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
	
	//����Ա��
	public void addEmployee(Employee employee) {
		employeeMapper.addEmployee(employee);
	}

	public int userNameCheck(String empname) {
		return employeeMapper.userNameCheck(empname);
	}
	//�����û�id�����û�����Ϣ
	public Employee getEmpInfoById(Integer empid) {
		return employeeMapper.getEmpInfoById(empid);
	}
	
	//����Ա����id����Ա������Ϣ
	public void updateEmpById(Employee employee) {
		employeeMapper.updateEmpById(employee);
	}
	//����Ա����idɾ������Ա��
	public void deleteEmpById(Integer empid) {
		employeeMapper.deleteEmpById(empid);
	}
	//����ɾ��
	public void batchDeleteEmpById(List<Integer> empid) {
		employeeMapper.batchDeleteEmpById(empid);
	}
}
