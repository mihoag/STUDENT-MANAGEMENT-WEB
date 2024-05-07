package com.hcmus.web.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hcmus.web.DTO.StudentDTO;
import com.hcmus.web.Model.Student;
import com.hcmus.web.service.CourseService;
import com.hcmus.web.service.StudentService;

@Controller
@RequestMapping("/student-course")
public class PointController {
	
	  @Autowired
	  private StudentService stSer;
	  
	  @Autowired
	  private CourseService cSer;
	
	  @GetMapping	
	   public String PointPage(Model model)
	   { 
		  return viewPage(model, 1, cSer.listYears().get(0));  
	   }
	   @RequestMapping("/page/{pageNum}")
		public String viewPage(Model model, 
				@PathVariable(name = "pageNum") int pageNum, @Param("year") int year ) {
		
		   
		    List<Student> lsStudent = stSer.getStudentByYear(year);
		    
		    List<StudentDTO> rsStudent = new ArrayList<>();
		    int totalStudent = lsStudent.size();
		    int numPerPage= 10;
		    int start = (pageNum-1)*numPerPage;
		    
		    
		    int totalPage = 0;
		    if(totalStudent % numPerPage == 0)
		    {
		    	totalPage = totalStudent/numPerPage;
		    }
		    else
		    {
		       totalPage = totalStudent/numPerPage + 1;
		    }
		    
		    
		    for(int i = start ; i < start+10  ; i++)
		    {
		        if(i == totalStudent)  
		        {
		        	break;
		        }
		        rsStudent.add(StudentDTO.ConvertToDTO(lsStudent.get(i)));
		    }
		  
		    model.addAttribute("fieldSideBarName","point");
		    model.addAttribute("selectYear", year);
		    model.addAttribute("listYear", cSer.listYears());
			model.addAttribute("currentPage", pageNum);		
			model.addAttribute("totalPages", totalPage);
			model.addAttribute("totalItems", lsStudent.size());    
			model.addAttribute("listStudent", rsStudent);
			return "point";
		}	
	  
}
