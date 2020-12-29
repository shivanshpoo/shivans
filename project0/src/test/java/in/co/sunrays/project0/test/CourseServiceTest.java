package in.co.sunrays.project0.test;

import java.util.Iterator;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import in.co.sunrays.project0.dto.CourseDTO;
import in.co.sunrays.project0.exception.DuplicateRecordException;
import in.co.sunrays.project0.service.CourseServiceInt;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration("WebContent")
@ContextConfiguration({"file:src/main/webapp/WEB-INF/dispatcher-servlet.xml" })
public class CourseServiceTest {

	@Autowired
	private CourseServiceInt service;
	
	@Ignore
	public void testAdd() {
		CourseDTO dto = new CourseDTO();
		// dto.setId(1);
		dto.setCourseName("dbms");
		dto.setDescription("data base management system");
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
		CourseDTO dto = service.findByPK(1);

		if(dto!=null)
		{
			
			dto.setCourseName("mca");
			
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
	public void testFindByName() {
		CourseDTO dto=service.findByName("mca");
		if(dto!=null)
		{
			System.out.println("description"+dto.getDescription());
		}
		
	}

	@Ignore
	public void testFindByPK() {
		CourseDTO dto=service.findByPK(1);
		if(dto!=null)
		{
			System.out.println("description"+dto.getDescription());
		}
	}

	@Test
	public void testSearchCourseDTO() {
		CourseDTO dto = null;
		List<CourseDTO> list = service.search(dto);
		Iterator<CourseDTO> it = list.iterator();
		System.out.println("list size = " + list.size());
		while (it.hasNext()) {
			dto = it.next();
			System.out.println(dto.getCourseName());
			System.out.println(dto.getDescription());
			
		}
	}

	
}
