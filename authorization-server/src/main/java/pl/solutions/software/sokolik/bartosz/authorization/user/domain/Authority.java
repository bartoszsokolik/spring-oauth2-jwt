package pl.solutions.software.sokolik.bartosz.authorization.user.domain;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "user_authorities")
public class Authority implements GrantedAuthority {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "uuid")
  private String uuid = UUID.randomUUID().toString();

  @Column(name = "authority")
  private String authority;

  @ManyToMany(mappedBy = "authorities")
  private Set<Role> roles = new HashSet<>();

  public Authority(String authority) {
    this.authority = authority;
  }
}
