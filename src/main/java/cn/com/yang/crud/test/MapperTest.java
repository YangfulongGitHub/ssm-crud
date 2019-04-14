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
	//�������Ӳ���
	@Test
	public void testaddDep() {
		Department department = new Department("��Ӫ��");
		departmentMapper.addDepartment(department);
	}
	
	//���Բ�ѯ����Ա����Ա�����ڵĲ���
	@Test
	public void test2() {
			List<Employee> emplist=employeeMapper.employeeall();
			System.out.println(emplist);
	}
	//������������1000������
	@Test
	public void BulkinsertTest() {
		EmployeeMapper emplo=sqlsession.getMapper(EmployeeMapper.class);
		for(int i=0;i<1000;i++) {
			String useruuid=UUID.randomUUID().toString().substring(0, 6);
			//������ɵ��Ա�
			String gender =String.valueOf((int)(Math.random()*2));
			//������ɵĲ���
			int depid=1+(int)(Math.random()*2);
			Employee employee = new Employee(null,useruuid,gender,useruuid+"@163.com",depid);
			emplo.BatchAddEmployee(employee);
		}
	}
	//����Ա�����²���
	@Test
	public void EmpUpdateTest() {
		Employee employee = new Employee(4006,"sadf","0","1111@163.com",1);
		employeeMapper.updateEmpById(employee);
	}
	
	//���Ը���Ա����idɾ��Ա��
	@Test
	public void DelEmpByIdTest() {
		employeeMapper.deleteEmpById(4006);
	}
}
