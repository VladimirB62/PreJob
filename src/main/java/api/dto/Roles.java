package api.dto;

import groovy.transform.builder.Builder;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Roles {
    public Integer id;
    public String name;
    public List<Article> articles;
}
