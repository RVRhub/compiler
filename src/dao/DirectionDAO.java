package dao;

import entity.Direction;
import java.util.Collection;

public interface DirectionDAO {

    public Collection getDirection();

    public void insertDir(Direction dir) ;

    public boolean deleteDir(Direction dir);

    public void updateDir(Direction dir);

    public void updateTypeDir(Direction dir);

}
