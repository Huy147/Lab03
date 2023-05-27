package trinhconghuy.Lab03.Validator;

import trinhconghuy.Lab03.Validator.annotation.ValidCategoryId;
import trinhconghuy.Lab03.entity.Category;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidCategoryIdValidator implements ConstraintValidator<ValidCategoryId, Category> {
    @Override
    public boolean isValid(Category category, ConstraintValidatorContext context){
        return category != null && category.getId() != null;
    }
}
