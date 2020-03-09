package lab03.eim.systems.cs.pub.ro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class PhoneDialerActivity extends AppCompatActivity {
    class MyListener implements View

            .OnClickListener {

        @Override
        public void onClick(View v) {
            EditText txt = findViewById(R.id.editText);
            Editable s = txt.getText();
            switch (v.getId()) {
                case R.id.button:
                    s.append("0");
                    System.out.println("0");
                    Log.println(Log.DEBUG, "0", "pressed 0");
                    break;
                case R.id.button3:
                    s.append("1");
                    break;
                case R.id.button4:
                    s.append("2");
                    break;
                case R.id.button5:
                    s.append("3");
                    break;
                case R.id.button6:
                    s.append("4");
                    break;
                case R.id.button7:
                    s.append("5");
                    break;
                case R.id.button8:
                    s.append("6");
                    break;
                case R.id.button9:
                    s.append("7");
                    break;
                case R.id.button10:
                    s.append("8");
                    break;
                case R.id.button11:
                    s.append("9");
                    break;
                case R.id.button12:
                    s.append("#");
                    break;
                case R.id.button13:
                    s.append("*");
                    break;
                case R.id.imageButton:
                    // backspace
                    s.delete(s.length()-1, s.length());
                    break;
                case R.id.imageButton2:
                    // hang
                    PhoneDialerActivity.this.finish();
                    break;
                case R.id.imageButton3:
                    if (ContextCompat.checkSelfPermission(PhoneDialerActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(
                                PhoneDialerActivity.this,
                                new String[]{Manifest.permission.CALL_PHONE},
                                // val pt a cere permisiune de call - 1
                                Constants.PERMISSION_REQUEST_CALL_PHONE);
                    } else {
                        Intent intent = new Intent(Intent.ACTION_CALL);
                        intent.setData(Uri.parse("tel:" + txt.getText().toString()));
                        startActivity(intent);
                    }
                default:
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Button btn;
        ImageButton imbtn;
        MyListener listener = new MyListener();
        setContentView(R.layout.activity_phone_dialer);

        // refactor this
        btn = findViewById(R.id.button);
        btn.setOnClickListener(listener);

        btn = findViewById(R.id.button3);
        btn.setOnClickListener(listener);

        btn = findViewById(R.id.button4);
        btn.setOnClickListener(listener);

        btn = findViewById(R.id.button5);
        btn.setOnClickListener(listener);

        btn = findViewById(R.id.button6);
        btn.setOnClickListener(listener);

        btn = findViewById(R.id.button7);
        btn.setOnClickListener(listener);

        btn = findViewById(R.id.button8);
        btn.setOnClickListener(listener);

        btn = findViewById(R.id.button9);
        btn.setOnClickListener(listener);

        btn = findViewById(R.id.button10);
        btn.setOnClickListener(listener);

        btn = findViewById(R.id.button11);
        btn.setOnClickListener(listener);

        btn = findViewById(R.id.button12);
        btn.setOnClickListener(listener);

        // wrap content --> dim widget cat are el default
        // match parent --> se intinde pe una din dimensiunile ecranului
        btn = findViewById(R.id.button13);
        btn.setOnClickListener(listener);

        // add actions for call, delete, hang
        imbtn = findViewById(R.id.imageButton);
        imbtn.setOnClickListener(listener);

        imbtn = findViewById(R.id.imageButton2);
        imbtn.setOnClickListener(listener);

        imbtn = findViewById(R.id.imageButton3);
        imbtn.setOnClickListener(listener);
    }
}
