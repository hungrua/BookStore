package bookshop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import bookshop.service.impl.CustomUserDetailsService;


@Configuration
@EnableWebSecurity
public class Sercurity extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private CustomUserDetailsService userDetailsService;
	@Override
	protected void configure (HttpSecurity http) throws Exception{
		http.cors().and().csrf().disable();
		http
         .authorizeRequests()
             .antMatchers("/user/*","/book/condition","/book/*","/cart/add","/cart/*",
            		 "/cart/delete/*","/comment/book/*","/comment/add","/comment/delete/*",
            		 "/comment/edit","/bill/*","/bill/delete/*","/bill/previous/*","/favourite/delete/*",
            		 "/favourite/*").permitAll();

	}
	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth ) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}	
	
}
