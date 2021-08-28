package app.service;

import app.doa.UserRegisterDaoImpl;

public class UserRegisterServiceImpl {
    public boolean saveUserDetail(String username, String password, String conf_pass, String screen_name, String dob, String gender, String status, String location, String visible){
        UserRegisterDaoImpl userRegisterDaoImpl = new UserRegisterDaoImpl();

        // if(null!=username && null!=password && null!=conf_pass && null!=screen_name && null!=dob && null!=gender && null!=location && null!=status){
        //     if(username.trim().isEmpty() && password.trim().isEmpty() && conf_pass.trim().isEmpty() && screen_name.trim().isEmpty() && dob.trim().isEmpty() && gender.trim().isEmpty() && status.trim().isEmpty() && location.trim().isEmpty()){

        //     }
        // }
        return false;
    }
}
