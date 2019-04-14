package cn.com.yang.crud.dao;



import java.util.List;

import cn.com.yang.crud.bean.Employee;

public interface EmployeeMapper {
	/**
	 * ��������Ա��
	 * @param employee
	 */
	public void BatchAddEmployee(Employee employee);
	
	//��ѯ���е�Ա�������ڵĲ���
	public List<Employee> employeeall();
	
	//����Ա����id����Ա������Ϣ
	public void updateEmpById(Employee employee);
	//����Ա����id�����û�����Ϣ
	public Employee getEmpInfoById(Integer empid);
	
	//����Ա����id ɾ��Ա������Ϣ
	
	public void deleteEmpById(Integer empid);
	
	//���Ժ�̨�����û�
	public void addEmployee(Employee employee);
	
	//�����û����Ƿ��ظ�
	public int userNameCheck(String empname);
	
}