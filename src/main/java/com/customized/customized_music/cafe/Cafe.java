package com.customized.customized_music.cafe;

import com.customized.customized_music.common.AbstractEntity;
import com.customized.customized_music.music.Music;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import java.util.List;

@Entity // Database와 매핑하는 어노테이션
public class Cafe extends AbstractEntity {
    @Column(nullable = false, length = 20, unique = true)
    // cafe_id 값이 널 값이 될 수 없도록 지정
    // unique = true : cafe_id는 유일해야 한다(똑같은 값이 들어올 수 없다)
    @JsonProperty
    private Long cafe_id;

    @JsonProperty
    private String cafe_name;

    @JsonProperty
    private String cafe_img1;

    @JsonProperty
    private String cafe_img2;

    @JsonProperty
    private String cafe_img3;

    @OneToMany(mappedBy = "cafe")   // cafe가 musicList를 가지고 있도록 함
    // mappedBy = "ManyToOne에서의 필드의 이름"
    @OrderBy("cafe_id DESC")
    private List<Music> musicList;

    public Long getCafe_id() {
        return cafe_id;
    }

    public void setCafe_id(Long cafe_id) {
        this.cafe_id = cafe_id;
    }

    public String getCafe_name() {
        return cafe_name;
    }

    public void setCafe_name(String cafe_name) {
        this.cafe_name = cafe_name;
    }

    public String getCafe_img1() {
        return cafe_img1;
    }

    public void setCafe_img1(String cafe_img1) {
        this.cafe_img1 = cafe_img1;
    }

    public String getCafe_img2() {
        return cafe_img2;
    }

    public void setCafe_img2(String cafe_img2) {
        this.cafe_img2 = cafe_img2;
    }

    public String getCafe_img3() {
        return cafe_img3;
    }

    public void setCafe_img3(String cafe_img3) {
        this.cafe_img3 = cafe_img3;
    }

    @Override
    public String toString() {
        return "Cafe{" +
                "cafe_id=" + cafe_id +
                ", cafe_name='" + cafe_name + '\'' +
                ", cafe_img1='" + cafe_img1 + '\'' +
                ", cafe_img2='" + cafe_img2 + '\'' +
                ", cafe_img3='" + cafe_img3 + '\'' +
                '}';
    }
}


