package list.pro.listtopdf;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.Holder> {

    private List<Data> listData;
    private Context mContext;


    public Adapter(List<Data> listData, Context mContext) {
        this.listData = listData;
        this.mContext = mContext;
    }


    public class Holder extends RecyclerView.ViewHolder {
        public TextView tanggal, jml, detail, kontak;

        public Holder(View item)

        {
            super(item);

            tanggal = item.findViewById(R.id.tgl);
            jml = item.findViewById(R.id.jml);
            detail = item.findViewById(R.id.data);
            kontak = item.findViewById(R.id.kontak);


        }
}


@Override
public Holder onCreateViewHolder(ViewGroup parent, int viewType){
    View item = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.itemlist,parent,false);
    return new Holder(item);
}

@Override
public void onBindViewHolder(Holder holder, int position){
    Data data = listData.get(position);
    holder.tanggal.setText(data.tanggal);
    holder.jml.setText(data.jml);
    holder.detail.setText(data.detail);
    holder.kontak.setText(data.kontak);


}

    @Override
    public int getItemCount() {

        return listData.size();
    }

}