package pl.solutions.software.sokolik.bartosz.authorization.user.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@Data
@EqualsAndHashCode(of = "uuid")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_roles")
public class Role implements GrantedAuthority {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  private Long id;

  @Column(name = "uuid")
  private String uuid = UUID.randomUUID().toString();

  @Column(name = "role")
  private String role;

  @ManyToMany(mappedBy = "roles")
  private Set<User> users = new HashSet<>();

  @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
  @JoinTable(name = "roles_authorities",
      joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))
  private Set<Authority> authorities = new HashSet<>();

  public Role(String role, Set<Authority> authorities) {
    this.role = role;
    this.authorities = authorities;
  }

  @Override
  public String getAuthority() {
    return getRole();
  }
}
