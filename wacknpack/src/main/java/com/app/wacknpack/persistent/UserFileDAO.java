package com.app.wacknpack.persistent;

import java.io.IOException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import com.app.wacknpack.model.User;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


public class UserFileDAO implements UserDAO{
    // private static final Logger LOG =
    // Logger.getLogger(PaintingFileDAO.class.getName());
    public Map<Integer, User> users; // Provides a local cache of the painting objects
    // so that we don't need to read from the file
    // each time
    private ObjectMapper objectMapper; // Provides conversion between painting
                                       // objects and JSON text format written
                                       // to the file
    private static int nextId; // The next Id to assign to a new painting
    private String filename; // Filename to read from and write to
    // private String ADMIN_USERNAME = "admin";
    // private String ADMIN_PASSWORD = "admin";

    /**
     * Creates a User File Data Access Object
     * 
     * @param filename     Filename to read from and write to
     * @param objectMapper Provides JSON Object to/from Java Object serialization
     *                     and deserialization
     * 
     * @throws IOException when file cannot be accessed or read from
     */
    public UserFileDAO(@Value("${users.file}") String filename, ObjectMapper objectMapper) throws IOException {
        this.filename = filename;
        this.objectMapper = objectMapper;
        load(); // load the paintings from the file
    }

    /**
     * Generates the next id for a new {@linkplain User user}
     * 
     * @return The next id
     */
    private synchronized static int nextId() {
        int id = nextId;
        ++nextId;
        return id;
    }

    /**
     * Generates an array of {@linkplain User users} from the tree map
     * 
     * @return The array of {@link User users}, may be empty
     */
    private User[] getUsersArray() {
        return getUserssArray(null);
    }

    /**
     * Generates an array of {@linkplain User users} from the tree map for
     * any
     * {@linkplain User user} that contains the text specified by
     * containsText
     * <br>
     * If containsText is null, the array contains all of the {@linkplain User
     * users}
     * in the tree map
     * 
     * @return The array of {@link User users}, may be empty
     */
    private User[] getUserssArray(String containsText) { // if containsText == null, no filter
        ArrayList<User> userlst = new ArrayList<>();

        for (User user : users.values()) {
            if (containsText == null || user.getEmail().contains(containsText)) {
                userlst.add(user);
            }
        }

        User[] userArr = new User[userlst.size()];
        userlst.toArray(userArr);
        return userArr;
    }

    /**
     * Saves the {@linkplain User users} from the map into the file as an
     * array of JSON objects
     * 
     * @return true if the {@link User users} were written successfully
     * 
     * @throws IOException when file cannot be accessed or written to
     */
    private boolean save() throws IOException {
        User[] user_arr = getUsersArray();

        // Serializes the Java Objects to JSON objects into the file
        // writeValue will thrown an IOException if there is an issue
        // with the file or reading from the file
        objectMapper.writeValue(new File(filename), user_arr);
        return true;
    }

    /**
     * Loads {@linkplain User users} from the JSON file into the map
     * <br>
     * Also sets next id to one more than the greatest id found in the file
     * 
     * @return true if the file was read successfully
     * 
     * @throws IOException when file cannot be accessed or read from
     */
    private boolean load() throws IOException {
        users = new TreeMap<>();
        nextId = 0;

        // Deserializes the JSON objects from the file into an array of heroes
        // readValue will throw an IOException if there's an issue with the file
        // or reading from the file
        User[] user_arr = objectMapper.readValue(new File(filename), User[].class);

        // Add each hero to the tree map and keep track of the greatest id
        for (User user : user_arr) {
            users.put(user.getUserId(), user);
            if (user.getUserId() > nextId)
                nextId = user.getUserId();
        }
        // Make the next id one greater than the maximum from the file
        ++nextId;
        return true;
    }


    @Override
    public User[] getUsers() throws IOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUsers'");
    }

    @Override
    public User[] findUsers(String query) throws IOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findUsers'");
    }

    @Override
    public User getUser(int id) throws IOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUser'");
    }

    @Override
    public User registerUser(User user) throws IOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'registerUser'");
    }

    @Override
    public User loginUser(String username, String password) throws IOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'loginUser'");
    }

    @Override
    public User updateUser(User user) throws IOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateUser'");
    }

    @Override
    public boolean deleteUser(int id) throws IOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteUser'");
    }
    
}
