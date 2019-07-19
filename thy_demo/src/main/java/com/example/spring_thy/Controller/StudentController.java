package com.example.spring_thy.Controller;


import com.example.spring_thy.Entity.Students;
import com.example.spring_thy.Mapper.StudentMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class StudentController {

    @Resource
    StudentMapper studentMapper;

    @RequestMapping(method = RequestMethod.GET)
    public String allStudents(Model model){
        List<Students> students=studentMapper.findAll();
        model.addAttribute("students",students);
        return "studentsList";
    }

    @RequestMapping(value ="/create",method = RequestMethod.GET)
    public String createStudent(Model model){
        model.addAttribute("student",new Students());
        model.addAttribute("action","create");
        return "studentsForm";
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public String postStudent(Model model, @Param("id") int id, @Param("name") String name, @Param("school") String school, @Param("score") Integer score){
        studentMapper.insertStudent(id,name,school,score);
        return "redirect:/";
    }

    @RequestMapping(value = "/update/{id}",method = RequestMethod.GET)
    public String getStudent(Model model,@PathVariable int id){
        model.addAttribute("student",studentMapper.queryById(id));
        model.addAttribute("action","update");
        return "studentsForm";
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String updateStudent(@Param("id") int id, @Param("name") String name, @Param("school") String school, @Param("score") Integer score){
//        Students student=new Students();
//        student.setId(id);
//        student.setName(name);
//        student.setSchool(school);
//        student.setScore(score);
        studentMapper.updateStudent(id,name,school,score);
        return "redirect:/";
    }


    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public String deleteStudent(Model model, @PathVariable int id){
        studentMapper.deleteStudent(id);
        return "redirect:/";
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }

}
