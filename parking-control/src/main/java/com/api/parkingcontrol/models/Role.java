package com.api.parkingcontrol.models;

import com.api.parkingcontrol.enums.RoleName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_ROLE")
public class Role implements GrantedAuthority, Serializable {

    private static final long serialVersionUID = 1L;
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private RoleName roleName;

    @ManyToMany(mappedBy="roles")
    private List<UserModel> users;

    @Override
    public String getAuthority() {
        return this.roleName.toString();
    }
}
