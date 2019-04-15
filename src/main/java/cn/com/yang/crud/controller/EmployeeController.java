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
		//�����ŵĵ�һ��select�����ᱻ��ҳ
		List<Employee> emplist=	employeeService.employeeall();
		//��PageInfo�Խ�����а�װ,������ѯ���������ݣ�����������ʾ��ҳ����
		PageInfo<Employee> page = new PageInfo<Employee>(emplist,5);
		map.put("emplist", page);
		return"EmployeeList";
	}
	
	//ʹ��JSON���ط�ҳ������
	@ResponseBody
	@RequestMapping("/employeejson")
	public Massage employeejson(@RequestParam(value="pn",defaultValue="1")Integer pn) {
		PageHelper.startPage(pn,5);
		//�����ŵĵ�һ��select�����ᱻ��ҳ
		List<Employee> emplist=	employeeService.employeeall();
		//��PageInfo�Խ�����а�װ,������ѯ���������ݣ�����������ʾ��ҳ����
		PageInfo<Employee> page = new PageInfo<Employee>(emplist,5);
		return Massage.success().add("pageinfo",page);
	}
	
	//��̨����Ա��
	@ResponseBody
	@RequestMapping(value="/addEmployee",method=RequestMethod.POST)
	public Massage addEmployee(Employee employee){
		employeeService.addEmployee(employee);
		return Massage.success();
	}
	//��ѯ��ӵ�Ա���û����Ƿ����(����������ͬ���û���)
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
	
	//����Ա����id����Ա������Ϣ
	@ResponseBody
	@RequestMapping(value="/getEmpInfoById/{empid}",method=RequestMethod.GET)
	public Massage getEmpInfoById(@PathVariable("empid")Integer empid){
		Employee employee=employeeService.getEmpInfoById(empid);
		return Massage.success().add("empinfo", employee);
	}
	
	//����Ա����id����Ա������Ϣ
	@ResponseBody
	@RequestMapping(value="/updateEmpById/{empId}",method=RequestMethod.PUT)
	public Massage updateEmpById(Employee employee){
		employeeService.updateEmpById(employee);
		return Massage.success();
	}
	
	//ɾ��Ա��
	@ResponseBody
	@RequestMapping(value="/deleteEmpById/{empid}",method=RequestMethod.DELETE)
	public Massage deleteEmpById(@PathVariable("empid")Integer empid){
		employeeService.deleteEmpById(empid);
		return Massage.success();
	}
	
	//����ɾ��Ա��
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
