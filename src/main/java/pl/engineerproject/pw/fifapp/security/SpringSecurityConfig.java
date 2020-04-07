package pl.engineerproject.pw.fifapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import javax.sql.DataSource;

@Configuration
@EnableAutoConfiguration
@EnableWebSecurity
public class SpringSecurityConfig
        extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.addFilterBefore(new FilterCors(), ChannelProcessingFilter.class);
        http.csrf().disable();
        http.httpBasic();
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/", "/home","/**");
        http.authorizeRequests().antMatchers(HttpMethod.OPTIONS, "/", "/home","/**");
        http.authorizeRequests().antMatchers("/usersControls/register", "/usersControls/user","/webapp/User/user.html","/userDetails/**").hasAnyRole("ADMIN","USER");
        http.authorizeRequests().antMatchers("/usersControls/getAllUsers","/usersControls/activate","/usersControls/deactivate", "/webapp/Admin/admin.html","/controlPanel").hasRole("ADMIN");

    }

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




    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
