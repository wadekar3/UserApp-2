package App2.test;

import java.io.*;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@SuppressWarnings("serial")
@WebServlet("/update")

public class UpdateEmployeeServlet extends HttpServlet {
	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, 
	IOException {
		
		HttpSession hs = req.getSession(false);
		
		if (hs == null) {
			req.setAttribute("msg", "Session Expired...<br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		} else {
			ArrayList<EmployeeBean> al = (ArrayList<EmployeeBean>) hs.getAttribute("alist");
			String eId = req.getParameter("eid");
			Iterator<EmployeeBean> it = al.iterator();
			
			while (it.hasNext()) {
				EmployeeBean eb = (EmployeeBean) it.next();
				if (eId.equals(eb.geteId())) {
					
					int bSal = Integer.parseInt(req.getParameter("bsal"));
					float hra = 0.78F * bSal;
					float da = 0.61F * bSal;
					float totSal = bSal + hra + da;
					eb.setbSal(bSal);
					eb.setHra(hra);
					eb.setDa(da);
					eb.setTotSal(totSal);
					
					int k = new UpdateEmployeeDAO().update(eb);
					
					if (k > 0) {
						req.setAttribute("msg", "Employee Updated Successfully...<br>");
						req.getRequestDispatcher("UpdateEmployee.jsp").forward(req, res);
					} // end of if
					break;
				} // end of if
			} // end of loop
		}
	}
}
