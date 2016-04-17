package cr.tec.desarrollomovil.conexionandroidmysql;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class PerfilUsuario extends AppCompatActivity {

  TextView firstName;
  TextView lastName;
  TextView userName;
  TextView eMail;

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_perfil_usuario);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    firstName = (TextView)findViewById(R.id.profile_firstName);
    lastName = (TextView)findViewById(R.id.profile_lastName);
    userName = (TextView)findViewById(R.id.profile_userName);
    eMail = (TextView) findViewById(R.id.profile_eMail);

    showProfileInfo(savedInstanceState);
  }

  private void showProfileInfo(Bundle savedInstance){
    if (savedInstance == null)
    {
      Bundle extras = getIntent().getExtras();

      if (extras == null)
      {
        return;
      }
      else
      {
        firstName.setText(extras.getString("myFirstName"));
        lastName.setText(extras.getString("myLastName"));
        userName.setText(extras.getString("myUserName"));
        eMail.setText(extras.getString("myEmail"));
      }
    }
    else
    {
      firstName.setText((String) savedInstance.getSerializable("myFirstName"));
      lastName.setText((String) savedInstance.getSerializable("myLastName"));
      userName.setText((String) savedInstance.getSerializable("myUserName"));
      eMail.setText((String) savedInstance.getSerializable("myEmail"));
      return;
    }
  }

  @Override
  public void onBackPressed()
  {
    super.onBackPressed();
    finish();
  }
}
