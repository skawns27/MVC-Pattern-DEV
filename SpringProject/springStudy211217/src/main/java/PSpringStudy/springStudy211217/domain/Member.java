package PSpringStudy.springStudy211217.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    컬럼네임으로 따로 설정 가능 @columnName
    private String Name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        Name = name;
    }
}

