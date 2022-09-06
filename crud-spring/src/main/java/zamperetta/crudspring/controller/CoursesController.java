package zamperetta.crudspring.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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

    @ResponseStatus(code = HttpStatus.CREATED) // retorna status 201
    @PostMapping
    public Course create(@RequestBody Course course) {
        return courseRepository.save(course);
    }
}
