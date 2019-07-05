package cn.bored.service.provider.pal.controller;

import cn.bored.domain.Friends;
import cn.bored.service.provider.pal.service.PalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description
 * @author: Ding
 * @create: 2019-07-03 14:54
 **/
@RestController
@RequestMapping("/Pal")
public class PalController {

    @Autowired
    private PalService palService;

    @GetMapping("/GetuserPal/{id}")
    public List<Friends> GetuserPal(@PathVariable(value = "id") Long id){
        return palService.getFriendsdDecided(id);
    }
    @PostMapping("/addPal")
    public int AddPAl(@RequestParam Long id,String Friendsid){
        return  palService.Friendsadd(id,Friendsid);
    }
    @PostMapping("/delPal")
    public int delPal(@RequestParam Long id,String Friendsid){
        return  palService.Friendsdel(id,Friendsid);
    }

}
