package vn.hoidanit.laptopshop.service.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

// Khi gặp @StrongPassword, hãy dùng class StrongPasswordValidator để kiểm tra.
@Constraint(validatedBy = StrongPasswordValidator.class)
// Phạm vi hoạt động của annotation => ở đây là một trường , và method
@Target({ ElementType.METHOD, ElementType.FIELD })
// Nó quy định: Annotation tồn tại đến thời điểm nào?
@Retention(RetentionPolicy.RUNTIME)
@Documented
// Tôi đang định nghĩa một annotation mới tên là StrongPassword.
public @interface StrongPassword {
    String message() default "Must be 8 characters long and combination of uppercase letters, lowercase letters, numbers, special characters.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
