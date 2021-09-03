package app.service;
import app.doa.UserDetailUpdateDaoImpl;

/**
 * UserDetailUpdateServiceImpl
 */
public class UserDetailUpdateServiceImpl {
    public boolean updateUserDetail(String email, String sname, String status, String location, String visible){
        UserDetailUpdateDaoImpl userDetailUpdateDaoImpl=new UserDetailUpdateDaoImpl();
        boolean isUpdated;
        isUpdated=userDetailUpdateDaoImpl.updateUserDetailDB(email, sname, status, location, visible);
        return isUpdated;
    }
}