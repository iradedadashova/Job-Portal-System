package org.example.jobportal.Service;

import lombok.RequiredArgsConstructor;
import org.example.jobportal.Model.DTO.Request.CategoryRequest;
import org.example.jobportal.Model.DTO.Response.CategoryResponse;
import org.example.jobportal.Model.Entity.Category;
import org.example.jobportal.Repository.CategoryRepository;
import org.example.jobportal.mapper.CategoryMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CatagoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryResponse create(CategoryRequest request) {
        Category category = categoryMapper.toEntity(request);
        return categoryMapper.toResponse(categoryRepository.save(category));
    }

    public CategoryResponse getById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        return categoryMapper.toResponse(category);
    }

    public List<CategoryResponse> getAll() {
        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::toResponse)
                .collect(Collectors.toList());
    }

    public CategoryResponse update(Long id, CategoryRequest request) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        category.setCategoryName(request.getCategoryName());
        return categoryMapper.toResponse(categoryRepository.save(category));
    }
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
}
