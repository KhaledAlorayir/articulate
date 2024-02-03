package com.example.articulate.validator;


import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;

@Target({FIELD, PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ValueDoesntExistInDb.ValueDoesntExistInDbValidator.class)
public @interface ValueDoesntExistInDb {
    public String message() default "value exist";
    String tableName();

    String fieldName();

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};

    @RequiredArgsConstructor
    class ValueDoesntExistInDbValidator implements ConstraintValidator<ValueDoesntExistInDb, String> {
        public static final String NATIVE_QUERY = "SELECT COUNT(*) FROM %s WHERE upper(%s) = upper(?)";
        private final JdbcTemplate jdbcTemplate;
        private String tableName, fieldName;

        @Override
        public void initialize(ValueDoesntExistInDb constraintAnnotation) {
            this.fieldName = constraintAnnotation.fieldName();
            this.tableName = constraintAnnotation.tableName();
        }

        @Override
        public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
            String sql = NATIVE_QUERY.formatted(tableName, fieldName);
            Integer count = jdbcTemplate.queryForObject(sql, Integer.class, value);
            return count != null && count == 0;
        }
    }
}