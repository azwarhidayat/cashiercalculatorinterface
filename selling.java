package azwar.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText edtname, edtcode, edtitem, edtprice, edtpay;
    private Button btnprocess;
    private Button btnreset;
    private Button btnexit;
    private TextView txtname;
    private TextView txtproductcode;
    private TextView txtitem;
    private TextView txtprice;
    private TextView txtpay;
    private TextView txtbonus;
    private TextView txttotal;
    private TextView txtproductname;
    private TextView txtchange;
    private TextView txtinfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Aze Shop");

        edtname = (EditText) findViewById(R.id.name);
        edtcode = (EditText) findViewById(R.id.productcode);
        edtitem = (EditText) findViewById(R.id.item);
        edtprice = (EditText) findViewById(R.id.price);
        edtpay = (EditText) findViewById(R.id.payment);
        btnprocess = (Button) findViewById(R.id.tombol1);
        btnreset = (Button) findViewById(R.id.tombol2);
        btnexit = (Button) findViewById(R.id.tombol3);
        txtname = (TextView) findViewById(R.id.name);
        txtproductcode = (TextView) findViewById(R.id.productcode);
        txtitem = (TextView) findViewById(R.id.item);
        txtprice = (TextView) findViewById(R.id.price);
        txtpay = (TextView) findViewById(R.id.payment);
        txtbonus = (TextView) findViewById(R.id.bonus);
        txttotal = (TextView) findViewById(R.id.total);
        txtproductname = (TextView) findViewById(R.id.product);
        txtchange = (TextView) findViewById(R.id.change);
        txtinfo = (TextView) findViewById(R.id.info);

        //memberikan action pada tombol proses

        btnprocess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String namapelanggan = edtname.getText().toString().trim();
                String kodebarang = edtcode.getText().toString().trim();
                String jumlahbeli = edtitem.getText().toString().trim();
                String harga = edtprice.getText().toString().trim();
                String uangbayar = edtpay.getText().toString().trim();

                double jb = Double.parseDouble(jumlahbeli);
                double h = Double.parseDouble(harga);
                double ub = Double.parseDouble(uangbayar);
                double total = (jb * h);
                txttotal.setText("Total : " + total);

                //pemberian if dan else untuk aturan pemberian bonus
                if (kodebarang.equals("AA1")) {
                    txtproductname.setText("Product : Lamp");
                } else if (kodebarang.equals("BB2")) {
                    txtproductname.setText("Product : Stove");
                } else if (kodebarang.equals("CC3")) {
                    txtproductname.setText("Product : Bag");
                } else {
                    txtproductname.setText("Product : Not Found");
                }
                if (total >=200000){
                    txtbonus.setText("Bonus : Voucher");
                } else if (total >=50000){
                    txtbonus.setText("Bonus : Voucher");
                } else  if (total >=40000){
                    txtbonus.setText("Bonus : Voucher");
                } else {
                    txtbonus.setText("Bonus : No Bonus");
                }
                double uangkembalian = (ub - total);

                if (ub < total){
                    txtinfo.setText("Info : Insufficient Funds Rp " + (-uangkembalian));
                    txtchange.setText("Change : Rp 0" );
                }else{
                    txtinfo.setText("Info : Waiting for Change");
                    txtchange.setText("Change : " + uangkembalian);
                }


                //memberikan action pada tombol reset data
            }
        });
        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtname.setText(" ");
                txtproductcode.setText(" ");
                txttotal.setText(" Total : Rp 0");
                txtprice.setText(" ");
                txtproductname.setText("Product :  ");
                txtpay.setText(" ");
                txtchange.setText("Change : Rp 0");
                txtbonus.setText("Bonus : - ");
                txtitem.setText(" ");
                txtinfo.setText("Info : - ");

                Toast.makeText(getApplicationContext(),"Data has been reset", Toast.LENGTH_LONG).show();

                // memberikan action pada tombol keluar
            }
        });
        btnexit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                moveTaskToBack(true);
            }
        });
    }
}