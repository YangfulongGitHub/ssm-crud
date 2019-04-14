package cn.com.yang.crud.dao;

import java.util.List;

import cn.com.yang.crud.bean.Department;

public interface DepartmentMapper {
	//新增部门
	public void addDepartment(Department department);
	
	//获取所有部门
	public List<Department> getAllDeptInfo();
}