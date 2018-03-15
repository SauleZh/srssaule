package kz.kaznitu.lessons.reposotories;

import kz.kaznitu.lessons.models.Restoran;
import org.springframework.data.repository.CrudRepository;

public interface RestoranRepository extends CrudRepository<Restoran, Long>{
}
