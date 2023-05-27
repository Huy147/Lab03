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

    public List<Category> getAllCategories() { return categoryRepository.findAll(); }

    public Category getCategoyById(Long id) { return categoryRepository.findById(id).orElse(null); }

    public Category saveCategory(Category category) { return categoryRepository.save(category); }

    public void deleteCategory(Long id) { categoryRepository.deleteById(id); }
}