package com.epam.jjp.sjspt.taglib;

import java.util.Collections;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class ForEachHandler extends TagSupport {
	private Collections collection;

	@Override
	public int doStartTag() throws JspException {

		JspWriter out = pageContext.getOut();
		return SKIP_BODY;
	}

	public Collections getCollection() {
		return collection;
	}

	public void setCollection(Collections collection) {
		this.collection = collection;
	}

}
