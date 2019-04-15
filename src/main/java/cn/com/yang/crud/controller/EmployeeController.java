package cn.com.yang.crud.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.com.yang.crud.bean.Employee;
import cn.com.yang.crud.bean.Massage;
import cn.com.yang.crud.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/employeeall")
	public String employeeall(@RequestParam(value="pn",defaultValue="1")Integer pn,Map<String,Object> map){
		//
		PageHelper.startPage(pn,5);
		//紧跟着的第一个select方法会被分页
		List<Employee> emplist=	employeeService.employeeall();
		//用PageInfo对结果进行包装,包括查询出来的数据，传入连续显示的页数；
		PageInfo<Employee> page = new PageInfo<Employee>(emplist,5);
		map.put("emplist", page);
		return"EmployeeList";
	}
	
	//使用JSON返回分页的数据
	@ResponseBody
	@RequestMapping("/employeejson")
	public Massage employeejson(@RequestParam(value="pn",defaultValue="1")Integer pn) {
		PageHelper.startPage(pn,5);
		//紧跟着的第一个select方法会被分页
		List<Employee> emplist=	employeeService.employeeall();
		//用PageInfo对结果进行包装,包括查询出来的数据，传入连续显示的页数；
		PageInfo<Employee> page = new PageInfo<Employee>(emplist,5);
		return Massage.success().add("pageinfo",page);
	}
	
	//后台新增员工
	@ResponseBody
	@RequestMapping(value="/addEmployee",method=RequestMethod.POST)
	public Massage addEmployee(Employee employee){
		employeeService.addEmployee(employee);
		return Massage.success();
	}
	//查询添加的员工用户名是否可用(不能增加相同的用户名)
	@ResponseBody
	@RequestMapping("/userNameCheck")
	public Massage userNameCheck(String empname){
		Integer integer=employeeService.userNameCheck(empname);
		if(integer>0) {
			return Massage.fail().add("empnamenum", integer);
		}else {
			return Massage.success().add("empnamenum", integer);
		}
	}
	
	//根据员工的id查找员工的信息
	@ResponseBody
	@RequestMapping(value="/getEmpInfoById/{empid}",method=RequestMethod.GET)
	public Massage getEmpInfoById(@PathVariable("empid")Integer empid){
		Employee employee=employeeService.getEmpInfoById(empid);
		return Massage.success().add("empinfo", employee);
	}
	
	//根据员工的id更新员工的信息
	@ResponseBody
	@RequestMapping(value="/updateEmpById/{empId}",method=RequestMethod.PUT)
	public Massage updateEmpById(Employee employee){
		employeeService.updateEmpById(employee);
		return Massage.success();
	}
	
	//删除员工
	@ResponseBody
	@RequestMapping(value="/deleteEmpById/{empid}",method=RequestMethod.DELETE)
	public Massage deleteEmpById(@PathVariable("empid")Integer empid){
		employeeService.deleteEmpById(empid);
		return Massage.success();
	}
	
	//批量删除员工
	@ResponseBody
	@RequestMapping(value="/batchDeleteEmpById/{empId}",method=RequestMethod.DELETE)
	public Massage batchDeleteEmpById(@PathVariable("empId")List<Integer> empId){
		List<Integer> list=new ArrayList<Integer>();
		list.addAll(empId);
		//System.out.println("********"+list+"***********");
		employeeService.batchDeleteEmpById(list);
		return Massage.success();
	} 
}
