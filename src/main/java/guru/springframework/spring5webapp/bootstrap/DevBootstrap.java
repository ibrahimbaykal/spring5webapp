package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepositoory;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepositoory bookRepositoory;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepositoory bookRepositoory,
                        PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepositoory = bookRepositoory;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        //Test Publisher
        Publisher publisher= new Publisher();
        publisher.setName("Baykal Yayın Evi");
        publisherRepository.save(publisher);

        //Tolstoy
        Author Tolstoy = new Author("Lev", "Tolstoy");
        Book WarAndPeace = new Book("War and Peace","1234",publisher);
        Tolstoy.getBooks().add(WarAndPeace);
        WarAndPeace.getAuthors().add(Tolstoy);

        authorRepository.save(Tolstoy);
        bookRepositoory.save(WarAndPeace);

        //Dostoyevsky
        Author Dostoyevsky = new Author("Fyodor","Dostoyevsky");
        Book CrimeAndPunishment = new Book("Crime And Punishment",
                "1235",publisher);
        Dostoyevsky.getBooks().add(CrimeAndPunishment);
        CrimeAndPunishment.getAuthors().add(Dostoyevsky);

        authorRepository.save(Dostoyevsky);
        bookRepositoory.save(CrimeAndPunishment);
    }
}
