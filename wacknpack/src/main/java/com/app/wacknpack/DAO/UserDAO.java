package com.app.wacknpack.DAO;

import java.io.IOException;

import com.app.wacknpack.model.User;

public interface UserDAO {
    /**
     * get all the Users in the file
     * 
     * @return list of all the users in the file
     * @throws IOException
     */
    User[] getUsers() throws IOException;

    /**
     * Return a list of {@link User users} related to a search query
     * 
     * @param query
     * @return array of users object
     * @throws IOException
     */
    User[] findUsers(String query) throws IOException;

    /**
     * Returns selected user based off of ID
     * 
     * @param id
     * @return singular user object
     * @throws IOException
     */
    User getUser(int id) throws IOException;

    /**
     * Create a new {@link User user} account given the required informqtion
     * 
     * @param User object
     * @return the new {@link User users} if successful, null otherwise
     * @throws IOException
     */
    User registerUser(User user) throws IOException;

    /**
     * Checks whether a user has the correct credentials to log in
     * @param user the user that want to login in
     * @return true if valid user, false otherwise
     * @throws IOException
     */
    User loginUser(String username, String password) throws IOException;

}
