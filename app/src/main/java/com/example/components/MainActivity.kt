package com.example.components

import android.app.ProgressDialog
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener, AdapterView.OnItemSelectedListener, SeekBar.OnSeekBarChangeListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners();
        loadSpinner();
    }

    override fun onClick(view: View) {
        val id = view.id;

        if (id == R.id.buttonToastme) {
            val toast = Toast.makeText(this, "Toast Notification", Toast.LENGTH_LONG);
            //toast.view.findViewById<TextView>(android.R.id.message).setTextColor(Color.GREEN);
            val inflator: LayoutInflater = layoutInflater;
            val toastLayout = inflator.inflate(R.layout.toast_custom, null);
            toast.view = toastLayout;

            val textview = toast.view.findViewById<TextView>(R.id.textMessage);
            textview.setTextColor(Color.RED);
            textview.text = ("TOAST ME!!!!")
            toast.show();
        } else if (id == R.id.buttonSnackme) {
            val snack = Snackbar.make(constraintLayout, "Snack bar notification!", Snackbar.LENGTH_SHORT);
            snack.show();
            // mudar a cor do texto
            //snack.view.findViewById<TextView>(android.support.design.R.id.snackbar_text)
        } else if (id == R.id.buttonGetSpinner) {
            //val value = spinnerDynamic.selectedItem.toString();
            val value = spinnerDynamic.selectedItemPosition.toString();
            Toast.makeText(this, value, Toast.LENGTH_LONG).show();
        } else if (id == R.id.buttonSetSpinner) {
            spinnerDynamic.setSelection(3);
        } else if (id === R.id.buttonProgress) {
            val progress: ProgressDialog = ProgressDialog(this);
            progress.setTitle("Titulo");
            progress.setMessage("Mensagem");
            progress.show();
            //progress.hide();
            //progress.dismiss();
        } else if (id === R.id.buttonGetSeek) {
            val value = seekValue.progress.toString();
            Toast.makeText(this, value, Toast.LENGTH_LONG).show();

        } else if (id == R.id.buttonSetSeak) {
            seekValue.progress = 10;
        }
    }

    private fun setListeners() {
        buttonToastme.setOnClickListener(this);
        buttonSnackme.setOnClickListener(this);
        buttonGetSpinner.setOnClickListener(this);
        buttonSetSpinner.setOnClickListener(this);
        buttonProgress.setOnClickListener(this);
        buttonGetSeek.setOnClickListener(this);
        buttonSetSeak.setOnClickListener(this);

        spinnerDynamic.onItemSelectedListener = this
        seekValue.setOnSeekBarChangeListener(this)
    }

    private fun loadSpinner() {
       val list = Mock.getList();
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, list);
        spinnerDynamic.adapter = adapter;
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
        val id = view.id;
        if(id == R.id.spinnerDynamic) {
            val value: String = parent.getItemAtPosition(position).toString();
            Toast.makeText(this, value, Toast.LENGTH_LONG).show();
        }
    }

    override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
        val id = seekBar.id;
        if (id == R.id.seekValue) {
            textSeekValue.text = progress.toString();
        }
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
