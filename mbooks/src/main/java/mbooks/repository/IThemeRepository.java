package mbooks.repository;


import mbooks.model.Theme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IThemeRepository extends JpaRepository<Theme,Long> {
}
