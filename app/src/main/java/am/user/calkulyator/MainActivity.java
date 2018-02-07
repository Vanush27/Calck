package am.user.calkulyator;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;


public class MainActivity extends AppCompatActivity {
    private Button button0, button1, button2, button3, button4, button5, button6, button7, button8,
            button9, buttonGumarum, buttonBazm, buttonHanum, buttonBajn, buttonHavasar, delete,
            ket, load, memory;
    private ImageButton backspace;
    private EditText editText;

    double arjeq1, arjeq2;
    boolean mGumar, mHanum, mBazmapatkum, mBajanum;

    SharedPreferences sPref;

    final String text_seved = "mmm";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        buttonGumarum = (Button) findViewById(R.id.buttonGumarum);
        buttonBazm = (Button) findViewById(R.id.buttonBazm);
        buttonBajn = (Button) findViewById(R.id.buttonBaj);
        buttonHanum = (Button) findViewById(R.id.buttonHanum);
        buttonHavasar = (Button) findViewById(R.id.buttonHavasar);
        delete = (Button) findViewById(R.id.buttonDelete);
        ket = (Button) findViewById(R.id.buttonKet);
        backspace = (ImageButton) findViewById(R.id.buttonBack);
        editText = (EditText) findViewById(R.id.text1);
        final String regexp = "([0-9]*+(\\.)+([0-9]+)?)";

        InputFilter filter = new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                if (source != null) {
                    String incommingValue = source.toString();
                    if (incommingValue.length() > 1 && incommingValue.charAt(end - 2) == '.' && incommingValue.charAt(end - 1) == '.') {
                        return incommingValue.replace(".", "");
                    }
                }
                return null;
            }
        };
        editText.setFilters(new InputFilter[]{filter});

        memory = (Button) findViewById(R.id.buttonMemory);
        load = (Button) findViewById(R.id.buttonload);


        memory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sevText();

            }
        });
        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadText();
            }
        });
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString() + "0");
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString() + "1");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString() + "2");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString() + "3");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString() + "4");
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString() + "5");
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString() + "6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString() + "7");
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString() + "8");
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString() + "9");
            }
        });


        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int length = editText.getText().length();
                editText.setText(editText.getText().toString().substring(0, length > 0 ? editText.getText().length() - 1 : 0));

            }
        });


        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
            }
        });

        ket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString() + ".");
            }
        });

        buttonGumarum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText == null) {
                    editText.setText("");
                } else {
                    try {
                        if (!editText.getText().equals("")) {
                            arjeq1 = Double.parseDouble(editText.getText() + "");
                        }
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                    mGumar = true;
                    editText.setText(null);

                }
            }

        });

        buttonHanum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (!editText.getText().equals("")) {
                        arjeq1 = Double.parseDouble(editText.getText() + "");
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }

                mHanum = true;
                editText.setText(null);
            }
        });

        buttonBajn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (!editText.getText().equals("")) {
                        arjeq1 = Double.parseDouble(editText.getText() + "");
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }

                mBajanum = true;
                editText.setText(null);
            }
        });
        buttonBazm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (editText.getText().equals("")) {
                        arjeq1 = Double.parseDouble(editText.getText() + "");
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }

                mBazmapatkum = true;
                editText.setText(null);
            }
        });

        buttonHavasar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    if (editText.getText().equals("")) {
                        buttonHavasar.setText(editText.getText().toString() + "");
                    }
                    arjeq2 = Double.parseDouble(editText.getText() + "");

                    if (mGumar) {
                        double sum = arjeq1 + arjeq2;
                        if (sum == (int) sum) {
                            sum = (int) sum;
                        }

                        editText.setText(sum + "");
                        mGumar = false;
                    }

                    if (mHanum) {
                        editText.setText(arjeq1 - arjeq2 + "");
                        mHanum = false;
                    }

                    if (mBazmapatkum) {
                        editText.setText(arjeq1 * arjeq2 + "");
                        mBazmapatkum = false;
                    }
                    if (mBajanum) {
                        editText.setText(arjeq1 / arjeq2 + "");
                        mBajanum = false;
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();

                }
            }
        });


    }

    private void sevText() {
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sPref.edit();
        editor.putString(text_seved, editText.getText().toString());
        editor.apply();

    }

    private void loadText() {
        sPref = getPreferences(MODE_PRIVATE);
        String sevedText = sPref.getString(text_seved, "");
        editText.setText(sevedText);

    }
}