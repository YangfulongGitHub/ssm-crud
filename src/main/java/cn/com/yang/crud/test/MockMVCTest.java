package cn.com.yang.crud.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.github.pagehelper.PageInfo;

import cn.com.yang.crud.bean.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations= {"classpath:appliactionContext.xml","classpath:springMvc.xml"})
public class MockMVCTest {
	@Autowired
	WebApplicationContext context;
	//虚拟mvc请求，获取到处理结果
	MockMvc mockMvc;
	
	@Before
	public void initMokcMvc() {
		mockMvc=MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void testPage() throws Exception {
		//模拟请求拿到返回值
		MvcResult result=mockMvc.perform(MockMvcRequestBuilders.get("/employeeall").param("pn","5")).andReturn();
		//请求成功后，请求域中会有emplist；我们可以取出pageInfo进行验证
		MockHttpServletRequest request = result.getRequest();
		PageInfo pageInfo=(PageInfo) request.getAttribute("emplist");
		System.out.println("当前页码"+pageInfo.getPageNum());
		System.out.println("总页数"+pageInfo.getPages());
		System.out.println("总记录数"+pageInfo.getTotal());
		System.out.println("在页面需要连续显示的页码");
		int[] pagenums=pageInfo.getNavigatepageNums();
		for (int i : pagenums) {
			System.out.println(" "+i);
		}
		List<Employee>list=pageInfo.getList();
		for (Employee employee : list) {
			System.out.println("ID"+employee.getEmpId()+"==>empname:"+employee.getEmpLastname());
		}
	}
}
