package cn.com.yang.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.yang.crud.bean.Department;
import cn.com.yang.crud.bean.Massage;
import cn.com.yang.crud.service.Departmentservice;

@Controller
public class DepartmentController {
	
	@Autowired
	private Departmentservice departmentservice;
	
	@ResponseBody
	@RequestMapping("/getAllDeptInfo")
	public Massage getAllDeptInfo() {
		List<Department>deplistDepartments=departmentservice.getAllDeptInfo();
		return Massage.success().add("deplist",deplistDepartments);
	}
}
