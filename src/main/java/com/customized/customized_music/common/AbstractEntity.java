package com.customized.customized_music.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Objects;

@MappedSuperclass   // Music, Cafe의 부모 클래스로 사용
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity {
    @Id // Database의 Primary Key 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // import.sql 파일에서 ID 값을 지정해주지 않으면 오류가 발생하므로, ID 값을 자동 생성하도록 하는 코드
    @JsonProperty   // getter 메소드를 이용할 수도 있으나 대신 JsonProperty 애노테이션을 사용함
    private Long id;    // 값이 자동으로 1씩 증가됨

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractEntity that = (AbstractEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "AbstractEntity{" +
                "id=" + id +
                '}';
    }
}
