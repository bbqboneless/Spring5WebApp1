package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//injects instances of repositories
@Component
public class BootstrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String[] args) throws Exception{
        Publisher publisher = new Publisher();
        publisher.setName("Penguin");
        publisher.setCity("Fresno");
        publisher.setState("California");

        publisherRepository.save(publisher);

        Author sam = new Author("Sam", "Licea");
        Book ddd = new Book("Looking for Alaska","123456");
        sam.getBooks().add(ddd);
        ddd.getAuthors().add(sam);

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepository.save(sam);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod","Johnson");
        Book noEJB = new Book("J2EE","456789");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of authors: " + authorRepository.count());
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Number of publishers: " + publisherRepository.count());
        System.out.println("Publisher number of books: " + publisher.getBooks().size());
    }
}
