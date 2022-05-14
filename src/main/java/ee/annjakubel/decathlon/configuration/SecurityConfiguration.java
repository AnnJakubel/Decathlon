package ee.annjakubel.decathlon.configuration;

import ee.annjakubel.decathlon.authentication.TokenParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Value("${token.key}")
    private String key;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);

        //TODO: authorizeRequests k6ik p2ringud vaha lubada

        TokenParser tokenParser = new TokenParser(authenticationManager());
        tokenParser.setKey(key);

        http.
                cors().and().headers().xssProtection().disable().and().csrf().disable()
                .addFilter(tokenParser)
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/decathlon/athletes").permitAll()
                .antMatchers(HttpMethod.POST, "/decathlon/signup").permitAll()
                .antMatchers(HttpMethod.POST,"/decathlon/login").permitAll()
                .anyRequest().authenticated();
    }
}
