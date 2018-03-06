package kz.kaznitu.lessons.reposotories;

import kz.kaznitu.lessons.models.Kafedra;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface KafedraRepository extends CrudRepository<Kafedra,Long> {
    @Override
    Optional<Kafedra> findById(Long id);
}