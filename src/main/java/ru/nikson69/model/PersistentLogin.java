package ru.nikson69.model;

import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;

import java.io.Serializable;
import java.util.Date;

public class PersistentLogin implements Serializable{


	private String series;


	private String username;
	

	private String token;
	

	private Date last_used;

	public PersistentLogin(){}

	public PersistentLogin(PersistentRememberMeToken token){
		this.series = token.getSeries();
		this.username = token.getUsername();
		this.token = token.getTokenValue();
		this.last_used = token.getDate();
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getLast_used() {
		return last_used;
	}

	public void setLast_used(Date last_used) {
		this.last_used = last_used;
	}
	
	public PersistentRememberMeToken getPersistentRememberMeToken(){
		return new PersistentRememberMeToken(username,series,token,last_used);
	}
}
