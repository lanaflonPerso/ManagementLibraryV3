package mbooks.repository.book;


import mbooks.model.books.Theme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IThemeRepository extends JpaRepository<Theme,Long> {
}
