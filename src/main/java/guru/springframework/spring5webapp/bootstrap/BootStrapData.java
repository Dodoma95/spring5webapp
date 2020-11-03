package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author dodoma = new Author("dodoma", "maillard");
        Book javaEdition = new Book("Domain Driven Design", "1234");
        Publisher eyrolls = new Publisher("1 rue des bouffons", "Paris", 75000);

        dodoma.getBooks().add(javaEdition);
        javaEdition.getAuthors().add(dodoma);

        authorRepository.save(dodoma);
        bookRepository.save(javaEdition);
        publisherRepository.save(eyrolls);

        Author rod = new Author("Rod", "Johnson");
        Book jee = new Book("J2EE", "15651651");
        Publisher hachette = new Publisher("1 rue des guignols", "Lyon", 69000);

        rod.getBooks().add(jee);
        jee.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(jee);
        publisherRepository.save(hachette);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books " + bookRepository.count());
        System.out.println("Number of Publishers " + publisherRepository.count());

        System.out.println(eyrolls);
        System.out.println(eyrolls.toString());

    }
}
