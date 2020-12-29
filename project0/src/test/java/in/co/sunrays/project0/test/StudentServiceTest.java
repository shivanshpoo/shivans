package in.co.sunrays.project0.test;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import in.co.sunrays.project0.dto.StudentDTO;
import in.co.sunrays.project0.exception.ApplicationException;
import in.co.sunrays.project0.exception.DuplicateRecordException;
import in.co.sunrays.project0.service.StudentServiceInt;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration("WebContent")
@ContextConfiguration({"file:src/main/webapp/WEB-INF/dispatcher-servlet.xml" })
public class StudentServiceTest {

	@Autowired
	private StudentServiceInt service;

	@Ignore
	public void testAdd() {
		StudentDTO dto = new StudentDTO();
		// dto.setId(1);
		dto.setFirstName("Aditya");
		dto.setLastName("Pathak");
		dto.setEmailId("aadi@gmail.com");
		dto.setCollegeId(1);
		dto.setDob(new Date());
		dto.setMobileNo("9806613087");
		dto.setCreatedBy("admin");
		dto.setModifiedBy("admin");
		

		try {
			Long pk = service.add(dto);
			System.out.println("success" + pk);
		} catch (DuplicateRecordException e) {
			e.printStackTrace();
		}

	}

	@Ignore
	public void testUpdate() throws ApplicationException {
		StudentDTO dto = service.findByPK(1);

		if(dto!=null)
		{
			
			dto.setFirstName("aadi");
			dto.setLastName("pathak");
			
			
			try {
				service.update(dto);
				System.out.println("UpdateSuccess");
			} catch (DuplicateRecordException e) {
				e.printStackTrace();
			}
			
		}
		else
		{
			System.out.println("Update error");
		}

	}

	@Ignore
	public void testDelete() {
		service.delete(1);
	}

	@Ignore
	public void testFindByEmail() {
		StudentDTO dto=service.findByEmail("aadi@gmail.com");
		if(dto!=null)
		{
			System.out.println("student mobile no--->"+dto.getMobileNo());
		}
	}


	@Ignore
	public void testFindByPK() {
		StudentDTO dto=service.findByPK(1);
		if(dto!=null)
		{
			System.out.println("student last name--->"+dto.getLastName());
		}
	}

	
	@Test
	public void testSearchStudentDTO() {
		StudentDTO dto = null;
		List<StudentDTO> list = service.search(dto);
		Iterator<StudentDTO> it = list.iterator();
		System.out.println("list size = " + list.size());
		while (it.hasNext()) {
			dto = it.next();
			System.out.println(dto.getFirstName());
			System.out.println(dto.getLastName());
			System.out.println(dto.getEmailId());
			System.out.println(dto.getMobileNo());
		}
	}

	
}
