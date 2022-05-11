package com.example.sii.user;

import com.example.sii.booking.Booking;
import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "user", uniqueConstraints = {
    @UniqueConstraint(columnNames = "username"),
    @UniqueConstraint(columnNames = "email")
})
public class User {

  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(
      name = "UUID",
      strategy = "org.hibernate.id.UUIDGenerator"
  )
  @Column(name = "id")
  private UUID id;

  @NotBlank
  @Size(max = 30)
  @Column(name = "username")
  private String username;

  @NotBlank
  @Size(max = 120)
  @Column(name = "email")
  private String email;

  @OneToMany(mappedBy = "user")
  private List<Booking> booking;

  public User(String username, String email) {
    this.username = username;
    this.email = email;
  }
}
