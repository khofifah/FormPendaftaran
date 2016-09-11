package id.sch.smktelkom_mlg.tugas01.xirpl6016.formpendaftaran;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etNama;
    RadioButton rpl;
    RadioButton tkj;
    Button Join;
    TextView gabung;
    TextView gabung2;
    TextView gabung3;
    TextView gabung4;
    CheckBox hb1, hb2, hb3;
    Spinner squad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        rpl = (RadioButton) findViewById(R.id.rpl);
        tkj = (RadioButton) findViewById(R.id.tkj);
        Join = (Button) findViewById(R.id.button);
        gabung = (TextView) findViewById(R.id.gabung);
        gabung2 = (TextView) findViewById(R.id.gabung2);
        gabung3 = (TextView) findViewById(R.id.gabung3);
        gabung4 = (TextView) findViewById(R.id.gabung4);
        hb1 = (CheckBox) findViewById(R.id.hobi1);
        hb2 = (CheckBox) findViewById(R.id.hobi2);
        hb3 = (CheckBox) findViewById(R.id.hobi3);
        squad = (Spinner) findViewById(R.id.layer);


        Join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doProcess();
                doClick();
            }
        });

    }

    private void doClick() {


        String nyam = squad.getSelectedItem().toString();
        gabung4.setText("Angkatan " + nyam);

        String jurus = null;
        if
                (rpl.isChecked())
        {
            jurus = rpl.getText().toString();
        }
        else if(tkj.isChecked())
        {
            jurus = tkj.getText().toString();
        }
        if (jurus == null) {
            gabung2.setText("Anda Belum Memilih Jurusan");
        } else {
            gabung2.setText("Jurusan Anda " + jurus);
        }

        String hobi = "Anda berminat mengikuti:\n";
        int startlen = hobi.length();
        if (hb1.isChecked()) hobi += hb1.getText() + "\n";
        if (hb2.isChecked()) hobi += hb2.getText() + "\n";
        if (hb3.isChecked()) hobi += hb3.getText() + "\n";

        if (hobi.length() == startlen) hobi += "Anda Belum Memilih perminatan Hobi";

        gabung3.setText(hobi);

    }

    private void doProcess() {
        if (isValid()) {
            String namanich = etNama.getText().toString();
            gabung.setText("Selamat Bergabung " + namanich);
        }
    }

    private boolean isValid() {
        boolean valid = true;

        String nama = etNama.getText().toString();
        if (nama.isEmpty()) {
            etNama.setError("Nama Belum Diisi");
            valid = false;
        } else if (nama.length() < 3) {
            etNama.setError("Nama Minimal 3 Karakter");
        } else {
            etNama.setError(null);
        }
        return valid;
    }

}
