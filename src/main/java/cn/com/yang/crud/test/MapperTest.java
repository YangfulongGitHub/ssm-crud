package cn.com.yang.crud.test;


import java.util.List;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.com.yang.crud.bean.Department;
import cn.com.yang.crud.bean.Employee;
import cn.com.yang.crud.dao.DepartmentMapper;
import cn.com.yang.crud.dao.EmployeeMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:appliactionContext.xml"})
public class MapperTest {
	
	@Autowired
	private DepartmentMapper departmentMapper;
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
	@Autowired
	SqlSession sqlsession;
	//测试增加部门
	@Test
	public void testaddDep() {
		Department department = new Department("运营部");
		departmentMapper.addDepartment(department);
	}
	
	//测试查询所有员工和员工所在的部门
	@Test
	public void test2() {
			List<Employee> emplist=employeeMapper.employeeall();
			System.out.println(emplist);
	}
	//测试批量插入1000条数据
	@Test
	public void BulkinsertTest() {
		EmployeeMapper emplo=sqlsession.getMapper(EmployeeMapper.class);
		for(int i=0;i<1000;i++) {
			String useruuid=UUID.randomUUID().toString().substring(0, 6);
			//随机生成的性别
			String gender =String.valueOf((int)(Math.random()*2));
			//随机生成的部门
			int depid=1+(int)(Math.random()*2);
			Employee employee = new Employee(null,useruuid,gender,useruuid+"@163.com",depid);
			emplo.BatchAddEmployee(employee);
		}
	}
	//测试员工更新操作
	@Test
	public void EmpUpdateTest() {
		Employee employee = new Employee(4006,"sadf","0","1111@163.com",1);
		employeeMapper.updateEmpById(employee);
	}
	
	//测试根据员工的id删除员工
	@Test
	public void DelEmpByIdTest() {
		employeeMapper.deleteEmpById(4006);
	}
}
