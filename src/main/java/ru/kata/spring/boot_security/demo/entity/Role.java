package ru.kata.spring.boot_security.demo.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import ru.kata.spring.boot_security.demo.entity.parent.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table
public class Role extends BaseEntity implements GrantedAuthority {

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"),
            foreignKey = @ForeignKey(name = "fk_role_to_user")
    )
    private List<User> userList;

    @Override
    public String getAuthority() {
        return getName();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Role role = (Role) obj;
        return getId().equals(role.getId()) && getName().equals(role.getName());
    }

    @Override
    public int hashCode() {
        int hash = 11;
        hash = 31 * hash + getId().intValue();
        hash = 31 * hash + (getName() == null ? 0 : getName().hashCode());
        return hash;
    }
}
