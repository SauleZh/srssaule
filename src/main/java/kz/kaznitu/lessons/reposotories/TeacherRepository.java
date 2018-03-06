package kz.kaznitu.lessons.reposotories;


import kz.kaznitu.lessons.models.Kafedra;
import kz.kaznitu.lessons.models.Teacher;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TeacherRepository extends CrudRepository<Teacher, Long> {
    @Override
    Optional<Teacher> findById(Long id);
}
