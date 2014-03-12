package elasticsearch.repository;

import elasticsearch.domain.Book;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

/**
 * User: Bogdan Apetrei
 * Date: 3/12/14
 * Time: 1:30 PM
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/bookRepositoryTest-context.xml")
public class BookRepositoryTest {

    @Resource
    private BookRepository repository;

    private static String BOOK_ID = "12345";
    private static String BOOK_NAME = "Spring Data Elasticsearch";

    @Before
    public void emptyData(){
        repository.deleteAll();
    }

    @Test
    public void testSetup(){

        Book book = createBook();

        repository.save(book);

        Book indexedBook = repository.findOne(book.getId());
        assertThat(indexedBook,is(notNullValue()));
        assertThat(indexedBook.getId(),is(book.getId()));
    }

    @Test
    public void testFindByName() {

        Book book = createBook();

        repository.save(book);

        List<Book> books = repository.findByName(BOOK_NAME);
        assertThat(books,is(notNullValue()));
        assertThat(books.size(),is(1));
        assertThat(books.get(0).getId(), is(BOOK_ID));
    }

    private Book createBook() {
        Book book = new Book();
        book.setId(BOOK_ID);
        book.setName(BOOK_NAME);
        book.setVersion(System.currentTimeMillis());
        return book;
    }
}
