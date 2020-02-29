package zuoye;

import java.io.IOException;

import javax.security.auth.login.ConfigurationSpi;
import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ZuoYe extends MyGenericServlet {
	

	/**
	 * 继承GenericServlet 它是继承了Servlet等类的抽象类
	 */
	private static final long serialVersionUID = 1L;
	
	

	@Override
	public void service(ServletRequest request, ServletResponse response) throws IOException
	{
		System.out.println("service");
		
		String config = getServletConfig().getServletContext().getInitParameter("user");
		System.out.println(config);
		
		System.out.println("第一个service方法输出的requestuser"+request.getParameter("user"));
		
		HttpServletResponse res = (HttpServletResponse) response;
		HttpServletRequest  req = (HttpServletRequest) request;
		service(req,res);
//		res.getWriter().write("hello web");
		
	}
	
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		String method = req.getMethod();
		if(method.equalsIgnoreCase("GET"))
		{
			doGet(req,res);
		}else if (method.equalsIgnoreCase("POST")) {
			
		}
		{
			doPost(req,res);
		}
		
		
	}
	
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		String user = req.getParameter("user");//获取网页传过来的user
		String passoword = req.getParameter("password");
		//获取web.xml里面设置的user和passWord和网页的比较
		if(user.equals(getServletConfig().getServletContext().getInitParameter("user"))
			&& passoword.equals(getServletConfig().getServletContext().getInitParameter("password"))	)
		{
			res.getWriter().write("login successful");
		}
		else{
			res.getWriter().write("login unsuccessful");
			
		}
		
	}
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		res.getWriter().write("login in Post");
	}
	
}
