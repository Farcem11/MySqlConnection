package cr.tec.desarrollomovil.conexionandroidmysql;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import cr.tec.desarrollomovil.conexionandroidmysql.Classes.Database;
import cr.tec.desarrollomovil.conexionandroidmysql.Classes.User;

public class MainActivity extends AppCompatActivity {

    EditText login_eMail;
    EditText login_pwd;
    public static Context context;

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
        context = this;
    }

  public void signUp(View view)
  {
    Intent intent = new Intent(this, RegistrarCuenta.class);
    startActivity(intent);
  }

  public void logIn(View view)
  {
      String str_eMail = login_eMail.getText().toString();
      String str_pwd = login_pwd.getText().toString();
      if (str_eMail.isEmpty())
      {
          Toast.makeText(this, R.string.error_eMailEmpty, Toast.LENGTH_LONG).show();
      }
      else if (str_pwd.isEmpty())
      {
          Toast.makeText(this, R.string.error_pwdEmpty, Toast.LENGTH_LONG).show();
      }
      else
      {
          User user = Database.getUser(str_eMail,str_pwd);
          if (user != null)
          {
              Intent intent = new Intent(this, PerfilUsuario.class);
              intent.putExtra("myFirstName", user.get_Name());
              intent.putExtra("myLastName", user.get_LastName());
              intent.putExtra("myUserName", user.get_Username());
              intent.putExtra("myEmail", user.get_Email());
              startActivity(intent);
          }
          else
          {
              Toast.makeText(this, "El correo no se encuetra registrado en la base de datos o la contraseña es incorrecta", Toast.LENGTH_LONG).show();
          }
      }
  }
}
