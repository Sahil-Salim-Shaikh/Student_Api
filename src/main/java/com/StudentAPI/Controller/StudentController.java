package com.StudentAPI.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.StudentAPI.Entity.Student;
import com.StudentAPI.Repository.StudentRepository;

@RestController
@RequestMapping("/api/students")
public class StudentController {
	@Autowired
	StudentRepository studentRepository;
	
	
	@GetMapping
	public List<Student> getAllStudents()
	{
		return studentRepository.findAll();
	}
	

	@GetMapping("/{id}")
	public Student getStudentById(@PathVariable long id)
	{
		return studentRepository.findById(id).orElse(null);
	}
	

	@PostMapping
	public Student createStudent(@RequestBody Student student)
	{
		return studentRepository.save(student);
	}
	
	@PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
        Student existingStudent = studentRepository.findById(id).orElse(null);
        if (existingStudent != null) {
            existingStudent.setName(updatedStudent.getName());
            existingStudent.setCourse(updatedStudent.getCourse());
            existingStudent.setAge(updatedStudent.getAge());
            return studentRepository.save(existingStudent);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentRepository.deleteById(id);
    }
		
	}
	
	

	
	
	
	
	


