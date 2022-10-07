package az.elgunsh.springsecuritying.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AccessTokenDto {
    private String accessToken;
}
