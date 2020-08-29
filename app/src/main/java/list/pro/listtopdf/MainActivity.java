package list.pro.listtopdf;

import android.content.Context;
import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



public class MainActivity extends AppCompatActivity implements Serializable{
    private RecyclerView re;
    private Adapter adapter;
    private Button btnSave,btnShare;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;
        btnSave = findViewById(R.id.saveBut);
        btnShare = findViewById(R.id.btnShare);
        re = findViewById(R.id.reitem2);
        final List<Data> data = new ArrayList<>();
       adapter = new Adapter(data,this);

       RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
       re.setLayoutManager(lm);
       re.setItemAnimator(new DefaultItemAnimator());
       re.setAdapter(adapter);

        // add data dummy
       data.add(new Data("01/11     ","Rp.100.000.000,00","TRSF E-BANKING DB0311/FTFVA/WS95011700 01/GO-PAY CUSTO","08181234567"));
       data.add(new Data("02/11     ","Rp.550.000,00","TRSF E-BANKING DB 0311/FTSCY/WS950112940 kado baby","ELENA SETIAWAN"));
       data.add(new Data("03/11     ","Rp.300.000,00","SWITCHING CR TANGGAL 06/11 TRANSFER DR MAYA CAROLINA JKT. PURI IN","1234456"));
       data.add(new Data("04/11     ","Rp.1.000.000.000,00","SWITCHING CR TANGGAL 06/11 TRANSFER DR MAYA CAROLINA JKT. PURI IN","adsa56"));
       data.add(new Data("05/11     ","Rp.100.000.000,00","TRSF E-BANKING DB0311/FTFVA/WS95011700 01/GO-PAY CUSTO","08181234567"));
       data.add(new Data("06/11     ","Rp.550.000,00","TRSF E-BANKING DB 0311/FTSCY/WS950112940 kado baby","ELENA SETIAWAN"));
       data.add(new Data("07/11     ","Rp.300.000,00","SWITCHING CR TANGGAL 06/11 TRANSFER DR MAYA CAROLINA JKT. PURI IN","1234456"));
       data.add(new Data("08/11     ","Rp.1.000.000.000,00","SWITCHING CR TANGGAL 06/11 TRANSFER DR MAYA CAROLINA JKT. PURI IN","adsa56"));
       data.add(new Data("09/11     ","Rp.100.000.000,00","TRSF E-BANKING DB0311/FTFVA/WS95011700 01/GO-PAY CUSTO","08181234567"));
       data.add(new Data("10/11     ","Rp.550.000,00","TRSF E-BANKING DB 0311/FTSCY/WS950112940 kado baby","ELENA SETIAWAN"));
       data.add(new Data("11/11     ","Rp.550.000,00","TRSF E-BANKING DB 0311/FTSCY/WS950112940 kado baby","ELENA SETIAWAN"));
        btnSave.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(context, PreviewActivity.class);
                intent.putExtra("myData", (Serializable) data);
                context.startActivity(intent);


            }
        });

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, FinalPrint.class);
                intent.putExtra("myData", (Serializable) data);
                Toast.makeText( MainActivity.this,"PDF Created Successfully!",
                        Toast.LENGTH_LONG).show();
                context.startActivity(intent);
            }
        });

    }

}
