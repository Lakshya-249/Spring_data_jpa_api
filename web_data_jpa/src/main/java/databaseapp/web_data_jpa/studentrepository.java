package databaseapp.web_data_jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;

public interface studentrepository extends JpaRepository<Student,Integer> {

    List<Student> findAllByFirstnameContaining(String fname);

}
