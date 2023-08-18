package shop.mtcoding.ajax.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor // db조회->pc에 category 객체 생성->빈생성자를 호출 new할때 무조건 빈생성자때림
@Setter
@Getter
@Table(name = "tech_tb")
@Entity // 하이버네이트가 관리
public class Tech {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    private String name; // 스프링, 자바, 자바스크립트, React, HTML

    // @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Category category; // ex>백엔드:1, tech:n

}
