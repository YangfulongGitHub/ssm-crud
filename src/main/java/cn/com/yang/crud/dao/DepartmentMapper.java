package cn.com.yang.crud.dao;

import java.util.List;

import cn.com.yang.crud.bean.Department;

public interface DepartmentMapper {
	//��������
	public void addDepartment(Department department);
	
	//��ȡ���в���
	public List<Department> getAllDeptInfo();
}