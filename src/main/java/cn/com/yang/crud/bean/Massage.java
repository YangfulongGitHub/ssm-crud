package cn.com.yang.crud.bean;

import java.util.HashMap;
import java.util.Map;

public class Massage {
	//״̬��100 �ɹ� 200ʧ��
	private int code;
	//��ʾ��Ϣ
	private String massage;
	
	//�û�Ҫ���ظ������������
	private Map<String, Object> extend=new HashMap<String, Object>();

	public static Massage success() {
		Massage massage = new Massage();
		massage.setCode(100);
		massage.setMassage("����ɹ�");
		return massage;
	}
	public static Massage fail() {
		Massage massage = new Massage();
		massage.setCode(200);
		massage.setMassage("����ʧ��");
		return massage;
	}
	
	public Massage add(String key,Object value) {
		this.getExtend().put(key, value);
		return this;
	}
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMassage() {
		return massage;
	}

	public void setMassage(String massage) {
		this.massage = massage;
	}

	public Map<String, Object> getExtend() {
		return extend;
	}

	public void setExtend(Map<String, Object> extend) {
		this.extend = extend;
	}
	
	
}
