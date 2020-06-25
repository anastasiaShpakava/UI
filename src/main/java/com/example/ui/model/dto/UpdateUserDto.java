package com.example.ui.model.dto;

import com.example.ui.model.Role;
import com.example.ui.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author Shpakova A.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserDto {
    private Integer id;

    @Size.List({
            @Size(min = 1, message = "First name is too short"),
            @Size(max = 16, message = "First name is too long")
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
