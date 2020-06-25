package com.example.ui.model.dto;

import com.example.ui.annotation.UniqueUsername;
import com.example.ui.model.Role;
import com.example.ui.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author Shpakova A.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationUserDto {

    @Size.List({
            @Size(min = 3, message = "Username is too short"),
            @Size(max = 16, message = "Username is too long")
    })
    @UniqueUsername
    private String userName;

    @Size.List({
            @Size(min = 3, message = "Password is too short"),
            @Size(max = 16, message = "Password is too long")
    })
    @Pattern(regexp = "(?=.*\\d)(?=.*[a-zA-Z])(?!.*\\s).*$", message = "Password must contains at least one digit, one letter, Latin only.")
    private String password;

    @Size.List({
            @Size(min = 1, message = "First name is too short"),
            @Size(max = 16, message = "Firat name is too long")
    })
    @Pattern(regexp = "^[a-zA-Z]+$", message = "First name must contains only latin letters.")
    private String firstName;

    @Size.List({
            @Size(min = 1, message = "First name is too short"),
            @Size(max = 16, message = "Firat name is too long")
    })
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Last name must contains only latin letters.")
    private String lastName;

    private Role role;

    private Status status;

}
