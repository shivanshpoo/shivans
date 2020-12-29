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

import in.co.sunrays.project0.dto.SubjectDTO;
import in.co.sunrays.project0.exception.DuplicateRecordException;
import in.co.sunrays.project0.service.SubjectServiceInt;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration("WebContent")
@ContextConfiguration({"file:src/main/webapp/WEB-INF/dispatcher-servlet.xml" })
public class SubjectServiceTest {

	@Autowired
	private SubjectServiceInt service;
	
	@Ignore
	public void testAdd() throws DuplicateRecordException {
		SubjectDTO dto = new SubjectDTO();
		
		dto.setCourseId(1);
		dto.setSubjectName("aadi");
		dto.setCreatedBy("admin");
		dto.setModifiedBy("admin");
		

		Long pk = service.add(dto);
		System.out.println("success" + pk);

	}

	@Ignore
	public void testUpdate() throws DuplicateRecordException {
		SubjectDTO dto = service.findByPK(1);

		if(dto!=null)
		{
			
			dto.setSubjectName("aditya");
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
	public void testFindByName() {
		SubjectDTO dto=service.findByName("aditya");
		if(dto!=null)
		{
			System.out.println("course name"+dto.getCourseName());
		}
		
	}


	@Test
	public void testFindByPK() {
		SubjectDTO dto=service.findByPK(1);
		if(dto!=null)
		{
			System.out.println("course name"+dto.getCourseName());
			System.out.println("subj name" +dto.getSubjectName());
		
		}
	}

	@Ignore
	public void testSearchCourseDTO() {
		SubjectDTO dto = null;
		List<SubjectDTO> list = service.search(dto);
		Iterator<SubjectDTO> it = list.iterator();
		System.out.println("list size = " + list.size());
		while (it.hasNext()) {
			dto = it.next();
			System.out.println(dto.getCourseName());
			System.out.println(dto.getSubjectName());
			
		}
	}

}
