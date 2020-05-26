package com.lin.landao.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lin.landao.entities.NavDirectory;
import com.lin.landao.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Controller
@Slf4j
public class NavigationController {
    @Resource
    private CategoryService categoryService;
    @Resource
    private RedisTemplate<String, String> redisTemplate;

    //json数据交互
    @ResponseBody
    @RequestMapping(value = "/NavDirectory.action")
    public List<NavDirectory> category(HttpServletRequest requset, HttpServletResponse response) throws IOException {

        List<NavDirectory> navDirectories = new LinkedList<>();

//        int count = 5;

        if (redisTemplate.opsForList().index("list1", 0) == null) {
            navDirectories = categoryService.queryNavDirectoryAll();
            for (NavDirectory navDirectory : navDirectories) {
                redisTemplate.opsForList().rightPush("list1", navDirectory.getNavSuffix());
                redisTemplate.opsForList().rightPush("list2", navDirectory.getNavName());
            }
        } else {
            Long size = redisTemplate.opsForList().size("list1");
            System.out.println(size+"____________________________________________________");
            for (int a=1;a<=size;a++ ){
                NavDirectory navDirectory = new NavDirectory();
                navDirectory.setNavSuffix(redisTemplate.opsForList().index("list1", a-1));
                navDirectory.setNavName(redisTemplate.opsForList().index("list2", a-1));
                navDirectories.add(navDirectory);
            }
//            NavDirectory navDirectory1 = new NavDirectory();
//            navDirectory1.setNavSuffix(redisTemplate.opsForList().index("list1", 0));
//            navDirectory1.setNavName(redisTemplate.opsForList().index("list2", 0));
//            NavDirectory navDirectory2 = new NavDirectory();
//            navDirectory2.setNavSuffix(redisTemplate.opsForList().index("list1", 1));
//            navDirectory2.setNavName(redisTemplate.opsForList().index("list2", 1));
//            NavDirectory navDirectory3 = new NavDirectory();
//            navDirectory3.setNavSuffix(redisTemplate.opsForList().index("list1", 2));
//            navDirectory3.setNavName(redisTemplate.opsForList().index("list2", 2));
//            NavDirectory navDirectory4 = new NavDirectory();
//            navDirectory4.setNavSuffix(redisTemplate.opsForList().index("list1", 3));
//            navDirectory4.setNavName(redisTemplate.opsForList().index("list2", 3));
//            NavDirectory navDirectory5 = new NavDirectory();
//            navDirectory5.setNavSuffix(redisTemplate.opsForList().index("list1", -1));
//            navDirectory5.setNavName(redisTemplate.opsForList().index("list2", -1));
//            navDirectories.add(navDirectory1);
//            navDirectories.add(navDirectory2);
//            navDirectories.add(navDirectory3);
//            navDirectories.add(navDirectory4);
//            navDirectories.add(navDirectory5);
        }
        return navDirectories;
    }


}
