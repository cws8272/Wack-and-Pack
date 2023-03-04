package com.app.wacknpack.persistent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.app.wacknpack.DAO.RewardsDAO;
import com.app.wacknpack.model.Rewards;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RewardsFileDAO implements RewardsDAO{

    private ObjectMapper objectMapper;


    @Override
    public Integer addPoints(int point) throws Exception {
        // retrive the rewards tied to the user id
        // update the points
        // save the rewards bakc to the file
        int points = 0;
//        points = Rewards.getPoints();
        points = points + point;
        return points;
        
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
