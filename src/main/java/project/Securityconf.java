package project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import project.services.UserService;

/**
 * Конфигурация безопасности
 */
@EnableWebSecurity
public class Securityconf extends WebSecurityConfigurerAdapter {

    //Сервис работы с пользователями
    @Autowired
    UserService userService;

    /**
     * Игнорирование заданных путей для корректного отображения страниц
     * @param web
     * Внутренний параметр фреймворка
     */
    public void configure(WebSecurity web) {
        web.ignoring()
                .antMatchers(
                        "/css/**", "/fonts/**",
                        "/images/**");
    }

    /**
     *  конфигурация ограничения доступа
     * @param httpSecurity
     *класс для создание ограничений доступа
     * @throws Exception
     * при неудаче
     */
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity
                .csrf()
                .disable()
                .authorizeRequests()
                //Доступ разрешен всем пользователей
                .antMatchers("/").authenticated()
                .anyRequest().authenticated()
                .and()
                //Настройка для входа в систему
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login-error")
                //Перенарпавление на главную страницу после успешного входа
                .defaultSuccessUrl("/")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .logoutSuccessUrl("/login");

    }

    /**
     * Конфигурация авторизации
     * @param auth
     * строитель класса авторизации
     * @throws Exception
     * при неудачной авторизации
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }

    /**
     * Конфигурация бина для хэширования
     * @return
     * класс шифрования
     */
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
