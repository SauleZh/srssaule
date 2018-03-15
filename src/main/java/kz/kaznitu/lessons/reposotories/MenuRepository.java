package kz.kaznitu.lessons.reposotories;

import kz.kaznitu.lessons.models.Menu;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MenuRepository extends CrudRepository<Menu,Long> {
    @Override
    Optional<Menu> findById(Long id);
}
