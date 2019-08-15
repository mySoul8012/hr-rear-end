package com.ming.service;

import com.ming.bean.Position;
import com.ming.mapper.PositionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("positionService")
public class PositionService {
    @Autowired
    PositionMapper positionMapper;

    public int addPos(Position pos) {
        if (positionMapper.getPosByName(pos.getName()) != null) {
            return -1;
        }
        return positionMapper.addPos(pos);
    }

    public List<Position> getAllPos() {
        return positionMapper.getAllPos();
    }

    public boolean deletePosById(String pids) {
        String[] split = pids.split(",");
        return positionMapper.deletePosById(split) == split.length;
    }

    public int updatePosById(Position position) {
        return positionMapper.updatePosById(position);
    }
}
