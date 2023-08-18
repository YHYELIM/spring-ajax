package shop.mtcoding.ajax.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor // db조회->pc에 category 객체 생성->빈생성자를 호출 new할때 무조건 빈생성자때림
@Setter
@Getter
@Table(name = "category_tb")
@Entity // 하이버네이트가 관리
public class Category {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    private String name;// 백엔드, 프론트엔드, DBA

    @Builder
    public Category(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

}
