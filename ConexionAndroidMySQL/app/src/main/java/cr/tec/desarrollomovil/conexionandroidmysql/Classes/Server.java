package cr.tec.desarrollomovil.conexionandroidmysql.Classes;

import android.annotation.TargetApi;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Server extends AsyncTask<String, Void, JSONArray>
{
    String charset = "UTF-8";
    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    protected JSONArray doInBackground(String... pUrl)
    {
        try
        {
            URLConnection connection = new URL(pUrl[0]).openConnection();
            connection.setRequestProperty("Accept-Charset", charset);
            InputStream response = connection.getInputStream();

            try (Scanner scanner = new Scanner(response))
            {
                String responseJSON = scanner.useDelimiter("\\n").next();
                return new JSONArray(responseJSON);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}

