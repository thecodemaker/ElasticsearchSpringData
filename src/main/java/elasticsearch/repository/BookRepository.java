package elasticsearch.repository;

import elasticsearch.domain.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * User: Bogdan Apetrei
 * Date: 3/12/14
 * Time: 10:49 AM
 */

@Repository
public interface BookRepository extends ElasticsearchRepository<Book, String> {

    List<Book> findByName(String name);

}
