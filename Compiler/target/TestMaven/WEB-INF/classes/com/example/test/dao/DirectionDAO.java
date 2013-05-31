package com.example.test.dao;

import com.example.test.entity.Direction;
import java.util.Collection;

public interface DirectionDAO {

    public Collection<Direction> getDirection();

    public void insertDir(Direction dir) ;

    public boolean deleteDir(Direction dir);

    public void updateDir(Direction dir);


}
