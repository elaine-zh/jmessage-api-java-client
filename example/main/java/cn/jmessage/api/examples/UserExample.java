package cn.jmessage.api.examples;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jmessage.api.JMessageClient;
import cn.jmessage.api.common.model.RegisterInfo;
import cn.jmessage.api.user.UserInfoResult;
import cn.jmessage.api.user.UserListResult;

public class UserExample {

    protected static final Logger LOG = LoggerFactory.getLogger(UserExample.class);

    private static final String appkey = "242780bfdd7315dc1989fe2b";
    private static final String masterSecret = "2f5ced2bef64167950e63d13";
    
    public static void main(String[] args) {
    	
    }

    public static void testRegisterUsers() {
        JMessageClient client = new JMessageClient(appkey, masterSecret);

        try {

            List<RegisterInfo> users = new ArrayList<RegisterInfo>();

            RegisterInfo user = RegisterInfo.newBuilder()
                    .setUsername("test_user")
                    .setPassword("test_pass")
                    .build();

            RegisterInfo user1 = RegisterInfo.newBuilder()
                    .setUsername("test_user1")
                    .setPassword("test_pass1")
                    .build();

            users.add(user);
            users.add(user1);

            RegisterInfo[] regUsers = new RegisterInfo[users.size()];

            String res = client.registerUsers(users.toArray(regUsers));
            LOG.info(res);
        } catch (APIConnectionException e) {
            LOG.error("Connection error. Should retry later. ", e);
        } catch (APIRequestException e) {
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Message: " + e.getMessage());
        }
    }

    public static void testGetUserInfo() {
        JMessageClient client = new JMessageClient(appkey, masterSecret);

        try {
            UserInfoResult res = client.getUserInfo("test_user");
            LOG.info(res.getUsername());
        } catch (APIConnectionException e) {
            LOG.error("Connection error. Should retry later. ", e);
        } catch (APIRequestException e) {
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Message: " + e.getMessage());
        }
    }

    public static void testUpdatePassword() {
        JMessageClient client = new JMessageClient(appkey, masterSecret);

        try {
            client.updateUserPassword("test_user", "test_new_pass");
        } catch (APIConnectionException e) {
            LOG.error("Connection error. Should retry later. ", e);
        } catch (APIRequestException e) {
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Message: " + e.getMessage());
        }
    }

    public static void testUpdateUserInfo() {
        JMessageClient client = new JMessageClient(appkey, masterSecret);

        try {
            client.updateUserInfo("test_user", "test_nick", "2000-01-12", "help me!", 1, "shenzhen", "nanshan");
        } catch (APIConnectionException e) {
            LOG.error("Connection error. Should retry later. ", e);
        } catch (APIRequestException e) {
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Message: " + e.getMessage());
        }
    }

    public static void testGetUsers() {
        JMessageClient client = new JMessageClient(appkey, masterSecret);

        try {
            UserListResult res = client.getUserList(0, 30);
            LOG.info(res.getOriginalContent());
        } catch (APIConnectionException e) {
            LOG.error("Connection error. Should retry later. ", e);
        } catch (APIRequestException e) {
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Message: " + e.getMessage());
        }
    }

    public static void testDeleteUser() {
        JMessageClient client = new JMessageClient(appkey, masterSecret);

        try {
            client.deleteUser("test_user_119");
        } catch (APIConnectionException e) {
            LOG.error("Connection error. Should retry later. ", e);
        } catch (APIRequestException e) {
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Message: " + e.getMessage());
        }
    }
    
    /**
     * Get admins by appkey
     * @param start The start index of the list
     * @param count The number that how many you want to get from list
     * @return
     * @throws APIConnectionException
     * @throws APIRequestException
     */
    public void testGetAdminListByAppkey() {
    	JMessageClient client = new JMessageClient(appkey, masterSecret);
    	try {
			UserListResult res = client.getAdminListByAppkey(0, 1);
			LOG.info(res.getOriginalContent());
		} catch (APIConnectionException e) {
			LOG.error("Connection error. Should retry later. ", e);
		} catch (APIRequestException e) {
			LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Message: " + e.getMessage());
		}
    }

}

