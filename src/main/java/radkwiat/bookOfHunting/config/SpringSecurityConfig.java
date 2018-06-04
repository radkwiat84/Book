package radkwiat.bookOfHunting.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private BCryptPasswordEncoder bcp;

	@Autowired
	private DataSource ds;

	@Value("${spring.queries.users-query}")
	private String usersQuery;

	@Value("${spring.queries.roles-query}")
	private String rolesQuery;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().usersByUsernameQuery(usersQuery).authoritiesByUsernameQuery(rolesQuery).dataSource(ds)
				.passwordEncoder(bcp);
	}

	@Override
	protected void configure(HttpSecurity httpSecur) throws Exception {
		httpSecur.authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/login").permitAll()
				.antMatchers("/register").permitAll()
				.antMatchers("/adduser").permitAll()
				.antMatchers("/admin/**").hasAnyAuthority("ADMIN")
				.anyRequest().authenticated()
				.and().csrf().disable()
				.formLogin().loginPage("/login")
				.failureUrl("/login?error=true")
				.defaultSuccessUrl("/").usernameParameter("email")
				.passwordParameter("password")
				.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/")
				.and().exceptionHandling().accessDeniedPage("/denied");

	}

	@Override
	public void configure(WebSecurity webSecur) throws Exception {
		webSecur.ignoring().antMatchers("/resources/**", "/statics/**", "/css/**", "/js/**", "/images/**");
	}

}
