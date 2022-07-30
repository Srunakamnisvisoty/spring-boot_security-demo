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
}
