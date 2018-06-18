package com.zj.blog.util.others;

/**
 * Created by �ԕ� on 2017/8/26.
 */
	import java.io.IOException;
	import java.io.StringWriter;
	import java.util.regex.Matcher;
	import java.util.regex.Pattern;
	
	import javax.servlet.jsp.JspException;
	import javax.servlet.jsp.PageContext;
	import javax.servlet.jsp.tagext.JspFragment;
	import javax.servlet.jsp.tagext.SimpleTagSupport;


public class HtmlFilterTag extends SimpleTagSupport {
	
	private static final int subLength = 100; //��ȡ�ַ�������
	private static final String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>"; // ����script��������ʽ
	private static final String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>"; // ����style��������ʽ
	private static final String regEx_html = "<[^>]+>"; // ����HTML��ǩ��������ʽ
	private static final String regEx_space = "\\s*|\t|\r|\n";//����ո�س����з�
	
	public static String filter(String htmlStr) {
		Pattern p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
		Matcher m_script = p_script.matcher(htmlStr);
		htmlStr = m_script.replaceAll(""); // ����script��ǩ
		
		Pattern p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
		Matcher m_style = p_style.matcher(htmlStr);
		htmlStr = m_style.replaceAll(""); // ����style��ǩ
		
		Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
		Matcher m_html = p_html.matcher(htmlStr);
		htmlStr = m_html.replaceAll(""); // ����html��ǩ
		
		Pattern p_space = Pattern.compile(regEx_space, Pattern.CASE_INSENSITIVE);
		Matcher m_space = p_space.matcher(htmlStr);
		htmlStr = m_space.replaceAll(""); // ���˿ո�س���ǩ
		return htmlStr.trim(); // �����ı��ַ���
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		
		StringWriter sw = new StringWriter();
		JspFragment jf = this.getJspBody();
		jf.invoke(sw);
		String content = sw.getBuffer().toString();
		content = filter(content);
		content = content.replaceAll(" ", "");
		int contentLength =content.length();
		if(contentLength>subLength) {
			content = content.substring(0,subLength);
		} else {
			content = content.substring(0,contentLength);
		}
		((PageContext) this.getJspContext()).getOut().write(content);
	}
	
	
}