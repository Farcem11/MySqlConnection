package cr.tec.desarrollomovil.conexionandroidmysql;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

  EditText login_eMail;
  EditText login_pwd;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    login_eMail = (EditText) findViewById(R.id.login_eMail);
    login_pwd = (EditText) findViewById(R.id.login_pwd);
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
  public void logIn(View view){
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

    if (!str_pwd.equals("holaMundo")) {
      Toast.makeText(this, R.string.error_loginInvalidPwd, Toast.LENGTH_LONG).show();
      return;
    } else {
      String obtainedFirstName = "Mi primer nombre";
      String obtainedLastName = "Mi segundo nombre";
      String obtainedUserName = "Mi nombre de usuario";
      String obtainedEmail = "root@example.com";

      Intent intent = new Intent(this, PerfilUsuario.class);

      // La información de perfil obtenida se pasa al Intent
      intent.putExtra("myFirstName", obtainedFirstName);
      intent.putExtra("myLastName", obtainedLastName);
      intent.putExtra("myUserName", obtainedUserName);
      intent.putExtra("myEmail", obtainedEmail);

      startActivity(intent);
    }
  }
}
