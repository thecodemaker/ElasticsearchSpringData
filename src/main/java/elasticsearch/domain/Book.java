package elasticsearch.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * User: Bogdan Apetrei
 * Date: 3/12/14
 * Time: 11:11 AM
 */

@Document(indexName = "book", type = "book")
public class Book {

    @Id
    private String id;

    private String name;
    private Double price;

    @Version
    private Long version;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
