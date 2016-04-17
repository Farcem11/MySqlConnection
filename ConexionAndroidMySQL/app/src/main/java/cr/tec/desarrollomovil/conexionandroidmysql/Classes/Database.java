package cr.tec.desarrollomovil.conexionandroidmysql.Classes;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.concurrent.ExecutionException;

/**
 * Created by Farcem on 16-Apr-16.
 */
public class Database
{
    private static String signInURL = "http://192.168.10.101:8888/signIn.php";
    private static String registerURL = "http://192.168.10.101:8888/register.php";
    private static String charset = "UTF-8";

    public static User getUser(String Email, String Password)
    {
        try
        {
            String query = String.format("Email=%s&Password=%s",
                    URLEncoder.encode(Email, charset),
                    URLEncoder.encode(Password, charset));

            JSONArray responseJSON = new Server().execute(signInURL, query).get();
            if(responseJSON != null && responseJSON.length() > 0)
            {
                JSONObject jsonobject = responseJSON.getJSONObject(0);

                String name = jsonobject.getString("Name");
                String lastName = jsonobject.getString("LastName");
                String email = jsonobject.getString("Email");
                String userName = jsonobject.getString("UserName");
                return new User(name, lastName, email, userName);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int registerUser(String Name, String LastName, String Email, String Password, String UserName)
    {
        try
        {
            String query = String.format("Name=%s&LastName=%s&Email=%s&Password=%s&UserName=%s",
                    URLEncoder.encode(Name, charset),
                    URLEncoder.encode(LastName, charset),
                    URLEncoder.encode(Email, charset),
                    URLEncoder.encode(Password, charset),
                    URLEncoder.encode(UserName, charset));

            JSONArray responseJSON = new Server().execute(registerURL, query).get();
            if (responseJSON != null)
            {
                JSONObject jsonobject = responseJSON.getJSONObject(0);

                return jsonobject.getInt("inserted");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
