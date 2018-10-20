
package parsers;

import java.util.Map;
import model.User;


public class UserAdapter {

    public static User mapToUser(Map<String, String[]> params) {
        User u = new User();

        String password = params.get("password")[0];
        String first_name = params.get("first_name")[0];
        String surname = params.get("surname")[0];
        String email = params.get("email")[0];
        Integer phonenumber = Integer.parseInt(params.get("phonenumber")[0]);
        String pictureurl = params.get("pictureurl")[0];
        
        
        u.setPassword(password);
        u.setFirstname(first_name);
        u.setSurname(surname);
        u.setEmail(email);
        u.setPhoneNumber(phonenumber);
        u.setPictureUrl(pictureurl);
        
                

        return u;
    }
}
