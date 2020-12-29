package in.co.sunrays.project0.test;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import in.co.sunrays.project0.dto.TimetableDTO;
import in.co.sunrays.project0.exception.DuplicateRecordException;
import in.co.sunrays.project0.service.TimetableServiceInt;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration("WebContent")
@ContextConfiguration({"file:src/main/webapp/WEB-INF/dispatcher-servlet.xml" })
public class TimeTableServiceTest {

	@Autowired
	public TimetableServiceInt service;
	
	@Test
	public void testAdd() {
		TimetableDTO dto = new TimetableDTO();
		dto.setCourseId(1);
		dto.setSubjectId(1);
	dto.setSemester("2 semester");
		dto.setExamDate(new Date());
		//dto.setExamTime("9 am to 12 pm");
		dto.setCreatedBy("admin");
		dto.setModifiedBy("admin");

		try {
			Long pk = service.add(dto);
			System.out.println("success" + pk);
		} catch (DuplicateRecordException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
		e.printStackTrace();	
		}

	}

}
