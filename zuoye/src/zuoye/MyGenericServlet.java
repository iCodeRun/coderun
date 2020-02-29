package zuoye;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public abstract class MyGenericServlet implements Servlet{

	private ServletConfig context = null;
	@Override
	public void destroy() {
		
	}

	@Override
	public ServletConfig getServletConfig() {
		System.out.println("getServletConfig1:");
		
		return this.context;
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("initgo:"+config);
		this.context = config;
	}

	@Override
	public abstract void service(ServletRequest request, ServletResponse responds) throws ServletException, IOException ;

}
