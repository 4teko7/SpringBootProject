package com.teko7.validator;



import com.teko7.config.Config;
import com.teko7.entities.UserEntity;
import com.teko7.service.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator  {

	private Service getService() {return new Service();}
	private Config getConfig() {return new Config();}
	
	private Config config = getConfig();
    private Service service = getService();

    @Override
    public boolean supports(Class<?> aClass) {
        return UserEntity.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserEntity user = (UserEntity) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if (user.getUsername().length() < 6 || user.getUsername().length() > 32) {
            errors.rejectValue("username", "Size.user.username");
        }
        if (service.getByUsername("user",user.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate.user.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.user.password");
        }
        
        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.user.passwordConfirm");
        }
        
    }
    
}






/*
 * 
 * package com.teko7.validator;



import com.teko7.config.Config;
import com.teko7.entities.UserEntity;
import com.teko7.service.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator  {

	private Service getService() {return new Service();}
	private Config getConfig() {return new Config();}
	
	private Config config = getConfig();
    private Service service = getService();

    @Override
    public boolean supports(Class<?> aClass) {
        return UserEntity.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserEntity user = (UserEntity) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if (user.getUsername().length() < 6 || user.getUsername().length() > 32) {
            errors.rejectValue("username", config.getSizeUserUsername());
        }
        if (service.getByUsername("user",user.getUsername()) != null) {
            errors.rejectValue("username", config.getDuplicateUserUsername());
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", config.getSizeUserPassword());
            
        }
        

    }
    
}

 * 
 */

