package com.zxq.config;

import com.zxq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 定义授权规则，首页所有人可以访问，其他页面需对应的用户才能访问

        http.authorizeRequests().antMatchers("/").permitAll();
                //.antMatchers("/admin/**").hasRole("student");

        http.formLogin()
                .usernameParameter("da")
                .passwordParameter("123456")
                .loginPage("/admin/login")//登录页面指向我们自己的登录页面
                .loginProcessingUrl("/login"); // 登陆表单提交请求
        http.rememberMe().rememberMeParameter("remember");;//开启记住我功能并设置参数
        http.csrf().disable();//关闭csrf功能:跨站请求伪造,默认只能通过post方式提交logout请求
        http.logout().logoutSuccessUrl("/");//开启注销功能，并制定注销成功后跳转到首页

        //http.sessionManagement().maximumSessions(1).expiredUrl("admin/login");
    }
    //定义哪些用户拥有哪些权限
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //模拟从数据库中拿数据，具体需要自己去定义，需要对密码进行加密才能授权成功
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("Bridge").password(new BCryptPasswordEncoder().encode("123123")).roles("student");

    }

}
