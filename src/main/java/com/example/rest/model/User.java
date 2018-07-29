package com.example.rest.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Entity
@Table(name = "users", uniqueConstraints=@UniqueConstraint(columnNames={"name"}))
@EqualsAndHashCode
@ToString
public class User implements Serializable, UserDetails {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Getter
    @Setter
    private Integer id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    // @JsonIgnore
    private String password;

    @Override
    @JsonIgnore
    public String getUsername() {
        return this.getName();
    }

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
       return true;
    }
  
    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
       return true;
    }
  
    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
       return true;
    }
  
    @Override
    @JsonIgnore
    public boolean isEnabled() {
       return true;
    }
}