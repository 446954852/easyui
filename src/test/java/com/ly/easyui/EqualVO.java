package com.ly.easyui;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 创建时间：2016年2月26日 下午9:42:00  
 * 项目名称：easyui1.3.4  
 * @author liyong 
 * 文件名称：equalVO.java  
 * 类说明：  测试equals方法
 * 
 * 		equals方法和hashCode方法都可以重写,所以他们并没有关系(比如equals为true,hashCode一定相等)
 * 		HashSet添加值时则按照下面原则
 * 
 * 		1.先看HashCode
 * 			a.不一致则直接添加进去
 * 			b.一致则还需要判断equals是否为true,为false时才添加进去 为true不添加表示对象已经存在
 */

@SuppressWarnings("unused")
public class EqualVO {
	
	public static int i = 0;
	
	private String name;
	
	EqualVO() {
	}
	
	EqualVO(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return i;
	}

	@Override
	public boolean equals(Object obj) {
		return true;
	}
	
	public static void main(String[] args) {
		List<String> list = new LinkedList<String>();
		list.add("cc");
		list.remove(0);
		int size = list.size();
		System.out.println(size + "---------------");
		char ch = 'a';
		char c = '中';
		String st = "A";
		String st2 = "我";
		System.out.println(st.getBytes().length);
		System.out.println(st2.getBytes().length);
		final StringBuffer x = new StringBuffer("dd");
		final StringBuffer y = new StringBuffer("cc");
		String str = "";
		assert str == "cc";
		System.out.println(y);
		System.out.println(new EqualVO().get());
		
		EqualVO e1 = new EqualVO("e1");
		EqualVO e2 = new EqualVO("e2");
		System.out.println(e1.equals(e2));
		System.out.println(e1.hashCode() == e2.hashCode());
		HashSet<EqualVO> set = new HashSet<EqualVO>();
		set.add(e1);
		System.out.println(set.size());
		set.add(e2);
		System.out.println(set.size());
		Map<EqualVO, String> map = new HashMap<EqualVO, String>();
		map.put(e1, "cc1");
		map.put(e2, "cc2");
		System.out.println(map);
	}
	
	@SuppressWarnings("finally")
	public int get(){
		
		try {
			int i = 2;
			assert i == 1;
			return 1;
		} catch (Exception e) {
			
		} finally {
			System.out.println("finally....");
			return 2;
		}
		
	}
	
	
	public void testFinal(final StringBuffer x, final StringBuffer y){
		x.append("xxx");
//		y = x;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}


class Something{
	int i;
	public void doSomething(){
		System.out.println("i = " +i);
	}
}
 
interface A {
	int x = 0;
}

class B {
	int x = 1;
}

class C extends B implements A{
	public void getX(){
		System.out.println(super.x);
		System.out.println(A.x);
		System.out.println(super.x);
	}
	
	public static void main(String[] args) {
		new C().getX();
	}
}