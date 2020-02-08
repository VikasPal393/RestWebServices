package com.rest.web.services.student;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@GetMapping("/jpa/all")
	public List<Student> getAll(){
		return studentRepository.findAll();
	}
	
	@GetMapping("/jpa/{id}")
	public Optional<Student> getId(@PathVariable("id") int id){
		return studentRepository.findById(id);
	}
	
	@GetMapping("/jpa/{id}/posts")
	public List<Post> getIdPosts(@PathVariable("id") int id){
		 Optional<Student> s1= studentRepository.findById(id);
		 return s1.get().getPostList();
	} 
	
	@PostMapping("/jpa/save")
	public void save(@RequestBody Student student) {
		studentRepository.saveAndFlush(student);
	}
	
	@PostMapping("/jpa/save/{id}/post")
	public void savePost(@PathVariable("id") int id, @RequestBody Post post) {
		Optional<Student> s2 = studentRepository.findById(id);
		post.setStudent(s2.get());
		postRepository.save(post);
		
	}
	
	
	
	@DeleteMapping("/jpa/{id}")
	public void delete(@PathVariable("id") int id) {
		studentRepository.deleteById(id);
	}
	
	
}
