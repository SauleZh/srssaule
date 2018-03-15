package kz.kaznitu.lessons.reposotories;

import kz.kaznitu.lessons.models.Sponsor;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SponsorRepository extends CrudRepository<Sponsor, Long> {
    @Override
    Optional<Sponsor> findById(Long id);
}
