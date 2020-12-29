package in.co.sunrays.project0.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.internal.SessionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@Transactional
@Controller
@RequestMapping(value="/ctl/Jasper")
public class JasperCtl {

	@Autowired
	private SessionFactory sessionFactory=null;
	
	@RequestMapping(method=RequestMethod.GET)
	public void display(HttpServletRequest request, HttpServletResponse response) throws JRException, SQLException, IOException {
		String path = request.getRealPath("/resources/JasperReport/Invoice.jrxml");
		Connection con = null;
		JasperReport jasperReport = JasperCompileManager.compileReport(path);
		Map<String, Object> map = new HashMap<String, Object>();
		con = ((SessionImpl)sessionFactory.getCurrentSession()).connection();
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, con);
		byte[] pdf = JasperExportManager.exportReportToPdf(jasperPrint);
		response.setContentType("application/pdf");
		response.getOutputStream().write(pdf);
		response.getOutputStream().flush();
	}
}
