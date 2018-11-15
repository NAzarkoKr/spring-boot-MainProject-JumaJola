package epam.springbootmainproject.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class Security extends WebSecurityConfigurerAdapter {


    @Autowired
    @Qualifier("userServiceImpl")
    private UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(); /*бере користувача якого ми ввели*/
        provider.setUserDetailsService(userDetailsService); /*знаходить в БД*/
        provider.setPasswordEncoder(passwordEncoder()); /*розкодовує перевіряє пароль*/
        return provider;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/saveUser","/main.css/**","/main.js/**","/jquery-3.3.1.js/**","/bootstrap.min.css/**").permitAll() /*на них може перейти будь хто*/
                .antMatchers(/*HttpMethod.POST,*/"/createNewCountryButton","/createNewCountryButtonView","/editCountry/{id}","/createNewCityButton","/editCity/{id}").hasRole("ADMIN") /*на них може перейти будь хто*/
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/index") /*сторінка логінації*/
                .successForwardUrl("/successURL")//handle with post mapping in controller
                .failureUrl("/index").permitAll()
                .permitAll()
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/index")
                .permitAll();
    }


}
