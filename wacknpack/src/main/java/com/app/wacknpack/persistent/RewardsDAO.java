package com.app.wacknpack.persistent;

import java.io.IOException;

import com.app.wacknpack.model.Rewards;

public interface RewardsDAO {
    
    void addPoints(int point) throws Exception;

    void subPoints(int point) throws Exception;

    Rewards getRewards(int id) throws Exception;

}
