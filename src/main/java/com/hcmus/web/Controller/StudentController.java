package com.hcmus.web.Controller;

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

import com.hcmus.web.DTO.StudentDTO;
import com.hcmus.web.Model.Student;
import com.hcmus.web.service.StudentService;

@Controller
@RequestMapping(value = "/student")
public class StudentController {
	
   @Autowired
   private StudentService stSer;
	
   @GetMapping	
   public String studentPage(Model model)
   { 
	  return viewPage(model, 1, "name", "asc",null);  
   }
   @RequestMapping("/page/{pageNum}")
	public String viewPage(Model model, 
			@PathVariable(name = "pageNum") int pageNum,
			@Param("sortField") String sortField,
			@Param("sortDir") String sortDir, @Param("keyword") String keyword) {
	
	    model.addAttribute("student", new Student());
	    
	    //System.out.println(keyword);
	    if(keyword != null && keyword.equals("null"))
	    {
	       keyword = null;	
	    }
	    
		Page<Student> page = stSer.listAll(keyword,pageNum, sortField, sortDir);
		List<Student> listStudents = page.getContent();
		
		
	    model.addAttribute("fieldSideBarName","student");
		
		model.addAttribute("currentPage", pageNum);		
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		model.addAttribute("keyword", keyword);
		
		
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		model.addAttribute("listStudent", StudentDTO.listModeltoListDTO(listStudents));
		return "student";
	}	
  
   
    @PostMapping
    public String addStudent(Model model, @ModelAttribute("student") Student st)
    {
        stSer.add(st);
        return viewPage(model, 1, "name", "asc", null);  
    }
}
