package app.service;

import app.doa.UserDeleteDaoImpl;

public class UserDeleteServiceImpl {
    public boolean deleteUserDetail(String email){
        UserDeleteDaoImpl userDeleteDaoImpl = new UserDeleteDaoImpl();
        boolean isDeleted;
        isDeleted=userDeleteDaoImpl.updateUserDetailDB(email);
        return isDeleted;
    }
}
