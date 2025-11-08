package com.github.lexya.userservice.service.specification;

import com.github.lexya.userservice.service.dto.UserFilterDTO;
import com.github.lexya.userservice.model.User;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecifications {
    public static Specification<User> searchByStringFieldEquals(String findField, String nameField) {
        // lambda-expression
        return (root, query, cb) -> {
            if (findField == null || findField.isEmpty()) return null;
            return cb.equal(cb.lower(root.get(nameField)), findField.toLowerCase());
        };
    }

    public static Specification<User> buildNameAndSurnameSpecification(UserFilterDTO filter){
        return Specification.allOf(searchByStringFieldEquals(filter.getUserName(), "userName"),
                searchByStringFieldEquals(filter.getUserSurname(), "surname"));
    }
}
