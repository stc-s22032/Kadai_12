package s22032.suntech.jp.kadai_12;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButtonClickListener listener = new ButtonClickListener();

        Button btClear=findViewById(R.id.btClear);
        btClear.setOnClickListener(listener);

        Button btSend =findViewById(R.id.btSend);
        btSend.setOnClickListener(listener);

        Button btConfirm =findViewById(R.id.btConfirm);
        btConfirm.setOnClickListener(listener);
    }
    private class ButtonClickListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            EditText input_ti = findViewById(R.id.etTitel);
            EditText input_na = findViewById(R.id.etName);
            EditText input_ma = findViewById(R.id.etMail);
            EditText input_co = findViewById(R.id.etComment);
            String inputStr_ti = input_ti.getText().toString();
            String inputStr_na = input_na.getText().toString();
            String inputStr_ma = input_ma.getText().toString();
            String inputStr_co = input_co.getText().toString();
            String show = "名前:"+inputStr_na+
                    "タイトル:" + inputStr_ti+
                    "メールアドレス"+inputStr_ma+
                    "質問内容"+inputStr_co;

            //Context context = getApplicationContext();
            int id = view.getId();
            if(id==R.id.btSend) {
                Snackbar.make(view, show, Snackbar.LENGTH_LONG).show();
            }
            else if (id==R.id.btConfirm) {
                ConfirnDialogFrament dialogFragment = new ConfirnDialogFrament();
                dialogFragment.show(getSupportFragmentManager(), "DialogActivity");
                Snackbar.make(view,show,Snackbar.LENGTH_LONG).show();
            }
            else if (id==R.id.btClear) {
                input_na.setText("");
                input_ti.setText("");
                input_ma.setText("");
                input_co.setText("");
            }

        }

    }

}