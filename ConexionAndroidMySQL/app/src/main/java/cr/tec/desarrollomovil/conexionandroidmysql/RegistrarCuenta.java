package cr.tec.desarrollomovil.conexionandroidmysql;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistrarCuenta extends AppCompatActivity {


  // Variables para los campos de texto del layout
  EditText firstName;
  EditText lastName;
  EditText userName;
  EditText eMail;
  EditText pwd;
  EditText pwdAgain;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_registrar_cuenta);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    // Asigna los TextView
    firstName = (EditText) findViewById(R.id.signUp_firstName);
    lastName = (EditText) findViewById(R.id.signUp_lastName);
    userName = (EditText) findViewById(R.id.signUp_userName);
    eMail = (EditText) findViewById(R.id.signUp_eMail);
    pwd = (EditText) findViewById(R.id.signUp_pwd);
    pwdAgain = (EditText) findViewById(R.id.signUp_pwdAgain);
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
    else{
      // TODO Enviar datos a BD

      // Toast notificando que la cuenta fue creada exitosamente
      Toast.makeText(this, R.string.success_signUp, Toast.LENGTH_LONG).show();

      // Finalizar esta Activity
      Intent intent = new Intent(this, MainActivity.class);
      startActivity(intent);
      this.finish();
    }
  }
}
