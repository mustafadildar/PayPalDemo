package pk.edu.pugc.paypaldemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class PaymentDetails extends AppCompatActivity {
TextView id,amt,sts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_details);

        id= (TextView) findViewById(R.id.txtid);
        amt=(TextView) findViewById(R.id.txtamount);
        sts=(TextView) findViewById(R.id.txtstatus);

        Intent intent=getIntent();


            try {
                JSONObject jsonObject=new JSONObject(intent.getStringExtra("PaymentDetails"));
                showDetails(jsonObject.getJSONObject("response"),intent.getStringExtra("PaymentAmount"));
            } catch (JSONException e) {
                e.printStackTrace();
            }


    }

    private void showDetails(JSONObject response, String paymentAmount) {

        try {
            id.setText(response.getString("id"));
            amt.setText(response.getString(String.format("$%s",paymentAmount)));
            sts.setText(response.getString("state"));


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}