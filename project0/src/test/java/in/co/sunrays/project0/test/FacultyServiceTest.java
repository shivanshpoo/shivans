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

import in.co.sunrays.project0.dto.FacultyDTO;
import in.co.sunrays.project0.exception.DuplicateRecordException;
import in.co.sunrays.project0.service.FacultyServiceInt;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration("WebCintent")
@ContextConfiguration({"file:src/main/webapp/WEB-INF/dispatcher-servlet.xml" })
public class FacultyServiceTest {

	@Autowired
	private FacultyServiceInt service;
	
	@Ignore
	public void testAdd() {
		FacultyDTO dto = new FacultyDTO();
		dto.setFirstName("Aditya");
		dto.setLastName("Pathak");
		dto.setLoginId("aadi@gmail.com");
		dto.setCollegeId(1);
		dto.setSubjectId(1);
		dto.setCourseId(1);
		dto.setDoj(new Date());
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
	public void testUpdate() {
		FacultyDTO dto = service.findByPK(1);

		if(dto!=null)
		{
			
			dto.setFirstName("aadi");
			dto.setLastName("pathak");
			service.update(dto);
			System.out.println("UpdateSuccess");
			
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
		FacultyDTO dto = service.findByEmail("aadi@gmail.com");
		if (dto == null) {
			System.out.println("findByLogin Fail");
		} else {
			System.out.println(dto.getFirstName());
			System.out.println(dto.getLastName());
		}
	}

@Ignore
public void testFindByPK() {
		FacultyDTO dto = service.findByPK(1);

		if(dto!=null)
		{
			System.out.println("find by pk success");
		}

	}

@Test
public void testSearchFacultyDTO() {
	FacultyDTO dto = null;
	List<FacultyDTO> list = service.search(dto);
	Iterator<FacultyDTO> it = list.iterator();
	System.out.println("list size = " + list.size());
	while (it.hasNext()) {
		dto = it.next();
		System.out.println(dto.getFirstName());
		System.out.println(dto.getLastName());
		System.out.println(dto.getLoginId());
		System.out.println(dto.getCollegeName());
		System.out.println(dto.getSubjectName());
		System.out.println(dto.getMobileNo());
	}
}



	
}
