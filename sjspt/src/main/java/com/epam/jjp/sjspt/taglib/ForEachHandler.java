package com.epam.jjp.sjspt.taglib;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.collections.iterators.ArrayIterator;
import org.apache.commons.lang3.ArrayUtils;
import org.neo4j.helpers.ArrayUtil;

public class ForEachHandler extends SimpleTagSupport{
	private Iterator<?> iterator;
	private String var;

	private Object items;
	
	@Override
	public void doTag() throws JspException, IOException {
		iterator = chooseIterator();
		while(iterator.hasNext()){
			JspContext jspContext = getJspContext();
			jspContext.setAttribute(var, iterator.next());
			getJspBody().invoke(null);
		}
	}

	public Object getItems() {
		return items;
	}

	public void setItems(Object items) {
		this.items = items;
	}
	public String getVar() {
		return var;
	}

	public void setVar(String var) {
		this.var = var;
	}
	
	private Iterator<?> chooseIterator(){
		Iterator<?> iterator = null;
		if(items instanceof Map){
			Map<?,?> map = (Map<?, ?>)(items);
			iterator = map.entrySet().iterator();
		}else if(items instanceof List){
			List<?> list = (List<?>)(items);
			iterator = list.iterator();
		}else{
			iterator = new ArrayIterator(items);
		
		}
		return iterator;
		
	}
}
