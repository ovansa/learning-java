package authwork;

import java.util.*;

public class Authorization {
    public List<Permission> permissions;
    public List<User> users;

    public Authorization(List<Permission> permissions, List<User> users) {
        this.permissions = permissions;
        this.users = users;
    }


    public Collection<String> listPermissions(int userId) {
        Optional<User> user = users.stream().filter(u -> u.id == userId).findFirst();

        if (user.isPresent()) {
            User foundUser = user.get();
            List<String> userRoles = foundUser.getRoles();
            List<String> activePermissions = new ArrayList<>();

            for (Permission permission: permissions) {
                if (userRoles.contains(permission.role) && permission.active) {
                    activePermissions.add(permission.name);
                }
            }

            return activePermissions;
        } else {
            System.out.println("User with ID " + userId + " not found.");
            return Collections.emptyList();
        }
    }

    public boolean checkPermitted(String permissionName, int userId) {
        // Check that permission name exists, Return false if it exists not
        // Retrieve roles in a user
        // Roles are ['Admin', 'Viewer']
        // Permission is {role: 'Admin', name: 'permissionName', isActive}
        // Check that the permission role exists in the role of the user

        Optional<Permission> permission = permissions.stream().filter(p -> Objects.equals(p.name, permissionName)).findFirst();
        if (permission.isPresent()) {
            Permission foundPermission = permission.get();

            if (!foundPermission.isActive()) {
                return false;
            }

            Optional<User> user = users.stream().filter(u -> u.id == userId).findFirst();

            if(user.isPresent()) {
                User foundUser = user.get();
                List<String> userRoles = foundUser.getRoles();

                return userRoles.contains(foundPermission.getRole());
            }
        }

        return false;
    }
}
