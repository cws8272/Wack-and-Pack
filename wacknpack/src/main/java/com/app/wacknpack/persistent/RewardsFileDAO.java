package com.app.wacknpack.persistent;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.app.wacknpack.DAO.RewardsDAO;
import com.app.wacknpack.model.Rewards;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RewardsFileDAO implements RewardsDAO{

    private ObjectMapper objectMapper;
    private String filename;
    private static int nextId = 007;
    private HashMap<Integer, Rewards> reward_warehouse;

    public RewardsFileDAO(@Value("${rewards.file}") String filename, ObjectMapper objectMapper) throws IOException {
        this.filename = filename;
        this.objectMapper = objectMapper;
        load(); // load the paintings from the file
    }

    private synchronized static int nextId() {
        int id = nextId;
        ++nextId;
        return id;
    }

    private void load() throws StreamReadException, DatabindException, IOException {
        reward_warehouse = new HashMap<Integer, Rewards>();

        // Deserializes the JSON objects from the file into an array
        // readValue will throw an IOException if there's an issue with the file
        // or reading from the file
        Rewards[] points_arr = objectMapper.readValue(new File(filename), Rewards[].class);

        // Add each rewards to the tree map and keep track of the greatest id
        for (Rewards point : points_arr) {
            reward_warehouse.put(point.getUserId(), point);
            if (point.getUserId() > nextId)
                nextId = point.getUserId();
        }
        // Make the next id one greater than the maximum from the file
        ++nextId;
    }

    private boolean save() throws IOException, StreamReadException, DatabindException {
        Rewards[] points_arr = this.getRewardsArray();

        // Serializes the Java Objects to JSON objects into the file
        // writeValue will thrown an IOException if there is an issue
        // with the file or reading from the file
        objectMapper.writeValue(new File(filename), points_arr);
        return true;
    }

    /**
     * Generates an array of {@linkplain rewards orders} from the tree map
     * 
     * @return The array of {@link rewards orders}, may be empty
     */
    public Rewards[] getRewardsArray() {
        return getRewardsArray(null);
    }

    /**
     * Generates an array of {@linkplain rewards orders} from the map for
     * any
     * {@linkplain rewards rewards} that belongs to a user specified by the user ID
     * <br>
     * If user_id is null, the array contains all of the {@linkplain rewards orders}
     * in the map
     * @return The array of {@link rewards orders}, may be empty
     */
    private Rewards[] getRewardsArray(Number user_id) {

        ArrayList<Rewards> rewardlst = new ArrayList<>();

        for (Rewards reward : reward_warehouse.values()) {
            if (user_id == null || reward.getUserId() == user_id.intValue()) {
                rewardlst.add(reward);
            }
        }

        Rewards[] rewardArr = new Rewards[rewardlst.size()];
        rewardArr[0] = rewardlst.get(0);

        return rewardArr;
    
    }

    @Override
    public Rewards addPoints(int id, int point) throws Exception {
        // retrive the rewards tied to the user id
        // update the points
        // save the rewards bakc to the file
        
        Rewards reward = new Rewards(id, point);
        reward_warehouse.put(reward.getUserId(), reward);
        return reward;
        
    }

    @Override
    public Rewards subPoints(int point) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'subPoints'");
    }

    @Override
    public Rewards getRewards(int id) throws Exception {
        return getRewards(id);
    }
    
}
