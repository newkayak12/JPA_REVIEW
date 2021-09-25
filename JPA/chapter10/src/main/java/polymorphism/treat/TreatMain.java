package polymorphism.treat;

import polymorphism.Album_Polymorphism;
import polymorphism.Book_Polymorphism;
import polymorphism.Item_Polymorphism;
import polymorphism.Movie_Polymorphism;

import javax.persistence.*;

public class TreatMain {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate");
    static EntityManager em = emf.createEntityManager();
    static EntityTransaction tx = em.getTransaction();

    public static void main(String[] args) {
    treat();
    }
    public static void treat(){
        Album_Polymorphism album = new Album_Polymorphism();
        album.setSinger("BB");
        album.setName("BB 1st");
        album.setPrice(10000);
        album.setStockQuantity(22);

        Book_Polymorphism book = new Book_Polymorphism();
        book.setAuthor("cd");
        book.setName("sher");
        book.setPrice(10022);
        book.setIsbn("123-2222B");
        book.setStockQuantity(2);

        Movie_Polymorphism movie = new Movie_Polymorphism();
        movie.setActor("bene");
        movie.setName("dr");
        movie.setPrice(30000);
        movie.setDirector("martin");
        movie.setStockQuantity(0);

        tx.begin();
        em.persist(album);
        em.persist(movie);
        em.persist(book);
        tx.commit();

        TypedQuery<Item_Polymorphism> query =  em.createQuery("SELECT i from Item_Polymorphism i where treat (i as Movie_Polymorphism).actor = :Actor", Item_Polymorphism.class).setParameter("Actor", "bene");
        Item_Polymorphism item = query.getSingleResult();
        System.out.println(item);
        System.out.println(item.getPrice());
    }

}
