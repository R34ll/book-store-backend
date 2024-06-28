import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.book_store.entity.Book;

@RestController
@RequestMapping("/books")
public class BookController {
    
    @GetMapping("/")
    List<Book> listAll(){}

    @GetMapping("/{id}")
    List<Book> listById(@PathVariable long id){}


    @PutMapping("/new")
    Book newBook(){}

    @PutMapping("/update/{id}")
    Book updateBook(@PathVariable long id){}

    @DeleteMapping("/remove/{id}")
    String removeBook(@PathVariable long id){} // Change return to Json


}
