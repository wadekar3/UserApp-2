package App2.test;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@SuppressWarnings({ "serial" })

@WebServlet("/add")
public class AddEmployeeServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,
	IOException{
		HttpSession hs = req.getSession(false); //Accessing existing session
		
		if(hs==null) {
			
			req.setAttribute("msg","Session Expired...<br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
			
		}
		else {
			
			String name = req.getParameter("name");
			String desg = req.getParameter("desg");
			int bSal = Integer.parseInt(req.getParameter("bsal"));
			String phNo = req.getParameter("phno");
			String eId = "NIT"+phNo;
			float hra = 0.78f*bSal;
			float da = 0.61f*bSal;
			float totSal = bSal+hra+da;
			
			EmployeeBean eb = new EmployeeBean();
			
			eb.seteId(eId);
			eb.seteName(name);
			eb.seteDesg(desg);
			eb.setbSal(bSal);
			eb.setHra(hra);
			eb.setDa(da);
			eb.setTotSal(totSal);
			
			int k = new AddEmployeeDAO().addEmployee(eb);
			
			if(k>0) {
				
				req.setAttribute("msg","Employee Added Successfully...<br>");
				req.getRequestDispatcher("AddEmployee.jsp").forward(req,res);
				
			}			
		}
	}
}
