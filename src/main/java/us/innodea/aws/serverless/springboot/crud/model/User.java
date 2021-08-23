package us.innodea.aws.serverless.springboot.crud.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 8166913065696134416L;
    private String id;
    private String firstName;
    private String lastName;
}
