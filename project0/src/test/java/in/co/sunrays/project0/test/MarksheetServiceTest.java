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

import in.co.sunrays.project0.dto.MarksheetDTO;
import in.co.sunrays.project0.exception.DuplicateRecordException;
import in.co.sunrays.project0.service.MarksheetServiceInt;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration("WebContent")
@ContextConfiguration({"file:src/main/webapp/WEB-INF/dispatcher-servlet.xml" })
public class MarksheetServiceTest {

	@Autowired
	private MarksheetServiceInt service;
	
	@Ignore
	public void testAdd() {
		MarksheetDTO dto = new MarksheetDTO();
		// dto.setId(1);
		dto.setStudentId(1);
		dto.setRollNo("01CS01");
        dto.setPhysics(55);
        dto.setChemistry(65);
        dto.setMaths(75);
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
		MarksheetDTO dto = service.findByPK(1);

		if(dto!=null)
		{
			
			dto.setRollNo("01CS02");
			dto.setChemistry(99);
			
			
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
	public void testFindByRollNo() {
		MarksheetDTO dto=service.findByRollNo("01CS02");
		if(dto!=null)
		{
			System.out.println("student name"+dto.getName());
		}
		
	}

	@Ignore
	
	public void testFindByPK() {
		MarksheetDTO dto=service.findByPK(1);
		if(dto!=null)
		{
			System.out.println("student name"+dto.getName());
		}
	}

	
	@Ignore 
	
	public void testSearchMarksheetDTO() {
		MarksheetDTO dto = null;
		List<MarksheetDTO> list = service.search(dto);
		Iterator<MarksheetDTO> it = list.iterator();
		System.out.println("list size = " + list.size());
		while (it.hasNext()) {
			dto = it.next();
			System.out.println(dto.getName());
			System.out.println(dto.getRollNo());
			System.out.println(dto.getMaths());
			System.out.println(dto.getChemistry());
			System.out.println(dto.getPhysics());
			
		}
	}

	@Test
	public void testGetMeritList() {
		MarksheetDTO dto = null;
		List<MarksheetDTO> list = service.getMeritList(0,0);
		Iterator<MarksheetDTO> it = list.iterator();
		System.out.println("list size = " + list.size());
		while (it.hasNext()) {
			dto = it.next();
			System.out.println(dto.getName());
			System.out.println(dto.getRollNo());
			System.out.println(dto.getMaths());
			System.out.println(dto.getChemistry());
			System.out.println(dto.getPhysics());
			
		}
	}

	
}
