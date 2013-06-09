package com.compiler.dao;

import com.compiler.entity.Direction;
import java.util.Collection;

public interface DirectionDAO {

    public Collection<Direction> getDirection();

    public void insertDir(Direction dir) ;

    public boolean deleteDir(Direction dir);

    public void updateDir(Direction dir);


}
