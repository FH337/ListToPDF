package list.pro.listtopdf;


import android.content.Context;

import android.graphics.pdf.PdfDocument;

import android.os.Bundle;

import android.print.PrintAttributes;
import android.print.pdf.PrintedPdfDocument;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;



import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class PreviewActivity extends AppCompatActivity implements Serializable {
    private Button butPrint;
    private ConstraintLayout pdf;
    private  Adapter adapter2;

    RecyclerView list;
        List<Data> data = new ArrayList<>() ;
        Context mContext2;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.preprint);
            ;
        pdf = findViewById(R.id.pdfLayout);
        butPrint = findViewById(R.id.print);
        list = findViewById(R.id.listData);
        data = (List<Data>) getIntent().getSerializableExtra("myData");
        mContext2 = this;
        adapter2 = new Adapter(data,mContext2);

        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        list.setLayoutManager(lm);
        list.setItemAnimator(new DefaultItemAnimator());
        list.setAdapter(adapter2);



        final File file = new File(getBaseContext().getExternalCacheDir().getPath()+"/"+"PDF1"+".pdf");
        butPrint.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                PrintedPdfDocument document = new PrintedPdfDocument(PreviewActivity.this, getPrintAttributes());


                PdfDocument.Page page = document.startPage(1);


                View content =  pdf;
                content.draw(page.getCanvas());


                document.finishPage(page);



                try {
                    file.createNewFile();
                    FileOutputStream outputstream =  new FileOutputStream(file);
                    document.writeTo(outputstream);
                    Toast.makeText(PreviewActivity.this, "PDF Created Successfully!",
                            Toast.LENGTH_LONG).show();
                    outputstream.flush();
                    outputstream.close();
                } catch (IOException e) {

                    e.printStackTrace();
                }


                document.close();

             }
        });


    }

    private PrintAttributes getPrintAttributes() {
        PrintAttributes.Builder builder = new PrintAttributes.Builder().setMediaSize(PrintAttributes.MediaSize.ISO_A2)
                .setResolution(new PrintAttributes.Resolution("res1","Resolution",1920,1080)).setMinMargins(new PrintAttributes.Margins(1, 1, 1, 1));
        PrintAttributes printAttributes = builder.build();
        return printAttributes;
    }


}