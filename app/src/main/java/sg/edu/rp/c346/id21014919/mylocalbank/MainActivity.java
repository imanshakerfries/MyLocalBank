package sg.edu.rp.c346.id21014919.mylocalbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvDBS, tvOCBC, tvUOB;
    String wordClicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS = findViewById(R.id.tvDBS);
        tvOCBC = findViewById(R.id.tvOCBC);
        tvUOB = findViewById(R.id.tvUOB);

        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if(v == tvDBS) {
            wordClicked = "Bank1";
        } else if (v == tvOCBC) {
            wordClicked = "Bank2";
        } else if (v == tvUOB) {
            wordClicked = "Bank3";
        }

        getMenuInflater().inflate(R.menu.menu_main, menu);

    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(wordClicked.equalsIgnoreCase("Bank1")){
            if (id == R.id.website) {
                Intent intentCall = new Intent (Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com/default.page?gclid=CjwKCAjwp7eUBhBeEiwAZbHwkc6qeptwfUrH0S8QeENPZnZssHSvwDUQ6zsu36NZrDG1_3tlbcXi5RoCdGYQAvD_BwE&gclsrc=aw.ds"));
                startActivity(intentCall);
                return true;
            } else if (id == R.id.contact) {
                Intent intentCall = new Intent (Intent.ACTION_DIAL, Uri.parse("tel: +1800-111-1111"));
                startActivity(intentCall);
                return true;
            } else {
                return false;
            }
        }

        if(wordClicked.equalsIgnoreCase("Bank2")){
            if (id == R.id.website) {
                Intent intentCall = new Intent (Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com/group/gateway.page"));
                startActivity(intentCall);
                return true;
            } else if (id == R.id.contact) {
                Intent intentCall = new Intent (Intent.ACTION_DIAL, Uri.parse("tel: +1800-363-3333"));
                startActivity(intentCall);
                return true;
            } else {
                return false;
            }
        }

        if(wordClicked.equalsIgnoreCase("Bank3")){
            if (id == R.id.website) {
                Intent intentCall = new Intent (Intent.ACTION_VIEW, Uri.parse("https://pib.uob.com.sg/PIBLogin/Public/processPreCapture.do?keyId=lpc"));
                startActivity(intentCall);
                return true;
            } else if (id == R.id.contact) {
                Intent intentCall = new Intent (Intent.ACTION_DIAL, Uri.parse("tel: +1800-222-2121"));
                startActivity(intentCall);
                return true;
            } else {
                return false;
            }
        }


        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvDBS.setText("DBS");
            tvOCBC.setText("OCBC");
            tvUOB.setText("UOB");
            return true;
        } else if (id == R.id.chineseSelection) {
            tvDBS.setText("星展银行");
            tvOCBC.setText("华侨银行");
            tvUOB.setText("大华银行");
            return true;
        } else {
            return false;
        }

    }

}