package com.app.wacknpack.DAO;

import java.io.IOException;

import com.app.wacknpack.model.Rewards;

public interface RewardsDAO {
    
    Integer addPoints(int point) throws Exception;

    Rewards subPoints(int point) throws Exception;

    Rewards getRewards(int id) throws Exception;

}
