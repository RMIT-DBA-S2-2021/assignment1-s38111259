package app.service;

import app.doa.UserRegisterDaoImpl;

public class UserRegisterServiceImpl {
    public boolean saveUserDetail(String email, String fname, String password, String screen_name, String dob, String gender, String status, String location, String visible){
        boolean isInserted;
        UserRegisterDaoImpl userRegisterDaoImpl = new UserRegisterDaoImpl();
        isInserted=userRegisterDaoImpl.saveUserDetailDB(email, fname, password, screen_name, dob, gender, status, location, visible);
        return isInserted;
    }
}
