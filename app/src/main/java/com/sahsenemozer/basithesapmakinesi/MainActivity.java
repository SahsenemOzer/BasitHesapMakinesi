package com.sahsenemozer.basithesapmakinesi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editTextBirinciSayi, editTextIkinciSayi;
    private TextView txtSonuc;

    private String birincisayi, ikincisayi;
    private int s1, s2, sonuc;
    private Hesapla hesapla;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextBirinciSayi = (EditText) findViewById(R.id.editTextNumberSigned);
        editTextIkinciSayi = (EditText) findViewById(R.id.editTextNumberSigned2);
        txtSonuc = (TextView) findViewById(R.id.textViewSonuc);
    }

    public void btnHesapla(View v) {

        birincisayi = editTextBirinciSayi.getText().toString();
        ikincisayi = editTextIkinciSayi.getText().toString();

        if (!TextUtils.isEmpty(birincisayi) && !TextUtils.isEmpty(ikincisayi)) {
            s1 = Integer.valueOf(birincisayi);
            s2 = Integer.valueOf(ikincisayi);
            hesapla = new Hesapla(s1, s2);

            int id = v.getId();
            if (id == R.id.btnTopla) {
                sonuc = hesapla.toplam();
            } else if (id == R.id.btnFark) {
                sonuc = hesapla.fark();
            } else if (id == R.id.button3) {
                sonuc = hesapla.bolum();
            } else if (id == R.id.button4) {
                sonuc = hesapla.carpim();
            }

            txtSonuc.setText("Sonuç:" + sonuc);
        } else {
            txtSonuc.setText("Girilen Değerler Boş Olamaz.");
        }
    }
}