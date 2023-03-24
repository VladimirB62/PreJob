package api.dto;

import groovy.transform.builder.Builder;
import lombok.*;

@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    public Integer id;
    public String title;
    public String videoUrl;
}
