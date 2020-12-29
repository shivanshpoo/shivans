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

import in.co.sunrays.project0.dto.RoleDTO;
import in.co.sunrays.project0.exception.DuplicateRecordException;
import in.co.sunrays.project0.service.RoleServiceInt;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:src/main/webapp/WEB-INF/dispatcher-servlet.xml" })
public class RoleServiceTest {

	@Autowired
	private RoleServiceInt service;

	
	@Ignore
	public void testAdd() {
		RoleDTO dto=new RoleDTO();
		dto.setName("Student");
		dto.setDescription("Student");
		dto.setCreatedBy("admin");
		dto.setModifiedBy("admin");
		try {
			long pk=service.add(dto);
			System.out.println("pk value-->"+pk);
		} catch (DuplicateRecordException e) {
			e.printStackTrace();
		}
	
	}

	@Ignore
	public void testUpdate() {
				RoleDTO dto = service.findById(1);

		if(dto!=null)
		{
			
			dto.setName("aadi");
			dto.setDescription("pathak");
			
			
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
		RoleDTO dto=service.findByName("Student");
		if(dto!=null)
		{
			System.out.println("dto value for description====>"+dto.getDescription());
		}
		
	}

	@Ignore
	public void testFindById() {
		RoleDTO dto = service.findById(1);
		
		if(dto!=null)
         {
			System.out.println("dto value for name--->"+dto.getName());
         }
	
	}

	@Test
	public void testSearchRoleDTO() {
		RoleDTO dto = null;
		List list = service.search(dto);
		Iterator it = list.iterator();
		System.out.println("list size = " + list.size());
		while (it.hasNext()) {
			dto = (RoleDTO) it.next();
			System.out.println(dto.getName());
			System.out.println(dto.getDescription());
			
		}

	}

}
