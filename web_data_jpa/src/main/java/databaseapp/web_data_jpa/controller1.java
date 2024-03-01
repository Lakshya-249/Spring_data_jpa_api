package databaseapp.web_data_jpa;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class controller1 {

    private final studentrepository repository;

    public controller1(studentrepository repository) {
        this.repository = repository;
    }

    @PostMapping("/student")
    public Student post(
            @RequestBody Student stud1
    ){
        return repository.save(stud1);
    }

    @GetMapping("/student")
    public List<Student> findstudent(){
        return repository.findAll();
    }

    @GetMapping("/student/{id}")
    public Student getstud(
            @PathVariable("id") Integer id
    ){
        return repository.findById(id)
                .orElse(new Student());
    }

    @GetMapping("/student/user/{name}")
    public List<Student> getstud2(
            @PathVariable("name") String name
    ){
        return repository.findAllByFirstnameContaining(name);
    }

    @DeleteMapping("/student/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delstud(
            @PathVariable("id") Integer id
    ){
        repository.deleteById(id);
    }
}
