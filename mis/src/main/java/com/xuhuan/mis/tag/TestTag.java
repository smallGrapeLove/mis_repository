package com.xuhuan.mis.tag;

import javax.servlet.ServletException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * @author huan.xu
 * @Time 2019-03-01 14:42
 */
public class TestTag extends TagSupport {

    private String prefix;

    @Override
    public int doStartTag() throws JspException {
        this.pageContext.setAttribute("prefix", this.prefix, PageContext.REQUEST_SCOPE);
        return Tag.EVAL_PAGE;
    }

    @Override
    public int doEndTag() throws JspException {
        try {
            this.pageContext.include("/tag.jsp");
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return EVAL_PAGE;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}
