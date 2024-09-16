package hello.itemservice.domain.information;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateInfoParamDTO {
    private String name;
    private String introduce;
    private Integer nameNumber;
}
