package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;
//CrudRepository selecting the object and the type of the primary key (id)
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
