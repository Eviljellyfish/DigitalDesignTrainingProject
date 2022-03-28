import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

public class UserController extends UserService {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public User add(User user) {
        throw new NotImplementedException();
    }

    public User findById(int id) {
        throw new NotImplementedException();
    }

    public List<User> findByFirstName(String name) {
        throw new NotImplementedException();
    }

    public List<User> findByFirstNameAndSecondName(String firstName, String secondName) {
        throw new NotImplementedException();
    }

    public boolean delete(User user) {
        throw new NotImplementedException();
    }


}
