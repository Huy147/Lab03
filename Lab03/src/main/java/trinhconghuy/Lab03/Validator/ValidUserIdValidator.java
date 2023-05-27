package trinhconghuy.Lab03.Validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import trinhconghuy.Lab03.Validator.annotation.ValidUserId;
import trinhconghuy.Lab03.entity.User;

public class ValidUserIdValidator implements ConstraintValidator<ValidUserId, User> {
    @Override
    public boolean isValid(User user, ConstraintValidatorContext context){
        if(user==null){
            return true;
        }
        return user.getId()!=null;
    }
}