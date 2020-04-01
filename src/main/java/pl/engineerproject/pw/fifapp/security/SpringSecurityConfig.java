package pl.engineerproject.pw.fifapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import javax.sql.DataSource;

@Configuration
public class SpringSecurityConfig
        extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select username, password, active_flag from user where username=?")
                .authoritiesByUsernameQuery("select u.username, r.role_name from user_roles ur left join user u on u.user_id=ur.user_id left join roles r on r.role_id=ur.role_id where username=?");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/webapp/User/user.html","/userDetails/**").hasAnyRole("ADMIN","USER")
                .antMatchers("/usersControls/getAllUsers","/usersControls/activate","/usersControls/activate", "/webapp/Admin/admin.html","/controlPanel","controlPanel").hasRole("ADMIN")
                .antMatchers("/commons/**","/webapp/**").permitAll()
                .antMatchers(HttpMethod.GET,"/", "/home","/leagues/**", "/players/**", "/rounds/**").permitAll()
                .antMatchers("/usersControls/register", "/usersControls/user").permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf()
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
