package xyz.ruhshan.common.reqres;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationRequest implements Serializable {
    private String username;
    private String email;
    private String mobileNumber;
}
