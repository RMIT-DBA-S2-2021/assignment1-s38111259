package app.service;

import app.doa.UserDetailDaoImpl;
import app.model.UserDetailM;

public class UserDetailServiceImpl {
    UserDetailDaoImpl userDetailDaoImpl;
    
    public UserDetailM getUserDetail(String userName, String passWord){
        userDetailDaoImpl =new UserDetailDaoImpl();
        UserDetailM userDetailM=new UserDetailM();
        if((null!=userName && null!=passWord) && (!(userName.trim().isEmpty() && passWord.trim().isEmpty()))){          
            userDetailM=userDetailDaoImpl.getUserDetailDB(userName, passWord);
            if(null!=userDetailM){
                return userDetailM;
            }
            else{
                return null;
            }
        }
        else{
            return null;
        }
    }
}
