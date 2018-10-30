package epam.springbootmainproject.models;

import epam.springbootmainproject.models.enums.SightTypeEnum;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Sight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameSight;
    @Enumerated(EnumType.STRING)
    private SightTypeEnum type;
    private int minMoney;

    public Sight(String nameSight, SightTypeEnum type, int minMoney) {
        this.nameSight = nameSight;
        this.type = type;
        this.minMoney = minMoney;
    }
}
