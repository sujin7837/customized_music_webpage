package com.customized.customized_music.music;

import com.customized.customized_music.common.AbstractEntity;
import com.customized.customized_music.cafe.Cafe;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity // music 정보를 데이터베이스에 추가함(곡명, 가수, 앨범명)
public class Music  extends AbstractEntity {
    @ManyToOne  // music과 cafe의 관계가 다 대 일
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_music_cafe"))   // foreignKey의 이름을 지정
    @JsonProperty
    private Cafe cafe;

    @JsonProperty
    private String music_name;

    @JsonProperty
    private String singer;

    @JsonProperty
    private String album_name;

    public Music() {}

    public Music(Cafe cafe, String music_name, String singer, String album_name) {
        this.cafe = cafe;
        this.music_name = music_name;
        this.singer = singer;
        this.album_name = album_name;
    }

    @Override
    public String toString() {
        return "Music{" +
                "cafe=" + cafe +
                ", music_name='" + music_name + '\'' +
                ", singer='" + singer + '\'' +
                ", album_name='" + album_name + '\'' +
                '}';
    }
}
