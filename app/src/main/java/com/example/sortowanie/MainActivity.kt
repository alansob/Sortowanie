package com.example.sortowanie

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*

class MainActivity : AppCompatActivity() {

    lateinit var start: Button
    lateinit var txtnumb: EditText
    lateinit var list1: ListView
    lateinit var list2: ListView
    var arraySize = 0


    fun Sort(array: IntArray): IntArray{
        var swap: Boolean
        do{
            swap = false
            for (i in 0 until array.size -1){
                if(array[i] > array[i + 1]){
                    val temp = array[i]
                    array[i] = array[i + 1]
                    array [i + 1] = temp
                    swap = true
                }
            }
        }while (swap)
        return array
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        start = findViewById(R.id.button)
        txtnumb = findViewById(R.id.editTextNumber)
        list1 = findViewById(R.id.listView1)
        list2 = findViewById(R.id.listView2)

        start.setOnClickListener {
            if(txtnumb.text.isNotEmpty()){
                arraySize = txtnumb.text.toString().toInt()
                Log.d("dane,", "wielkość tablicy " + arraySize)

                var tablica = IntArray(arraySize)

                for(i in 0..arraySize-1){
                    tablica[i]=(0..1000).random()
                    Log.d("dane", "elementy tablicy" + i + ":" + tablica[i].toString())
                }

                val listBefore = tablica.toList()
                val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listBefore)
                list1.adapter = adapter

                var tablicaAf = IntArray(arraySize)
                tablicaAf = tablica

                Sort(tablicaAf)

                val listAfter = tablicaAf.toList()
                val adapter2 = ArrayAdapter(this,  android.R.layout.simple_list_item_1,listAfter)
                list2.adapter = adapter2

            }else{
                Log.d("dane", "nie wciśnięto")
                Toast.makeText(this,"uzupełnij luki", Toast.LENGTH_SHORT)
            }
        }
    }
}