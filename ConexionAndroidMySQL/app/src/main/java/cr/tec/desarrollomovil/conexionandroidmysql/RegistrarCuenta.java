package cr.tec.desarrollomovil.conexionandroidmysql;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class RegistrarCuenta extends AppCompatActivity {

  TextView firstName;
  TextView lastName;
  TextView userName;
  TextView eMail;
  TextView pwd;
  TextView pwdAgain;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_registrar_cuenta);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    firstName = (TextView) findViewById(R.id.signUp_firstName);
    lastName = (TextView) findViewById(R.id.signUp_lastName);
    userName = (TextView) findViewById(R.id.signUp_userName);
    eMail = (TextView) findViewById(R.id.signUp_eMail);
    pwd = (TextView) findViewById(R.id.signUp_pwd);
    pwdAgain = (TextView) findViewById(R.id.signUp_pwdAgain);
  }


  // Registra un nuevo perfil a la BD
  public void submitNewProfile(View view) {
    String str_firstName = firstName.getText().toString();
    String str_lastName = lastName.getText().toString();
    String str_userName = userName.getText().toString();
    String str_eMail = eMail.getText().toString();
    String str_pwd = pwd.getText().toString();
    String str_pwdAgain = pwdAgain.getText().toString();

    if (str_firstName.isEmpty()) {
      Toast.makeText(this, R.string.error_firstNameEmpty, Toast.LENGTH_LONG).show();
      return;
    }
    if (str_lastName.isEmpty()) {
      Toast.makeText(this, R.string.error_lastNameEmpty, Toast.LENGTH_LONG).show();
      return;
    }
    if (str_userName.isEmpty()){
      Toast.makeText(this, R.string.error_eMailEmpty, Toast.LENGTH_LONG).show();
      return;
    }
    if (str_eMail.isEmpty()) {
      Toast.makeText(this, R.string.error_eMailEmpty, Toast.LENGTH_LONG).show();
      return;
    }
    if (str_pwd.isEmpty()){
      Toast.makeText(this, R.string.error_pwdEmpty, Toast.LENGTH_LONG).show();
      return;
    }
    if (str_pwdAgain.isEmpty()){
      Toast.makeText(this, R.string.error_pwdAgainEmpty, Toast.LENGTH_LONG).show();
      return;
    }
    if (!str_pwd.contentEquals(str_pwdAgain)){
      Toast.makeText(this, R.string.error_pwdsMismatch, Toast.LENGTH_LONG).show();
      return;
    }
    // TODO Enviar datos a BD
  }
}
