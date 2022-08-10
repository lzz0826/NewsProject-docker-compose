package tw.tony.com.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import tw.tony.com.component.PersonnelUserDetailsService;



@Configuration
@EnableWebSecurity
public class SecuityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public UserDetailsService userDetailsService() {
		return new PersonnelUserDetailsService();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	

//	@Autowired
//	private PersonnelLogoutSuccessHandler personnelSuccessHandler;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService())
		    .passwordEncoder(passwordEncoder());
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		// 设置拦截忽略文件夹，可以对静态资源放行
		web.ignoring().antMatchers("/css/**", "/js/**", "/fonts/**", "/images/**", "/lib/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		
		.csrf().disable();
//		.sessionManagement()
//		.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
//		.maximumSessions(1);

	    http.authorizeRequests()
	    		.antMatchers("/indexAdmin").hasRole("MDMIN")
	    		.antMatchers("/cretaeNews").hasRole("MDMIN")
	    		.antMatchers("/newsAdmin").hasRole("MDMIN")
	    	
	            .and()
	            .formLogin()
	            	.loginPage("/login")
	            	.loginProcessingUrl("/login_form")
	            	.defaultSuccessUrl("/indexAdmin")
	            	.failureUrl("/login?error=true")
	            	.permitAll()
	            .and()
	            .logout()
	            .logoutUrl("/perform_logout")
	            .logoutSuccessUrl("/login")
//	            .logoutSuccessHandler(personnelSuccessHandler)
	            .permitAll();

		http.headers().frameOptions().sameOrigin();
	}
}
