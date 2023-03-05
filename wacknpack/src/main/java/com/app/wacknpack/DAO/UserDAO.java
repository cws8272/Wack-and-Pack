package com.app.wacknpack.DAO;

import java.io.IOException;

import com.app.wacknpack.model.User;

public interface UserDAO {

    User[] getUsers() throws IOException;

    User[] findUsers(String query) throws IOException;

    User getUser(int id) throws IOException;

    User registerUser(User user) throws IOException;

    User loginUser(String username, String password) throws IOException;

    int getPoints(User user) throws IOException;

    void addPoints(User user, int pointsToAdd) throws IOException;

    void subtractPoints(User user, int pointsToSubtract) throws IOException;
}
