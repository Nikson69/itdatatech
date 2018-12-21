package ru.nikson69.dao.mybatis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.nikson69.dao.mybatis.mappers.TokenRepositoryMapper;
import ru.nikson69.model.PersistentLogin;

import java.util.Date;

@Repository("tokenRepositoryDao")
@Transactional
public class TokenRepositoryImpl implements PersistentTokenRepository {

    @Autowired
    TokenRepositoryMapper mapper;

    static final Logger logger = LoggerFactory.getLogger(TokenRepositoryImpl.class);

    @Override
    public void createNewToken(PersistentRememberMeToken token) {
        logger.info("Creating Token for user : {} via MyBatis", token.getUsername());
        mapper.createNewToken(new PersistentLogin(token));
    }

    @Override
    public void updateToken(String series, String token, Date date) {
        mapper.updateToken(series,token,date);
    }

    @Override
    public PersistentRememberMeToken getTokenForSeries(String s) {
        return mapper.getTokenForSeries(s).getPersistentRememberMeToken();
    }

    @Override
    public void removeUserTokens(String s) {
        mapper.removeUserTokens(s);
    }
}
