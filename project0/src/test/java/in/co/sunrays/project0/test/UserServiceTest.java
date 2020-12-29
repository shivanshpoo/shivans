package in.co.sunrays.project0.test;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.internal.runners.statements.Fail;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import in.co.sunrays.project0.dto.UserDTO;
import in.co.sunrays.project0.exception.DuplicateRecordException;
import in.co.sunrays.project0.service.UserServiceInt;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration("WebContent")
@ContextConfiguration({"file:src/main/webapp/WEB-INF/dispatcher-servlet.xml" })
public class UserServiceTest {

@Autowired
private UserServiceInt service;

/**
 * Test method for {@link in.co.sunrays.project0.service.UserServiceSpringImpl#add(in.co.sunrays.project0.dto.UserDTO)}.
 */

@Ignore
public void testadd()
{
	UserDTO dto=new UserDTO();
	dto.setFirstName("Aditya");
	dto.setLastName("Pathak");
	dto.setLogin("aadi@gmail.com");
	dto.setPassword("Aditya1234#");
	dto.setConfirmPassword("Aditya1234#");
	dto.setGender("Male");
	dto.setRoleId(1L);
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

/**
 * Test method for {@link in.co.sunrays.project0.service.UserServiceSpringImpl#registerUser(in.co.sunrays.project0.dto.UserDTO)}.
 * @throws ApplicationException 
 */

@Ignore
public void testUpdate() {
	UserDTO dto = service.findByPK(1);

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
public void testFindByLogin() {
	UserDTO dto = service.findByLogin("aadi@gmail.com");
	if (dto == null) {
		System.out.println("findByLogin Fail");
	} else {
		System.out.println(dto.getFirstName());
		System.out.println(dto.getLastName());
	}
}

@Ignore
public void testFindByPK() {
	UserDTO dto = service.findByPK(1);

	if(dto!=null)
	{
		System.out.println("find by pk success");
	}
}

@Ignore
public void testSearchUserDTO() {
	UserDTO dto = null;
	List<UserDTO> list = service.search(dto);
	Iterator<UserDTO> it = list.iterator();
	System.out.println("list size = " + list.size());
	while (it.hasNext()) {
		dto = it.next();
		System.out.println(dto.getFirstName());
		System.out.println(dto.getLastName());
		System.out.println(dto.getLogin());
		System.out.println(dto.getPassword());
		System.out.println(dto.getConfirmPassword());
		System.out.println(dto.getMobileNo());
		System.out.println(dto.getRoleId());
		System.out.println(dto.getRoleName());
	}
}


@Ignore
public void testChangePassword() {	
}


@Ignore
public void testAuthenticate() {
	
	UserDTO dto=new UserDTO();
	dto.setLogin("aadi@gmail.com");
	dto.setPassword("Aditya1234#");
	UserDTO dtoexist=service.authenticate(dto);
	System.out.println("dtoexist value"+dtoexist.getFirstName());
	
}


@Ignore
public void testForgetPassword() {

}


}
