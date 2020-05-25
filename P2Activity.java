package edu.ufl.cise.os.p2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.app.Activity;

public class P2Activity extends Activity {
    private TextView tv, text2;
    private Button button;

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p2);

        // Example of a call to a native method
        final TextView tv = (TextView) findViewById(R.id.displayBox);
        final TextView text2 = (TextView) findViewById(R.id.filenameBox);
        Button button = (Button) findViewById(R.id.submitButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                CharSequence buff = text2.getText();
                String buff2 = buff.toString();
                String buff3 = stringFromJNI(buff2);
                tv.setText(buff3);
            }
        });


    }



    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI(String pathname);

}
