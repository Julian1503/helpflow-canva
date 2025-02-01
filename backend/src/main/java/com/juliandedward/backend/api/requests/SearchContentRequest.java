    package com.juliandedward.backend.api.requests;

    import jakarta.validation.constraints.NotBlank;
    import jakarta.validation.constraints.NotEmpty;
    import jakarta.validation.constraints.Size;

    import java.util.Collection;

    public record SearchContentRequest(
            @NotBlank(message = "Title cannot be blank")
            @Size(max = 255, message = "Title must be at most 255 characters") String title,
            @NotBlank(message = "Type cannot be blank")String type,
            @NotEmpty(message = "Tags cannot be empty") Collection<
                    @NotBlank(message = "Each tag must not be blank") String> tags) {
    }
