package dto;

import lombok.*;

@Setter
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Superhero {
    private Integer id;
    private String fullName;
    private String birthDate;
    private String city;
    private String mainSkill;
    private String gender;
    private String phone;
}
