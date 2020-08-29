package list.pro.listtopdf;

import java.io.Serializable;

public class Data implements Serializable {
    public String tanggal,jml,detail,kontak;

    public Data(String tanggal, String  jml, String detail, String kontak){
         this.tanggal = tanggal;
         this.jml = jml;
         this.detail = detail;
         this.kontak = kontak;
    }
}
