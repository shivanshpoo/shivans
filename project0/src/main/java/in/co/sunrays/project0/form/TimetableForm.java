package in.co.sunrays.project0.form;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import in.co.sunrays.project0.dto.BaseDTO;
import in.co.sunrays.project0.dto.TimetableDTO;
import in.co.sunrays.project0.util.Util;

public class TimetableForm extends BaseForm {


	/** The course id. */
	@NotNull
	private Long courseId;
	
	
	/** The course name. */
	private String courseName;
	
	/** The subject id. */
	@NotNull
	private Long subjectId;
	
	
	/** The subject name. */
	private String subjectName;
	
	/** The exam date. */
	@NotEmpty
	private String examDate;
	
	/** The exam time. */
	@NotEmpty
	private String examTime;
	
	/** The semester. */
	@NotEmpty
	private String semester;

	

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getExamDate() {
		return examDate;
	}

	public void setExamDate(String examDate) {
		this.examDate = examDate;
	}

	public String getExamTime() {
		return examTime;
	}

	public void setExamTime(String examTime) {
		this.examTime = examTime;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	@Override
	public BaseDTO getDto() {
		TimetableDTO dto=new TimetableDTO();
		dto.setId(id);
		if(courseId!=null)
		{
		dto.setCourseId(courseId);	
		System.out.println("course===" +courseId);

		}
        dto.setCourseName(courseName);
        System.out.println("course====" +courseName);
        if(subjectId!=null)
        {
        dto.setSubjectId(subjectId);	
        System.out.println("subj id====" +subjectId);
        }
        dto.setSubjectName(subjectName);
        System.out.println("subj name====" +subjectName);
	    dto.setExamDate(Util.getDate(examDate));     
	    System.out.println("ex date====" +examDate);
		dto.setSemester(semester);
		System.out.println("semm===" +semester);
		dto.setExamTime(examTime);
		System.out.println("ex time===" +examTime);
		dto.setCreatedBy(createdBy);
	    dto.setModifiedBy(modifiedBy);
	    dto.setCreatedDateTime(new Timestamp(new Date().getTime()));
	    dto.setModifiedDateTime(new Timestamp(new Date().getTime()));
		return dto;
	}

	@Override
	public void populate(BaseDTO bDto) {
		TimetableDTO dto=(TimetableDTO) bDto;
		id=dto.getId();
		courseId=dto.getCourseId();
		System.out.println("course===" +dto.getCourseId());
		subjectId=dto.getSubjectId();
		System.out.println("subject===" +dto.getSubjectId());
		courseName=dto.getCourseName();
		System.out.println("course====" +dto.getCourseName());
		subjectName=dto.getSubjectName();
		System.out.println("subj name---" +dto.getSubjectName());
		examTime=dto.getExamTime();
		System.out.println("extime ---" +dto.getExamTime());
		examDate=Util.getDate(dto.getExamDate()); 
		System.out.println("get examdate==" +dto.getExamDate());

		semester=dto.getSemester();
		System.out.println("sem---" +dto.getSemester());
		createdBy=dto.getCreatedBy();
	   	modifiedBy=dto.getModifiedBy();
	     if(createdDatetime!=0)
	        {
	        	createdDatetime = dto.getCreatedDateTime().getTime();	
	        }
	        
	        if(modifiedDatetime!=0)
	        {
	        	modifiedDatetime = dto.getModifiedDateTime().getTime();	
	        }

	}
	}

	

