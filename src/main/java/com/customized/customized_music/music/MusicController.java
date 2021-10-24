package com.customized.customized_music.music;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class MusicController {
    @RequestMapping(value = "music", method = RequestMethod.POST)
    public void show(@RequestBody Map<String, Object> bodyMap) {
        List<String> musicList = (List<String>)bodyMap.get("musicList");
        musicList.forEach(music -> System.out.println(music));
    }
}
