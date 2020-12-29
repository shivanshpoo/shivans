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

import in.co.sunrays.project0.dto.CollegeDTO;
import in.co.sunrays.project0.exception.DuplicateRecordException;
import in.co.sunrays.project0.service.CollegeServiceInt;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration("WebContent")
@ContextConfiguration({"file:src/main/webapp/WEB-INF/dispatcher-servlet.xml" })
public class CollegeServiceTest {

	@Autowired
	private CollegeServiceInt service;
	
	@Test
	public void testAdd() {
		CollegeDTO dto = new CollegeDTO();
		dto.setName("SRIT");
		dto.setAddress("jbp");
		dto.setCity("jabalpur");
		dto.setState("MP");
		dto.setPhoneNo("9806613087");
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
		CollegeDTO dto = service.findByPK(1);

		if(dto!=null)
		{			
			dto.setName("Om");
			dto.setAddress("Milloniganj");
			dto.setCity("Indore");

			try {
				service.update(dto);
				System.out.println("update successful");
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
	CollegeDTO dto=service.findByName("srit");
	if(dto!=null)
	{
		System.out.println("state------->"+dto.getState());
	}
}

@Ignore
public void testFindByPK() {
	CollegeDTO dto=service.findByPK(1);
	if(dto!=null)
	{
		System.out.println("city------->"+dto.getCity());
	}
}

@Test
public void testSearchCollegeDTO() {
	CollegeDTO dto = null;
	List<CollegeDTO> list = service.search(dto);
	Iterator<CollegeDTO> it = list.iterator();
	System.out.println("list size = " + list.size());
	while (it.hasNext()) {
		dto = it.next();
		System.out.println(dto.getName());
		System.out.println(dto.getAddress());
		System.out.println(dto.getCity());
		System.out.println(dto.getState());
		System.out.println(dto.getPhoneNo());
	}
}



}
