
package myEntity;

public class Login {
          private String usermane, password;
        
        public String getUsermane() {
            return usermane;
        }

        public void setUsermane(String usermane) {
            this.usermane = usermane;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
        public Login (String username, String password){
        this.usermane = username;
        this.password = password;
}
}
