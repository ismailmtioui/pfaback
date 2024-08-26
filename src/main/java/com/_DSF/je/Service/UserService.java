
package com._DSF.je.Service;

import com._DSF.je.Entity.User;

public interface UserService {
    User registerUser(User user);
    User loginUser(String username, String password);
}
