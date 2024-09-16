package hello.itemservice.domain.information;

import lombok.Data;

@Data
public class InformationDTO {
    private long id;
    private String name;
    private String introduce;
    private Integer nameNumber;

    public InformationDTO() {

    }

    public InformationDTO(String name, String introduce, Integer nameNumber) {
        this.name = name;
        this.introduce = introduce;
        this.nameNumber = nameNumber;
    }
}


