package com.pawelkorniak.facade;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ComnatUser implements UserDetails {
    String login;
    String password;
    Set<Comnat> subscribedComnats = new HashSet<>();

    public ComnatUser(String login) {
        this.login = login;
        this.password = login;
    }

    public boolean isSubscribed(Comnat comnat){
        return subscribedComnats.stream().anyMatch(subscribedComnat -> comnat.equals(subscribedComnat));
    }

    public ComnatUser subscribeToComnat(Comnat comnat) {
        subscribedComnats.add(comnat);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComnatUser that = (ComnatUser) o;
        return login.equals(that.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return "{noop}" + password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
