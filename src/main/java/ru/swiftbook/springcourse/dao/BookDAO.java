package ru.swiftbook.springcourse.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.swiftbook.springcourse.models.Book;

import java.util.List;

@Component
public class BookDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> index() {
        return jdbcTemplate.query("SELECT * FROM book", new BeanPropertyRowMapper<>(Book.class));
    }

    public Book show(int id) {
        return jdbcTemplate.query("SELECT * FROM book WHERE id=?", new Object[]{id},
                        new BeanPropertyRowMapper<>(Book.class)).stream()
                .findAny().orElse(null);
    }

    public void save(Book book) {
        jdbcTemplate.update("INSERT INTO book(title, author, year) VALUES (?, ?, ?)",
                book.getTitle(), book.getAuthor(), book.getYear());
    }

    public void update(int id, Book book) {
        jdbcTemplate.update("UPDATE book SET title=?, author=?, year=? WHERE id=?",
                book.getTitle(), book.getAuthor(), book.getYear(), id);
    }

    public void update(int id) {
        jdbcTemplate.update("UPDATE book SET person_id = null WHERE id=?", id);
    }

    public void updatePerson(int personId, int id) {
        jdbcTemplate.update("UPDATE book SET person_id = ? WHERE id=?", personId, id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM book WHERE id=?", id);
    }

    public List<Book> showBooksByPerson(int id) {
        return jdbcTemplate.query("select * from book b\n" +
                        "join person p on b.person_id = p.id\n" +
                        "where p.id =?", new Object[]{id},
                        new BeanPropertyRowMapper<>(Book.class));
    }
}
