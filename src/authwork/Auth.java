package authwork;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Hello world!
 *
 */
public class Auth
{
    public static void main( String[] args )
    {
        Permission p1 = new Permission("Admin", "View Orders", true);
        Permission p2 = new Permission("Admin", "Block User Account", true);
        Permission p3 = new Permission("Editor", "Edit Articles", true);
        Authorization authorization = getAuthorization(p1, p2, p3);
        System.out.println("Permissions for User ID 1:");
        Collection<String> user1Permissions = authorization.listPermissions(1);
        System.out.println(user1Permissions);
        boolean userHasPermission = authorization.checkPermitted("View Articles", 1);
        System.out.println("User has permission " + userHasPermission);
    }

    private static Authorization getAuthorization(Permission p1, Permission p2, Permission p3) {
        Permission p4 = new Permission("Viewer", "View Articles", true);
        Permission p5 = new Permission("Admin", "Delete Articles", false);

        List<Permission> permissionList = Arrays.asList(p1, p2, p3, p4, p5);

        User u1 = new User(1, "John Doe", Arrays.asList("Admin", "Editor"));
        User u2 = new User(2, "Jane Smith", Arrays.asList("Editor", "Viewer"));
        User u3 = new User(3, "Alice Brown", List.of("Viewer"));

        List<User> users = Arrays.asList(u1, u2, u3);

        return new Authorization(permissionList, users);
    }
}
