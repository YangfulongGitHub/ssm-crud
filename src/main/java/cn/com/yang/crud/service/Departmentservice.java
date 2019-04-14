package cn.com.yang.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.yang.crud.bean.Department;
import cn.com.yang.crud.dao.DepartmentMapper;

@Service
public class Departmentservice {

	@Autowired
	private DepartmentMapper departmentMapper;
	//得到全部部门方法
	public List<Department> getAllDeptInfo(){
		return departmentMapper.getAllDeptInfo();
	}
}
