package com.example.menyular

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.PopupMenu
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var btnPopupMenu: MaterialButton
    private lateinit var editText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        editText = findViewById(R.id.editText)
        btnPopupMenu = findViewById(R.id.btnPopUp)

        editText.addTextChangedListener {
            textView.text = it.toString()
        }

        popupMenu()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.my_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.clear -> {
                textView.text = ""
                editText.text.clear()
            }
            R.id.exit -> finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun popupMenu(){
        btnPopupMenu.setOnClickListener {
            val popupMenu = PopupMenu(this@MainActivity, it)
            popupMenu.menuInflater.inflate(R.menu.my_menu, popupMenu.menu)

            popupMenu.setOnMenuItemClickListener {
                when(it.itemId){
                    R.id.clear -> {
                        textView.text = ""
                        editText.text.clear()
                    }
                    R.id.exit -> finish()
                }

                true
            }
            popupMenu.show()
        }
    }
}