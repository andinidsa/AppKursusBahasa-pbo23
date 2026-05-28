
package myEntityManager;

import myFunction.Fungsi;
import myEntity.Login;


public class LoginManager {
   int i;
   
    public int inputData (Login log)
    {
        i = 0;
        try
        {
            String sql = "select*from login where username=? and password=?";
            
        i = Fungsi.EQuery(sql);
            return i;
        }
        catch (Exception e)
        {
            return i;
        }
}
}
