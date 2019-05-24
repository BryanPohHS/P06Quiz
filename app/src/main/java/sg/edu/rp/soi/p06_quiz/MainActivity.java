package sg.edu.rp.soi.p06_quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    //Declare fields
    EditText etnum1, etnum2;
    TextView tvOperation, tvResult;
    Button btnReset;

    int result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Linking fields
        etnum1 = findViewById(R.id.etNum1);
        etnum2 = findViewById(R.id.etNum2);
        tvOperation = findViewById(R.id.tvOperation);
        tvResult = findViewById(R.id.tvResult);
        btnReset = findViewById(R.id.btnReset);

        //Register context menu for buttons
        registerForContextMenu(tvOperation);

        //Reset Button
        btnReset.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                etnum1.setText("");
                etnum2.setText("");
                tvResult.setText("");
            }
        });


    }

    //Set context menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0, "+");
        menu.add(0,1,1,"-");
    }

    //on selection of context menu
    @Override
    public boolean onContextItemSelected(MenuItem item)
    {
        String value= etnum1.getText().toString();
        int finalValue = Integer.parseInt(value);

        String value2= etnum2.getText().toString();
        int finalValue2 = Integer.parseInt(value2);

        if(item.getItemId() == 0) // + operator
        {
            result =  finalValue + finalValue2;
        }
        else if(item.getItemId() == 1)
        {
            result =  finalValue - finalValue2;
        }
        else
        {
            tvResult.setText("error");
        }
        tvResult.setText(String.valueOf(result));

        return super.onContextItemSelected(item);
    }



}
