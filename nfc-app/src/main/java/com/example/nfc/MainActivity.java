package com.example.nfc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.nfc.ui.ReadMUActivity;
import com.example.nfc.ui.ReadTextActivity;
import com.example.nfc.ui.ReadUriActivity;
import com.example.nfc.ui.RunAppActivity;
import com.example.nfc.ui.RunUrlActivity;
import com.example.nfc.ui.WriteMUActivity;
import com.example.nfc.ui.WriteTextActivity;
import com.example.nfc.ui.WriteUriActivity;

public class MainActivity extends AppCompatActivity {
    private static final String[] strs = new String[]{
            "自动运行程序(NDEF格式)",
            "自动打开网页(NDEF格式)",
            "读NFC标签中的文本数据(NDEF格式)",
            "写NFC标签中的文本数据(NDEF格式)",
            "读NFC标签中的Uri数据(NDEF格式)",
            "写NFC标签中的Uri数据(NDEF格式)",
            "读NFC标签非NDEF格式的数据(非NDEF格式)",
            "写NFC标签非NDEF格式的数据(非NDEF格式)"
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strs));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switchActivity(position);
            }
        });
    }

    private void switchActivity(int position) {
        switch (position) {
            case 0: //自动运行程序
                startActivity(new Intent(this, RunAppActivity.class));
                break;
            case 1: //自动打开网页
                startActivity(new Intent(this, RunUrlActivity.class));
                break;
            case 2: //读NFC标签中的文本数据
                startActivity(new Intent(this, ReadTextActivity.class));
                break;
            case 3: //写NFC标签中的文本数据
                startActivity(new Intent(this, WriteTextActivity.class));
                break;
            case 4: //读NFC标签中的Uri数据
                startActivity(new Intent(this, ReadUriActivity.class));
                break;
            case 5: //写NFC标签中的Uri数据
                startActivity(new Intent(this, WriteUriActivity.class));
                break;
            case 6: //读NFC标签非NDEF格式的数据
                startActivity(new Intent(this, ReadMUActivity.class));
                break;
            case 7: //写NFC标签非NDEF格式的数据
                startActivity(new Intent(this, WriteMUActivity.class));
                break;
            default:
                break;
        }
    }
}
