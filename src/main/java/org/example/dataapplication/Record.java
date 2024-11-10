package org.example.dataapplication;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Setter
@Getter
@AllArgsConstructor
public class Record {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;

}
