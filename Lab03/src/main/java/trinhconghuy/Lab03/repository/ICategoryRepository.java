package trinhconghuy.Lab03.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trinhconghuy.Lab03.entity.Category;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
