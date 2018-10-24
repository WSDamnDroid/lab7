package artn.lab7;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class Second extends AppCompatActivity {
    private ArrayAdapter<String> arrayAdapter1, arrayAdapter2;
    private ListView lw1, lw2;
    private EditText et;
    private ColorStateList hintDC;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_act);
        arrayAdapter1 = new ArrayAdapter<String>(this, R.layout.listview1_lay);
        arrayAdapter2 = new ArrayAdapter<String>(this, R.layout.listview2_lay);
        lw1 = (ListView) findViewById(R.id.listView1);
        lw1.setAdapter(arrayAdapter1);
        lw2 = (ListView) findViewById(R.id.listView2);
        lw2.setAdapter(arrayAdapter2);
        et = (EditText) findViewById(R.id.editText);
        hintDC = et.getHintTextColors();
    }

    public void GoBack(View view) {
        onBackPressed();
    }

    //public void AddToList(View view, ListView lv)
    //тип чтобы по кнопке просто передавалась ссылка на ListView и потом в теле получаем ссылку на адаптер (lv.getAdpater()???),
    //чтобы добавить к листу итем

    public void AddToLV1(View view) {
        AddToLV(arrayAdapter1, et.getText().toString());
    }

    public void AddToLV2(View view) {
        AddToLV(arrayAdapter2, et.getText().toString());
    }

    private void AddToLV(ArrayAdapter ad, String src) {
        if (!src.isEmpty()) {
            ad.add(src);
            et.setHintTextColor(hintDC);
        } else
            et.setHintTextColor(Color.RED);
    }


}
