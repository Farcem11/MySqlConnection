package cr.tec.desarrollomovil.conexionandroidmysql;

import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

import javax.net.ssl.HttpsURLConnection;

import cr.tec.desarrollomovil.conexionandroidmysql.Classes.Server;

public class MainActivity extends AppCompatActivity {

  EditText login_eMail;
  EditText login_pwd;

  @TargetApi(Build.VERSION_CODES.KITKAT)
  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
      setSupportActionBar(toolbar);

      login_eMail = (EditText) findViewById(R.id.login_eMail);
      login_pwd = (EditText) findViewById(R.id.login_pwd);

      String url = "http://192.168.10.101:8888/signIn.php";
      String charset = "UTF-8";
      String Email = "Farcem90@hotmail.com";
      String Password = "hola12";

      try
      {
          String query = String.format("Email=%s&Password=%s",
                  URLEncoder.encode(Email, charset),
                  URLEncoder.encode(Password, charset));

          JSONArray responseJSON = new Server().execute(url + "?" + query).get();
          if(responseJSON.length() > 0)
          {
              for (int i = 0; i < responseJSON.length(); i++)
              {
                  JSONObject jsonobject = responseJSON.getJSONObject(i);
                  String name = jsonobject.getString("Name");
                  String lastName = jsonobject.getString("LastName");
                  Toast.makeText(this, name + " " + lastName, Toast.LENGTH_LONG).show();
              }
          }
          else
          {
              Toast.makeText(this, "Usuario no registrado en la base de datos", Toast.LENGTH_LONG).show();
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
  }

  public void signUp(View view){
    Intent intent = new Intent(this, RegistrarCuenta.class);
    startActivity(intent);
  }

  /**
   * Efectua el inicio de sesión. Si el e-mail o contraseña ingresado no son válidos, se muestra
   * un Toast.
   *
   * @param view
   */
  private void logIn(View view){
    String str_eMail = login_eMail.getText().toString();
    String str_pwd = login_pwd.getText().toString();

    if (str_eMail.isEmpty()){
      Toast.makeText(this, R.string.error_eMailEmpty, Toast.LENGTH_LONG).show();
      return;
    }
    if (str_pwd.isEmpty()) {
      Toast.makeText(this, R.string.error_pwdEmpty, Toast.LENGTH_LONG).show();
      return;
    }

    // TODO Peticion base de datos
    // Utilizar e-mail: "root@example.com" y pwd "holaMundo" para probar función

    if (!str_eMail.equals("root@example.com")) {
      Toast.makeText(this, R.string.error_loginInvalidEmail, Toast.LENGTH_LONG).show();
      return;
    }

    if (!str_eMail.equals("holaMundo")) {
      Toast.makeText(this, R.string.error_loginInvalidPwd, Toast.LENGTH_LONG).show();
      return;
    }

    // La información de perfil obtenida se pasa al Intent
    else {
      String obtainedFirstName = "Mi primer nombre";
      String obtainedLastName = "Mi segundo nombre";
      String obtainedUserName = "Mi nombre de usuario";
      String obtainedEmail = "root@example.com";

      Intent intent = new Intent(this, PerfilUsuario.class);
      intent.putExtra("myFirstName", obtainedFirstName);
      intent.putExtra("myLastName", obtainedLastName);
      intent.putExtra("myUserName", obtainedUserName);
      intent.putExtra("myEmail", obtainedEmail);

      startActivity(intent);
    }
  }
}
