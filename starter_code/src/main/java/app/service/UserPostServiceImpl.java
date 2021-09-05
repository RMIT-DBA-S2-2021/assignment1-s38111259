package app.service;

import app.doa.UserPostDaoImpl;

public class UserPostServiceImpl {
    public boolean userPostDetail(String post_responseID,String body, String timestamp, String parent_post, String parent_response, String MEMBER_EMAILADDRESS, String POST_RESPONSE_POST_RESPONSEID){
        boolean isPosted;
        UserPostDaoImpl userPostDaoImpl = new UserPostDaoImpl();
        isPosted=userPostDaoImpl.postUserDetailDB(post_responseID, body, timestamp, parent_post, parent_response, MEMBER_EMAILADDRESS, POST_RESPONSE_POST_RESPONSEID);
        return isPosted;
    }
}
