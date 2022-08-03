package zamperetta.crudspring.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import zamperetta.crudspring.model.Course;
import zamperetta.crudspring.repository.CourseRepository;

@RestController // informa pro spring que isso é uma api acessada por uma url
@RequestMapping("/api/courses")
@AllArgsConstructor // tombox cria o construtor
public class CoursesController {

    private CourseRepository courseRepository;

    @GetMapping
    // equivalente a @RequestMapping(method = RequestMethod.GET)
    public List<Course> list() {
        return courseRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Course> create(@RequestBody Course course) {
        // return courseRepository.save(course);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(courseRepository.save(course));
    }
}
