package authwork;

import java.util.Objects;

public class Permission {
    public String role;
    public String name;
    public boolean active;

    public Permission() {
    }

    public Permission(String role, String name, boolean active) {
        this.role = role;
        this.name = name;
        this.active = active;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Permission that = (Permission) o;
        return active == that.active && Objects.equals(role, that.role) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(role, name, active);
    }

    @Override
    public String toString() {
        return "Permission{" +
                "role='" + role + '\'' +
                ", name='" + name + '\'' +
                ", active=" + active +
                '}';
    }
}
