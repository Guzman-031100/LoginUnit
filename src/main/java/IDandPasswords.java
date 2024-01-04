import java.util.HashMap;

public class IDandPasswords {

    HashMap<String, String> logininfo = new HashMap<>();

    IDandPasswords() {

        logininfo.put("Jesus", "Lego");
        logininfo.put("Andrea", "Art");
        logininfo.put("Monse", "Mario");
    }

    public HashMap getLoginInfo() {
        return logininfo;
    }

}