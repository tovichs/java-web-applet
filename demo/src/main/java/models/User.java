package models;

import lombok.*;

@Getter @Setter @AllArgsConstructor
public class User
{
    private String username;
    private String password;
    private String creditCardNumber;
    private String email;
    private String phoneNumber;

}
