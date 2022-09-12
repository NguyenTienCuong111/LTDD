package com.example.nguyentiencuong_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.content.Intent;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvMonHoc;
    Button btnThem , btnCapNhat ,btnXoa;
    EditText edtMonHoc;
    ArrayList<String> arrayCourse;
    int vitri = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvMonHoc = (ListView) findViewById(R.id.listviewMonHoc);
        btnThem = (Button) findViewById(R.id.buttonThem);
        btnCapNhat = (Button) findViewById(R.id.buttonCapNhat);
        btnXoa = (Button) findViewById(R.id.buttonXoa);
        edtMonHoc = (EditText) findViewById(R.id.editTextMonHoc);
        arrayCourse= new ArrayList<>();

        arrayCourse.add("PHP");
        arrayCourse.add("Node JS");
        arrayCourse.add("Python");
        arrayCourse.add("Java");
        arrayCourse.add("C#");

        ArrayAdapter adapter= new ArrayAdapter(MainActivity.this,
                android.R.layout.simple_list_item_1,
                arrayCourse);
        lvMonHoc.setAdapter(adapter);

        lvMonHoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                edtMonHoc.setText(arrayCourse.get(i));
                vitri = i;
            }
        });
        lvMonHoc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    startActivity(new Intent(MainActivity.this, PHP.class));
                }
                if(i==1){
                    startActivity(new Intent(MainActivity.this, NodeJS.class));
                }
                if(i==2){
                    startActivity(new Intent(MainActivity.this, Python.class));
                }
                if(i==3){
                    startActivity(new Intent(MainActivity.this, Java.class));
                }
                if(i==4){
                    startActivity(new Intent(MainActivity.this, CSharp.class));
                }
                    return false;
            }
        });

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String monhoc = edtMonHoc.getText().toString();
                arrayCourse.add(monhoc);
                adapter.notifyDataSetChanged();

            }
        });
        btnCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayCourse.set(vitri, edtMonHoc.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i=0; i < arrayCourse.size();i++){
                    String getname = edtMonHoc.getText().toString();
                    if(arrayCourse.get(i).equals(getname)){
                        arrayCourse.remove(i);
                        adapter.notifyDataSetChanged();
                        break;
                    }
                    else{
                        Toast.makeText(MainActivity.this, "NO ITEMS MATCHED", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}