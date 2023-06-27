package net.softsociety.spring5.domain;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member implements UserDetails {
  String memberid;
  String memberpw;
  String membername;
  String email;
  String phone;
  String address;
  Boolean enabled;
  String rolename;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    // TODO Auto-generated method stub
    return null;
  } // 유저 역할 가져옴. 필요없어서사용x

  @Override
  public String getPassword() {
    // TODO Auto-generated method stub
    return this.memberpw;
  }

  @Override
  public String getUsername() {
    // TODO Auto-generated method stub
    return this.memberid;
  }

  @Override
  public boolean isAccountNonExpired() {
    // TODO Auto-generated method stub
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    // TODO Auto-generated method stub
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    // TODO Auto-generated method stub
    return true;
  }

  @Override
  public boolean isEnabled() {
    // TODO Auto-generated method stub
    return true;
  }
}
