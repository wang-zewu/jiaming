package com.bee.sample.ch1.controller;

import com.bee.sample.ch1.comfig.EnvConfig;
import com.bee.sample.ch1.dao.UserDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HelloworldController {

    private Log log = LogFactory.getLog(HelloworldController.class);

    @Autowired
    private UserDao userDao;
    @Autowired
    private EnvConfig envConfig;
    @Autowired
    private StringRedisTemplate redisTemplate;
    @RequestMapping("/say.html")
    public @ResponseBody String say(){
        System.out.println("userDao.getcount====   "+userDao.getcount());
        log.info("userDao.getcount====   "+userDao.getcount());
        log.info(envConfig.getServerPort());
        return "wang_testdddd3ff";
    }

    @RequestMapping("/userdetail.html")
    public String foo(String id, Model model){
        model.addAttribute("name", "hello,word");
        return "/admin/userInfo.btl";
    }

    /**
     * 仅仅允许来自domain2.com的跨域访问,并且限定反问路径为/api,方法是post或者get
     * @param registry
     */
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/api/**")
                .allowedOrigins("http://domain2.com")
                .allowedMethods("POST", "GET");
        System.out.println(111);
    }

    @RequestMapping("/setget.html")
    @ResponseBody
    public String env(String para) throws Exception{
        redisTemplate.opsForValue().set("testenv", para);
        String str = redisTemplate.opsForValue().get("testenv");
        return str;
    }

    @RequestMapping("/putsesson.html")
    @ResponseBody
    public String putSession(HttpServletRequest request){
        HttpSession session = request.getSession();
        log.info(session.getClass());
        log.info(session.getId());
        String name = "xiandafu";
        session.setAttribute("user", name);
        return "hey,"+name;
    }

}
