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
import android.view.View;
import android.widget.TextView;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FinalPrint extends AppCompatActivity implements Serializable {
    private ConstraintLayout finalpdf;
    private  AdapterFinal adapter3;
    RecyclerView finallist;
    List<Data> finaldata = new ArrayList<>();
    Context mContext3;
    TextView limit;
    int iterasi,maxpage,mod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finalprint);
        finallist = findViewById(R.id.listFinal);
        limit = findViewById(R.id.limit);


        mContext3 = this;
        finaldata = (List<Data>) getIntent().getSerializableExtra("myData");
        finalpdf = findViewById(R.id.finalprint);
        adapter3 = new AdapterFinal(finaldata,mContext3);
        maxpage = (finaldata.size()/6);
        mod = (finaldata.size()%6);

        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        finallist.setLayoutManager(lm);
        finallist.setItemAnimator(new DefaultItemAnimator());
        finallist.setAdapter(adapter3);
        finalpdf.measure(1920,1080);
        finalpdf.layout(0,0,1920,1080);



        final File file = new File(getBaseContext().getExternalCacheDir().getPath()+"/"+"PDFFinal"+".pdf");


        PrintedPdfDocument document = new PrintedPdfDocument(FinalPrint.this, getPrintAttributes());
        View content =  finalpdf;

    if(mod >= 1){
        maxpage +=1;
        for(iterasi = 1;iterasi<=maxpage;iterasi++) {
            //page creation
            PdfDocument.Page page = document.startPage(iterasi);
            limit.setText(iterasi+"/"+(maxpage));
            content.draw(page.getCanvas());
            document.finishPage(page);
            if(finaldata.size() %6 >= 0) {
                if (finaldata.size() == 5){
                    finallist.setItemAnimator(new DefaultItemAnimator());
                    finallist.setAdapter(adapter3);
                    finalpdf.measure(1920, 1080);
                    finalpdf.layout(0, 0, 1920, 1080);

                }
                else if (finaldata.size() == 4){
                    finallist.setItemAnimator(new DefaultItemAnimator());
                    finallist.setAdapter(adapter3);
                    finalpdf.measure(1920, 1080);
                    finalpdf.layout(0, 0, 1920, 1080);

                }
                else if (finaldata.size() == 3)
                {
                    finallist.setItemAnimator(new DefaultItemAnimator());
                    finallist.setAdapter(adapter3);
                    finalpdf.measure(1920, 1080);
                    finalpdf.layout(0, 0, 1920, 1080);
                }
                else if (finaldata.size() == 2)
                {
                    finallist.setItemAnimator(new DefaultItemAnimator());
                    finallist.setAdapter(adapter3);
                    finalpdf.measure(1920, 1080);
                    finalpdf.layout(0, 0, 1920, 1080);
                }
                else if (finaldata.size() == 1)
                {
                    finallist.setItemAnimator(new DefaultItemAnimator());
                    finallist.setAdapter(adapter3);
                    finalpdf.measure(1920, 1080);
                    finalpdf.layout(0, 0, 1920, 1080);
                }
                else {
                    removeItem(0);
                    removeItem(0);
                    removeItem(0);
                    removeItem(0);
                    removeItem(0);
                    removeItem(0);

                    finallist.setItemAnimator(new DefaultItemAnimator());
                    finallist.setAdapter(adapter3);
                    finalpdf.measure(1920, 1080);
                    finalpdf.layout(0, 0, 1920, 1080);
                }

            }

        }

    }
    else {
        for (iterasi = 1; iterasi <= maxpage; iterasi++) {
            //page creation
            PdfDocument.Page page = document.startPage(iterasi);
            limit.setText(iterasi + "/" + maxpage);
            content.draw(page.getCanvas());
            document.finishPage(page);
            if (finaldata.size() % 6 >= 0) {
                if (finaldata.size() == 5){
                    finallist.setItemAnimator(new DefaultItemAnimator());
                    finallist.setAdapter(adapter3);
                    finalpdf.measure(1920, 1080);
                    finalpdf.layout(0, 0, 1920, 1080);

                }
                else if (finaldata.size() == 4){
                    finallist.setItemAnimator(new DefaultItemAnimator());
                    finallist.setAdapter(adapter3);
                    finalpdf.measure(1920, 1080);
                    finalpdf.layout(0, 0, 1920, 1080);

                }
                else if (finaldata.size() == 3) {
                    finallist.setItemAnimator(new DefaultItemAnimator());
                    finallist.setAdapter(adapter3);
                    finalpdf.measure(1920, 1080);
                    finalpdf.layout(0, 0, 1920, 1080);
                } else if (finaldata.size() == 2) {
                    finallist.setItemAnimator(new DefaultItemAnimator());
                    finallist.setAdapter(adapter3);
                    finalpdf.measure(1920, 1080);
                    finalpdf.layout(0, 0, 1920, 1080);
                } else if (finaldata.size() == 1) {
                    finallist.setItemAnimator(new DefaultItemAnimator());
                    finallist.setAdapter(adapter3);
                    finalpdf.measure(1920, 1080);
                    finalpdf.layout(0, 0, 1920, 1080);
                } else {
                    removeItem(0);
                    removeItem(0);
                    removeItem(0);
                    removeItem(0);
                    removeItem(0);
                    removeItem(0);
                    finallist.setItemAnimator(new DefaultItemAnimator());
                    finallist.setAdapter(adapter3);
                    finalpdf.measure(1920, 1080);
                    finalpdf.layout(0, 0, 1920, 1080);
                }


            }
        }
    }



        try {
            file.createNewFile();
            FileOutputStream outputstream =  new FileOutputStream(file);
            document.writeTo(outputstream);

            outputstream.flush();
            outputstream.close();
        } catch (IOException e) {

            e.printStackTrace();
        }
        document.close();
        this.finish();



    }

    private PrintAttributes getPrintAttributes() {
        PrintAttributes.Builder builder = new PrintAttributes.Builder().setMediaSize(PrintAttributes.MediaSize.ISO_A2)
                .setResolution(new PrintAttributes.Resolution("res1","Resolution",50,50)).setMinMargins(new PrintAttributes.Margins(1, 1, 1, 1));
        PrintAttributes printAttributes = builder.build();
        return printAttributes;
    }

    public void removeItem(int position){
        finaldata.remove(position);
        adapter3.notifyDataSetChanged();
    }

}
