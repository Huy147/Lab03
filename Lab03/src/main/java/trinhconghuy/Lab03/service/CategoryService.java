package trinhconghuy.Lab03.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trinhconghuy.Lab03.entity.Category;
import trinhconghuy.Lab03.repository.ICategoryRepository;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;

    public List<Category> listAll() {
        return categoryRepository.findAll();
    }

    public void save(Category category) {
        categoryRepository.save(category);
    }

    public Category get(long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public void delete(long id) {
        categoryRepository.deleteById(id);
    }
}