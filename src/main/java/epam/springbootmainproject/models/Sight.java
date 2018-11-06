package epam.springbootmainproject.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Sight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameSight;
    private String type;
    private int minMoney;
    private String description;

    public Sight(String nameSight, String type, int minMoney, String description) {
        this.nameSight = nameSight;
        this.type = type;
        this.minMoney = minMoney;
        this.description = description;
    }
}
