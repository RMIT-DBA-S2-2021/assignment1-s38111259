package app.service;

import java.util.ArrayList;

import app.doa.UserSearchDaoImpl;

public class UserSearchServiceImpl {
    public ArrayList searchUserDetail(String search){
        UserSearchDaoImpl userSearchDaoImpl = new UserSearchDaoImpl();
        return userSearchDaoImpl.getMember(search);
    }
}
