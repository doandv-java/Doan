package haui.doan.stores.framework;

import haui.doan.stores.business.service.UserDetailCustomService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * The configuration of security of web use spring security
 *
 * @author Duong Van Doan
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * The user detail service of user custom for login
     */
    private final UserDetailCustomService service;

    /**
     * The configure of user of http security of web
     *
     * @param http the request http send to web server
     * @throws Exception the exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().
                authorizeRequests()
                .antMatchers("/webjars/**", "/css/**", "/js/**", "/images/**", "/libs/**").permitAll()
                .antMatchers("/checkUser", "/changePassword").permitAll()
                .antMatchers("/admin/**").access("hasAnyRole('ADMIN','EMPLOYEE')")
                .antMatchers("/home/profile",
                        "home/orders").access("hasAnyRole('ADMIN','EMPLOYEE','CUSTOMER')")
                .anyRequest().authenticated()
                .and().formLogin()
                .loginPage("/login")
                .permitAll().defaultSuccessUrl("/checkUser")
                .and().logout()
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout")
                .permitAll().and().exceptionHandling().accessDeniedPage("/403");
    }

    /**
     * Set provider with service custom and BCrypt password encoder
     *
     * @param auth the provider of auth
     * @throws Exception the exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }


    /**
     * The create instance encode password to BCrypt password
     *
     * @return the BCrypt password encoder
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Create a provider of auth
     *
     * @return Auth provider
     */
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(service);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

}
