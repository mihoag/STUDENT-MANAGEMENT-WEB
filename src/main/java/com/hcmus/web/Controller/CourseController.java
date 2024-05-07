package com.hcmus.web.Controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hcmus.web.Model.Course;
import com.hcmus.web.Model.Student;
import com.hcmus.web.service.CourseService;
import com.hcmus.web.service.StudentService;

@Controller
@RequestMapping("/course")
public class CourseController {
	   @Autowired
	   private CourseService cSer;
		
	   @GetMapping	
	   public String CoursePage(Model model)
	   { 
		  return viewPage(model, 1, "name", "asc",null);  
	   }
	   @RequestMapping("/page/{pageNum}")
		public String viewPage(Model model, 
				@PathVariable(name = "pageNum") int pageNum,
				@Param("sortField") String sortField,
				@Param("sortDir") String sortDir, @Param("keyword") String keyword) {
		
		    model.addAttribute("course", new Course());
		    
		    //System.out.println(keyword);
		    if(keyword != null && keyword.equals("null"))
		    {
		       keyword = null;	
		    }
		    
			Page<Course> page = cSer.listAll(keyword,pageNum, sortField, sortDir);
			List<Course> listCourse = page.getContent();
			
		    model.addAttribute("fieldSideBarName","course");
			
			model.addAttribute("currentPage", pageNum);		
			model.addAttribute("totalPages", page.getTotalPages());
			model.addAttribute("totalItems", page.getTotalElements());
			model.addAttribute("keyword", keyword);
			
			
			
			model.addAttribute("sortField", sortField);
			model.addAttribute("sortDir", sortDir);
			model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
			model.addAttribute("listCourse", listCourse);
			model.addAttribute("year", new Date().getYear() + 1900);
			
			return "course";
		}	
	   
	    @PostMapping
	    public String addCourse(Model model, @ModelAttribute("course") Course c)
	    {
	        cSer.add(c);
	        return viewPage(model, 1, "name", "asc", null);  
	    }
}
