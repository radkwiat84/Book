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
import org.springframework.security.web .util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private BCryptPasswordEncoder bcp;

	@Autowired
	// do autoryzaji, nawiązania połączeń, wykonywania skryptów
	private DataSource ds;

	/*
	 * Przy pomocy tej zmiennej będę się posługiwać zapytaniem o użytkownika
	 * 
	 * w adnotacji value mapujemy to co jest w application.properties (czyli zostaje
	 * to pobrane z appli*.prop* i zmapowane na tą zmienną
	 */
	@Value("${spring.queries.users-query}")
	private String usersQuery;

	/*
	 * Tą zmienną posłużę się do zapytania o rolę.
	 */
	@Value("${spring.queries.roles-query}")
	private String rolesQuery;

	/*
	 * poniżej pierwsza metoda konfiguracyjna. Autentykacja poprzez zapytanie
	 * (usersQuery), poprzez rolę użytkownika itd.
	 */

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().usersByUsernameQuery(usersQuery).authoritiesByUsernameQuery(rolesQuery).dataSource(ds)
				.passwordEncoder(bcp);
	}

	@Override
	protected void configure(HttpSecurity httpSecur) throws Exception {
		// nie trzeba się logować na stronie głównej
		httpSecur.authorizeRequests().antMatchers("/").permitAll().antMatchers("/login").permitAll()
				.antMatchers("/register").permitAll()
				// musi być autentykacja typu ADMIN (rola Admin)
				.antMatchers("/admin/**").hasAnyAuthority("ADMIN").anyRequest().authenticated().and().csrf().disable()
				// jeżeli logowanie jest błędne to przekazywany jest ten url
				.formLogin().loginPage("/login").failureUrl("/login?error=true")
				// do logowania chwycimy email i hasło = > i jak bangla to na stronę główną
				// jak nie zabangla to na stronę login z parametre error=true.
				.defaultSuccessUrl("/").usernameParameter("email").passwordParameter("password")
				// po wylogowaniu nowy matcher logout
				.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/")
				// kiedy chcemy się pod inne url dostać niż te zdefiniowane to jest denied
				.and().exceptionHandling().accessDeniedPage("/denied");

	}

	@Override
	public void configure(WebSecurity webSecur) throws Exception {
		//SpringSecurity ignoruje wszystko co jest odczytywane z tych katalogów
		webSecur.ignoring().antMatchers("/resources/**", "/statics/**", "/css/**", "/js/**", "/images/**");
	}

}
